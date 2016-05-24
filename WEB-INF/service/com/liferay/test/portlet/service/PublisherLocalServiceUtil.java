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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for Publisher. This utility wraps
 * {@link com.liferay.test.portlet.service.impl.PublisherLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author kmv
 * @see PublisherLocalService
 * @see com.liferay.test.portlet.service.base.PublisherLocalServiceBaseImpl
 * @see com.liferay.test.portlet.service.impl.PublisherLocalServiceImpl
 * @generated
 */
public class PublisherLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.test.portlet.service.impl.PublisherLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the publisher to the database. Also notifies the appropriate model listeners.
	*
	* @param publisher the publisher
	* @return the publisher that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher addPublisher(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addPublisher(publisher);
	}

	/**
	* Creates a new publisher with the primary key. Does not add the publisher to the database.
	*
	* @param publisherId the primary key for the new publisher
	* @return the new publisher
	*/
	public static com.liferay.test.portlet.model.Publisher createPublisher(
		long publisherId) {
		return getService().createPublisher(publisherId);
	}

	/**
	* Deletes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher that was removed
	* @throws PortalException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher deletePublisher(
		long publisherId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublisher(publisherId);
	}

	/**
	* Deletes the publisher from the database. Also notifies the appropriate model listeners.
	*
	* @param publisher the publisher
	* @return the publisher that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher deletePublisher(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePublisher(publisher);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
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
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.liferay.test.portlet.model.Publisher fetchPublisher(
		long publisherId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchPublisher(publisherId);
	}

	/**
	* Returns the publisher with the primary key.
	*
	* @param publisherId the primary key of the publisher
	* @return the publisher
	* @throws PortalException if a publisher with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher getPublisher(
		long publisherId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublisher(publisherId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.test.portlet.model.Publisher> getPublishers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishers(start, end);
	}

	/**
	* Returns the number of publishers.
	*
	* @return the number of publishers
	* @throws SystemException if a system exception occurred
	*/
	public static int getPublishersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getPublishersCount();
	}

	/**
	* Updates the publisher in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param publisher the publisher
	* @return the publisher that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Publisher updatePublisher(
		com.liferay.test.portlet.model.Publisher publisher)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updatePublisher(publisher);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static java.util.List<com.liferay.test.portlet.model.Publisher> getAllPublishers()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllPublishers();
	}

	public static com.liferay.test.portlet.model.Publisher getPublisherById(
		long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchPublisherException {
		return getService().getPublisherById(id);
	}

	public static com.liferay.test.portlet.model.Publisher addPublisher(
		long companyId, long groupId, long userId, long publisherId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addPublisher(companyId, groupId, userId, publisherId, name);
	}

	public static long getMaxId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMaxId();
	}

	public static java.util.List<com.liferay.test.portlet.model.Publisher> getPublishers() {
		return getService().getPublishers();
	}

	public static boolean deletePermissions(long companyId, long publisherId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePermissions(companyId, publisherId);
	}

	public static void clearService() {
		_service = null;
	}

	public static PublisherLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					PublisherLocalService.class.getName());

			if (invokableLocalService instanceof PublisherLocalService) {
				_service = (PublisherLocalService)invokableLocalService;
			}
			else {
				_service = new PublisherLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(PublisherLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(PublisherLocalService service) {
	}

	private static PublisherLocalService _service;
}