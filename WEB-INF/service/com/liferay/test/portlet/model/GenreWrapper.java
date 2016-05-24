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
 * This class is a wrapper for {@link Genre}.
 * </p>
 *
 * @author kmv
 * @see Genre
 * @generated
 */
public class GenreWrapper implements Genre, ModelWrapper<Genre> {
	public GenreWrapper(Genre genre) {
		_genre = genre;
	}

	@Override
	public Class<?> getModelClass() {
		return Genre.class;
	}

	@Override
	public String getModelClassName() {
		return Genre.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("genreId", getGenreId());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long genreId = (Long)attributes.get("genreId");

		if (genreId != null) {
			setGenreId(genreId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	* Returns the primary key of this genre.
	*
	* @return the primary key of this genre
	*/
	@Override
	public long getPrimaryKey() {
		return _genre.getPrimaryKey();
	}

	/**
	* Sets the primary key of this genre.
	*
	* @param primaryKey the primary key of this genre
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_genre.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the genre ID of this genre.
	*
	* @return the genre ID of this genre
	*/
	@Override
	public long getGenreId() {
		return _genre.getGenreId();
	}

	/**
	* Sets the genre ID of this genre.
	*
	* @param genreId the genre ID of this genre
	*/
	@Override
	public void setGenreId(long genreId) {
		_genre.setGenreId(genreId);
	}

	/**
	* Returns the name of this genre.
	*
	* @return the name of this genre
	*/
	@Override
	public java.lang.String getName() {
		return _genre.getName();
	}

	/**
	* Sets the name of this genre.
	*
	* @param name the name of this genre
	*/
	@Override
	public void setName(java.lang.String name) {
		_genre.setName(name);
	}

	@Override
	public boolean isNew() {
		return _genre.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_genre.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _genre.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_genre.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _genre.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _genre.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_genre.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _genre.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_genre.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_genre.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_genre.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GenreWrapper((Genre)_genre.clone());
	}

	@Override
	public int compareTo(com.liferay.test.portlet.model.Genre genre) {
		return _genre.compareTo(genre);
	}

	@Override
	public int hashCode() {
		return _genre.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.test.portlet.model.Genre> toCacheModel() {
		return _genre.toCacheModel();
	}

	@Override
	public com.liferay.test.portlet.model.Genre toEscapedModel() {
		return new GenreWrapper(_genre.toEscapedModel());
	}

	@Override
	public com.liferay.test.portlet.model.Genre toUnescapedModel() {
		return new GenreWrapper(_genre.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _genre.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _genre.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_genre.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GenreWrapper)) {
			return false;
		}

		GenreWrapper genreWrapper = (GenreWrapper)obj;

		if (Validator.equals(_genre, genreWrapper._genre)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Genre getWrappedGenre() {
		return _genre;
	}

	@Override
	public Genre getWrappedModel() {
		return _genre;
	}

	@Override
	public void resetOriginalValues() {
		_genre.resetOriginalValues();
	}

	private Genre _genre;
}