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

import com.liferay.test.portlet.model.Publisher;

/**
 * The persistence interface for the publisher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kmv
 * @see PublisherPersistenceImpl
 * @see PublisherUtil
 * @generated
 */
public interface PublisherPersistence extends BasePersistence<Publisher> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PublisherUtil} to access the publisher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the publisher in the entity cache if it is enabled.
	*
	* @param publisher the publisher
	*/
	public void cacheResult(com.liferay.test.portlet.model.Publisher publisher);

	/**
	* Caches the publishers in the entity cache if it is enabled.
	*
	* @param publishers the publishers
	*/
	public void cacheResult(
		java.util.List<com.liferay.test.portlet.model.Publisher> publishers);

	/**
	* Creates a new publisher with the primary key. Does not add the publisher to the database.
	*
	* @param publisherId the primary key for the new publisher
	* @return the new publisher
	*/
	public com.liferay.test.portlet.model.Publisher create(long publisherId);

	/**
	* Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher that was removed
	* @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.test.portlet.model.Publisher remove(long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchPublisherException;

	public com.liferay.test.portlet.model.Publisher updateImpl(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the publisher with the primary key or throws a {@link com.liferay.test.portlet.NoSuchPublisherException} if it could not be found.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher
	* @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.test.portlet.model.Publisher findByPrimaryKey(
		long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchPublisherException;

	/**
	* Returns the publisher with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher, or <code>null</code> if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.test.portlet.model.Publisher fetchByPrimaryKey(
		long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the publishers.
	*
	* @return the publishers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.test.portlet.model.Publisher> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.test.portlet.model.Publisher> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.test.portlet.model.Publisher> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the publishers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of publishers.
	*
	* @return the number of publishers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}