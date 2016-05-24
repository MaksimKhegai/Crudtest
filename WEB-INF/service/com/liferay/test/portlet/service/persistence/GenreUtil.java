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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.test.portlet.model.Genre;

import java.util.List;

/**
 * The persistence utility for the genre service. This utility wraps {@link GenrePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kmv
 * @see GenrePersistence
 * @see GenrePersistenceImpl
 * @generated
 */
public class GenreUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Genre genre) {
		getPersistence().clearCache(genre);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Genre> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Genre> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Genre> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Genre update(Genre genre) throws SystemException {
		return getPersistence().update(genre);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Genre update(Genre genre, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(genre, serviceContext);
	}

	/**
	* Caches the genre in the entity cache if it is enabled.
	*
	* @param genre the genre
	*/
	public static void cacheResult(com.liferay.test.portlet.model.Genre genre) {
		getPersistence().cacheResult(genre);
	}

	/**
	* Caches the genres in the entity cache if it is enabled.
	*
	* @param genres the genres
	*/
	public static void cacheResult(
		java.util.List<com.liferay.test.portlet.model.Genre> genres) {
		getPersistence().cacheResult(genres);
	}

	/**
	* Creates a new genre with the primary key. Does not add the genre to the database.
	*
	* @param genreId the primary key for the new genre
	* @return the new genre
	*/
	public static com.liferay.test.portlet.model.Genre create(long genreId) {
		return getPersistence().create(genreId);
	}

	/**
	* Removes the genre with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genreId the primary key of the genre
	* @return the genre that was removed
	* @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre remove(long genreId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchGenreException {
		return getPersistence().remove(genreId);
	}

	public static com.liferay.test.portlet.model.Genre updateImpl(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(genre);
	}

	/**
	* Returns the genre with the primary key or throws a {@link com.liferay.test.portlet.NoSuchGenreException} if it could not be found.
	*
	* @param genreId the primary key of the genre
	* @return the genre
	* @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre findByPrimaryKey(
		long genreId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchGenreException {
		return getPersistence().findByPrimaryKey(genreId);
	}

	/**
	* Returns the genre with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param genreId the primary key of the genre
	* @return the genre, or <code>null</code> if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre fetchByPrimaryKey(
		long genreId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(genreId);
	}

	/**
	* Returns all the genres.
	*
	* @return the genres
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.test.portlet.model.Genre> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.test.portlet.model.Genre> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.test.portlet.model.Genre> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the genres from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of genres.
	*
	* @return the number of genres
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static GenrePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (GenrePersistence)PortletBeanLocatorUtil.locate(com.liferay.test.portlet.service.ClpSerializer.getServletContextName(),
					GenrePersistence.class.getName());

			ReferenceRegistry.registerReference(GenreUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(GenrePersistence persistence) {
	}

	private static GenrePersistence _persistence;
}