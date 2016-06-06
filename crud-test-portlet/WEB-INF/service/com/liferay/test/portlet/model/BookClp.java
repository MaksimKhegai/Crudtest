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

import com.liferay.test.portlet.service.BookLocalServiceUtil;
import com.liferay.test.portlet.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kmv
 */
public class BookClp extends BaseModelImpl<Book> implements Book {
	public BookClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Book.class;
	}

	@Override
	public String getModelClassName() {
		return Book.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _bookId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBookId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _bookId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("genreId", getGenreId());
		attributes.put("publisherId", getPublisherId());
		attributes.put("authorId", getAuthorId());
		attributes.put("name", getName());
		attributes.put("releaseDate", getReleaseDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long genreId = (Long)attributes.get("genreId");

		if (genreId != null) {
			setGenreId(genreId);
		}

		Long publisherId = (Long)attributes.get("publisherId");

		if (publisherId != null) {
			setPublisherId(publisherId);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String releaseDate = (String)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}
	}

	@Override
	public long getBookId() {
		return _bookId;
	}

	@Override
	public void setBookId(long bookId) {
		_bookId = bookId;

		if (_bookRemoteModel != null) {
			try {
				Class<?> clazz = _bookRemoteModel.getClass();

				Method method = clazz.getMethod("setBookId", long.class);

				method.invoke(_bookRemoteModel, bookId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGenreId() {
		return _genreId;
	}

	@Override
	public void setGenreId(long genreId) {
		_genreId = genreId;

		if (_bookRemoteModel != null) {
			try {
				Class<?> clazz = _bookRemoteModel.getClass();

				Method method = clazz.getMethod("setGenreId", long.class);

				method.invoke(_bookRemoteModel, genreId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublisherId() {
		return _publisherId;
	}

	@Override
	public void setPublisherId(long publisherId) {
		_publisherId = publisherId;

		if (_bookRemoteModel != null) {
			try {
				Class<?> clazz = _bookRemoteModel.getClass();

				Method method = clazz.getMethod("setPublisherId", long.class);

				method.invoke(_bookRemoteModel, publisherId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAuthorId() {
		return _authorId;
	}

	@Override
	public void setAuthorId(long authorId) {
		_authorId = authorId;

		if (_bookRemoteModel != null) {
			try {
				Class<?> clazz = _bookRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthorId", long.class);

				method.invoke(_bookRemoteModel, authorId);
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

		if (_bookRemoteModel != null) {
			try {
				Class<?> clazz = _bookRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_bookRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getReleaseDate() {
		return _releaseDate;
	}

	@Override
	public void setReleaseDate(String releaseDate) {
		_releaseDate = releaseDate;

		if (_bookRemoteModel != null) {
			try {
				Class<?> clazz = _bookRemoteModel.getClass();

				Method method = clazz.getMethod("setReleaseDate", String.class);

				method.invoke(_bookRemoteModel, releaseDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBookRemoteModel() {
		return _bookRemoteModel;
	}

	public void setBookRemoteModel(BaseModel<?> bookRemoteModel) {
		_bookRemoteModel = bookRemoteModel;
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

		Class<?> remoteModelClass = _bookRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bookRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BookLocalServiceUtil.addBook(this);
		}
		else {
			BookLocalServiceUtil.updateBook(this);
		}
	}

	@Override
	public Book toEscapedModel() {
		return (Book)ProxyUtil.newProxyInstance(Book.class.getClassLoader(),
			new Class[] { Book.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BookClp clone = new BookClp();

		clone.setBookId(getBookId());
		clone.setGenreId(getGenreId());
		clone.setPublisherId(getPublisherId());
		clone.setAuthorId(getAuthorId());
		clone.setName(getName());
		clone.setReleaseDate(getReleaseDate());

		return clone;
	}

	@Override
	public int compareTo(Book book) {
		long primaryKey = book.getPrimaryKey();

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

		if (!(obj instanceof BookClp)) {
			return false;
		}

		BookClp book = (BookClp)obj;

		long primaryKey = book.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{bookId=");
		sb.append(getBookId());
		sb.append(", genreId=");
		sb.append(getGenreId());
		sb.append(", publisherId=");
		sb.append(getPublisherId());
		sb.append(", authorId=");
		sb.append(getAuthorId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", releaseDate=");
		sb.append(getReleaseDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.test.portlet.model.Book");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>bookId</column-name><column-value><![CDATA[");
		sb.append(getBookId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>genreId</column-name><column-value><![CDATA[");
		sb.append(getGenreId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publisherId</column-name><column-value><![CDATA[");
		sb.append(getPublisherId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>authorId</column-name><column-value><![CDATA[");
		sb.append(getAuthorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>releaseDate</column-name><column-value><![CDATA[");
		sb.append(getReleaseDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _bookId;
	private long _genreId;
	private long _publisherId;
	private long _authorId;
	private String _name;
	private String _releaseDate;
	private BaseModel<?> _bookRemoteModel;
	private Class<?> _clpSerializerClass = com.liferay.test.portlet.service.ClpSerializer.class;
}