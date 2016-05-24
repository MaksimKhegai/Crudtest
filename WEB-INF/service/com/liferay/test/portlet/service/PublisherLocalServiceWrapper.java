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

package com.liferay.test.portlet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PublisherLocalService}.
 *
 * @author kmv
 * @see PublisherLocalService
 * @generated
 */
public class PublisherLocalServiceWrapper implements PublisherLocalService,
	ServiceWrapper<PublisherLocalService> {
	public PublisherLocalServiceWrapper(
		PublisherLocalService publisherLocalService) {
		_publisherLocalService = publisherLocalService;
	}

	/**
	* Adds the publisher to the database. Also notifies the appropriate model listeners.
	*
	* @param publisher the publisher
	* @return the publisher that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Publisher addPublisher(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.addPublisher(publisher);
	}

	/**
	* Creates a new publisher with the primary key. Does not add the publisher to the database.
	*
	* @param publisherId the primary key for the new publisher
	* @return the new publisher
	*/
	@Override
	public com.liferay.test.portlet.model.Publisher createPublisher(
		long publisherId) {
		return _publisherLocalService.createPublisher(publisherId);
	}

	/**
	* Deletes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher that was removed
	* @throws PortalException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Publisher deletePublisher(
		long publisherId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.deletePublisher(publisherId);
	}

	/**
	* Deletes the publisher from the database. Also notifies the appropriate model listeners.
	*
	* @param publisher the publisher
	* @return the publisher that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Publisher deletePublisher(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.deletePublisher(publisher);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _publisherLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.PublisherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.PublisherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.test.portlet.model.Publisher fetchPublisher(
		long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.fetchPublisher(publisherId);
	}

	/**
	* Returns the publisher with the primary key.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher
	* @throws PortalException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Publisher getPublisher(
		long publisherId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.getPublisher(publisherId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.test.portlet.model.Publisher> getPublishers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.getPublishers(start, end);
	}

	/**
	* Returns the number of publishers.
	*
	* @return the number of publishers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getPublishersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.getPublishersCount();
	}

	/**
	* Updates the publisher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publisher the publisher
	* @return the publisher that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Publisher updatePublisher(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.updatePublisher(publisher);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _publisherLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_publisherLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _publisherLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.liferay.test.portlet.model.Publisher> getAllPublishers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.getAllPublishers();
	}

	@Override
	public com.liferay.test.portlet.model.Publisher getPublisherById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchPublisherException {
		return _publisherLocalService.getPublisherById(id);
	}

	@Override
	public com.liferay.test.portlet.model.Publisher addPublisher(
		long companyId, long groupId, long userId, long publisherId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.addPublisher(companyId, groupId, userId,
			publisherId, name);
	}

	@Override
	public long getMaxId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.getMaxId();
	}

	@Override
	public java.util.List<com.liferay.test.portlet.model.Publisher> getPublishers() {
		return _publisherLocalService.getPublishers();
	}

	@Override
	public boolean deletePermissions(long companyId, long publisherId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _publisherLocalService.deletePermissions(companyId, publisherId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public PublisherLocalService getWrappedPublisherLocalService() {
		return _publisherLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedPublisherLocalService(
		PublisherLocalService publisherLocalService) {
		_publisherLocalService = publisherLocalService;
	}

	@Override
	public PublisherLocalService getWrappedService() {
		return _publisherLocalService;
	}

	@Override
	public void setWrappedService(PublisherLocalService publisherLocalService) {
		_publisherLocalService = publisherLocalService;
	}

	private PublisherLocalService _publisherLocalService;
}