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

import com.liferay.test.portlet.model.Publisher;

import java.util.List;

/**
 * The persistence utility for the publisher service. This utility wraps {@link PublisherPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kmv
 * @see PublisherPersistence
 * @see PublisherPersistenceImpl
 * @generated
 */
public class PublisherUtil {
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
	public static void clearCache(Publisher publisher) {
		getPersistence().clearCache(publisher);
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
	public static List<Publisher> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Publisher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Publisher> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Publisher update(Publisher publisher)
		throws SystemException {
		return getPersistence().update(publisher);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Publisher update(Publisher publisher,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(publisher, serviceContext);
	}

	/**
	* Caches the publisher in the entity cache if it is enabled.
	*
	* @param publisher the publisher
	*/
	public static void cacheResult(
		com.liferay.test.portlet.model.Publisher publisher) {
		getPersistence().cacheResult(publisher);
	}

	/**
	* Caches the publishers in the entity cache if it is enabled.
	*
	* @param publishers the publishers
	*/
	public static void cacheResult(
		java.util.List<com.liferay.test.portlet.model.Publisher> publishers) {
		getPersistence().cacheResult(publishers);
	}

	/**
	* Creates a new publisher with the primary key. Does not add the publisher to the database.
	*
	* @param publisherId the primary key for the new publisher
	* @return the new publisher
	*/
	public static com.liferay.test.portlet.model.Publisher create(
		long publisherId) {
		return getPersistence().create(publisherId);
	}

	/**
	* Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher that was removed
	* @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher remove(
		long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchPublisherException {
		return getPersistence().remove(publisherId);
	}

	public static com.liferay.test.portlet.model.Publisher updateImpl(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(publisher);
	}

	/**
	* Returns the publisher with the primary key or throws a {@link com.liferay.test.portlet.NoSuchPublisherException} if it could not be found.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher
	* @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher findByPrimaryKey(
		long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchPublisherException {
		return getPersistence().findByPrimaryKey(publisherId);
	}

	/**
	* Returns the publisher with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher, or <code>null</code> if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher fetchByPrimaryKey(
		long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(publisherId);
	}

	/**
	* Returns all the publishers.
	*
	* @return the publishers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.test.portlet.model.Publisher> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the publishers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.PublisherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publishers
	* @param end the upper bound of the range of publishers (not inclusive)
	* @return the range of publishers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.test.portlet.model.Publisher> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the publishers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.PublisherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of publishers
	* @param end the upper bound of the range of publishers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of publishers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.test.portlet.model.Publisher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the publishers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of publishers.
	*
	* @return the number of publishers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static PublisherPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (PublisherPersistence)PortletBeanLocatorUtil.locate(com.liferay.test.portlet.service.ClpSerializer.getServletContextName(),
					PublisherPersistence.class.getName());

			ReferenceRegistry.registerReference(PublisherUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(PublisherPersistence persistence) {
	}

	private static PublisherPersistence _persistence;
}