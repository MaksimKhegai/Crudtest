/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.test.portlet.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.test.portlet.service.ClpSerializer;
import com.liferay.test.portlet.service.PublisherLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kmv
 */
public class PublisherClp extends BaseModelImpl<Publisher> implements Publisher {
	public PublisherClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Publisher.class;
	}

	@Override
	public String getModelClassName() {
		return Publisher.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publisherId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublisherId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publisherId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publisherId", getPublisherId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publisherId = (Long)attributes.get("publisherId");

		if (publisherId != null) {
			setPublisherId(publisherId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public long getPublisherId() {
		return _publisherId;
	}

	@Override
	public void setPublisherId(long publisherId) {
		_publisherId = publisherId;

		if (_publisherRemoteModel != null) {
			try {
				Class<?> clazz = _publisherRemoteModel.getClass();

				Method method = clazz.getMethod("setPublisherId", long.class);

				method.invoke(_publisherRemoteModel, publisherId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_publisherRemoteModel != null) {
			try {
				Class<?> clazz = _publisherRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_publisherRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublisherRemoteModel() {
		return _publisherRemoteModel;
	}

	public void setPublisherRemoteModel(BaseModel<?> publisherRemoteModel) {
		_publisherRemoteModel = publisherRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _publisherRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_publisherRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublisherLocalServiceUtil.addPublisher(this);
		}
		else {
			PublisherLocalServiceUtil.updatePublisher(this);
		}
	}

	@Override
	public Publisher toEscapedModel() {
		return (Publisher)ProxyUtil.newProxyInstance(Publisher.class.getClassLoader(),
			new Class[] { Publisher.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublisherClp clone = new PublisherClp();

		clone.setPublisherId(getPublisherId());
		clone.setName(getName());

		return clone;
	}

	@Override
	public int compareTo(Publisher publisher) {
		long primaryKey = publisher.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublisherClp)) {
			return false;
		}

		PublisherClp publisher = (PublisherClp)obj;

		long primaryKey = publisher.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{publisherId=");
		sb.append(getPublisherId());
		sb.append(", name=");
		sb.append(getName());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(10);

		sb.append("<model><model-name>");
		sb.append("com.liferay.test.portlet.model.Publisher");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publisherId</column-name><column-value><![CDATA[");
		sb.append(getPublisherId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _publisherId;
	private String _name;
	private BaseModel<?> _publisherRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.test.portlet.service.ClpSerializer.class;
}