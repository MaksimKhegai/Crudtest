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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Publisher}.
 * </p>
 *
 * @author kmv
 * @see Publisher
 * @generated
 */
public class PublisherWrapper implements Publisher, ModelWrapper<Publisher> {
	public PublisherWrapper(Publisher publisher) {
		_publisher = publisher;
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

	/**
	* Returns the primary key of this publisher.
	*
	* @return the primary key of this publisher
	*/
	@Override
	public long getPrimaryKey() {
		return _publisher.getPrimaryKey();
	}

	/**
	* Sets the primary key of this publisher.
	*
	* @param primaryKey the primary key of this publisher
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_publisher.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the publisher ID of this publisher.
	*
	* @return the publisher ID of this publisher
	*/
	@Override
	public long getPublisherId() {
		return _publisher.getPublisherId();
	}

	/**
	* Sets the publisher ID of this publisher.
	*
	* @param publisherId the publisher ID of this publisher
	*/
	@Override
	public void setPublisherId(long publisherId) {
		_publisher.setPublisherId(publisherId);
	}

	/**
	* Returns the name of this publisher.
	*
	* @return the name of this publisher
	*/
	@Override
	public java.lang.String getName() {
		return _publisher.getName();
	}

	/**
	* Sets the name of this publisher.
	*
	* @param name the name of this publisher
	*/
	@Override
	public void setName(java.lang.String name) {
		_publisher.setName(name);
	}

	@Override
	public boolean isNew() {
		return _publisher.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_publisher.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _publisher.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_publisher.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _publisher.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _publisher.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_publisher.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _publisher.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_publisher.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_publisher.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_publisher.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PublisherWrapper((Publisher)_publisher.clone());
	}

	@Override
	public int compareTo(com.liferay.test.portlet.model.Publisher publisher) {
		return _publisher.compareTo(publisher);
	}

	@Override
	public int hashCode() {
		return _publisher.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.test.portlet.model.Publisher> toCacheModel() {
		return _publisher.toCacheModel();
	}

	@Override
	public com.liferay.test.portlet.model.Publisher toEscapedModel() {
		return new PublisherWrapper(_publisher.toEscapedModel());
	}

	@Override
	public com.liferay.test.portlet.model.Publisher toUnescapedModel() {
		return new PublisherWrapper(_publisher.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _publisher.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _publisher.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_publisher.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublisherWrapper)) {
			return false;
		}

		PublisherWrapper publisherWrapper = (PublisherWrapper)obj;

		if (Validator.equals(_publisher, publisherWrapper._publisher)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Publisher getWrappedPublisher() {
		return _publisher;
	}

	@Override
	public Publisher getWrappedModel() {
		return _publisher;
	}

	@Override
	public void resetOriginalValues() {
		_publisher.resetOriginalValues();
	}

	private Publisher _publisher;
}