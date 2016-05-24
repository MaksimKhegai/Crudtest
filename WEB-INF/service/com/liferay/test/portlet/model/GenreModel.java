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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the Genre service. Represents a row in the &quot;TB_Genre&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.liferay.test.portlet.model.impl.GenreModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.liferay.test.portlet.model.impl.GenreImpl}.
 * </p>
 *
 * @author kmv
 * @see Genre
 * @see com.liferay.test.portlet.model.impl.GenreImpl
 * @see com.liferay.test.portlet.model.impl.GenreModelImpl
 * @generated
 */
public interface GenreModel extends BaseModel<Genre> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a genre model instance should use the {@link Genre} interface instead.
	 */

	/**
	 * Returns the primary key of this genre.
	 *
	 * @return the primary key of this genre
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this genre.
	 *
	 * @param primaryKey the primary key of this genre
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the genre ID of this genre.
	 *
	 * @return the genre ID of this genre
	 */
	public long getGenreId();

	/**
	 * Sets the genre ID of this genre.
	 *
	 * @param genreId the genre ID of this genre
	 */
	public void setGenreId(long genreId);

	/**
	 * Returns the name of this genre.
	 *
	 * @return the name of this genre
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this genre.
	 *
	 * @param name the name of this genre
	 */
	public void setName(String name);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(com.liferay.test.portlet.model.Genre genre);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.liferay.test.portlet.model.Genre> toCacheModel();

	@Override
	public com.liferay.test.portlet.model.Genre toEscapedModel();

	@Override
	public com.liferay.test.portlet.model.Genre toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}