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

package com.liferay.test.portlet.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.test.portlet.model.Genre;

/**
 * The persistence interface for the genre service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kmv
 * @see GenrePersistenceImpl
 * @see GenreUtil
 * @generated
 */
public interface GenrePersistence extends BasePersistence<Genre> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GenreUtil} to access the genre persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the genre in the entity cache if it is enabled.
	*
	* @param genre the genre
	*/
	public void cacheResult(com.liferay.test.portlet.model.Genre genre);

	/**
	* Caches the genres in the entity cache if it is enabled.
	*
	* @param genres the genres
	*/
	public void cacheResult(
		java.util.List<com.liferay.test.portlet.model.Genre> genres);

	/**
	* Creates a new genre with the primary key. Does not add the genre to the database.
	*
	* @param genreId the primary key for the new genre
	* @return the new genre
	*/
	public com.liferay.test.portlet.model.Genre create(long genreId);

	/**
	* Removes the genre with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genreId the primary key of the genre
	* @return the genre that was removed
	* @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.test.portlet.model.Genre remove(long genreId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchGenreException;

	public com.liferay.test.portlet.model.Genre updateImpl(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the genre with the primary key or throws a {@link com.liferay.test.portlet.NoSuchGenreException} if it could not be found.
	*
	* @param genreId the primary key of the genre
	* @return the genre
	* @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.test.portlet.model.Genre findByPrimaryKey(long genreId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchGenreException;

	/**
	* Returns the genre with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param genreId the primary key of the genre
	* @return the genre, or <code>null</code> if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.test.portlet.model.Genre fetchByPrimaryKey(long genreId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the genres.
	*
	* @return the genres
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.test.portlet.model.Genre> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the genres.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.GenreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of genres
	* @param end the upper bound of the range of genres (not inclusive)
	* @return the range of genres
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.test.portlet.model.Genre> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the genres.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.GenreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of genres
	* @param end the upper bound of the range of genres (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of genres
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.test.portlet.model.Genre> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the genres from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of genres.
	*
	* @return the number of genres
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}