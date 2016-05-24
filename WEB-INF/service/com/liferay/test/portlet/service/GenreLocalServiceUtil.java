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
 * Provides the local service utility for Genre. This utility wraps
 * {@link com.liferay.test.portlet.service.impl.GenreLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author kmv
 * @see GenreLocalService
 * @see com.liferay.test.portlet.service.base.GenreLocalServiceBaseImpl
 * @see com.liferay.test.portlet.service.impl.GenreLocalServiceImpl
 * @generated
 */
public class GenreLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.test.portlet.service.impl.GenreLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the genre to the database. Also notifies the appropriate model listeners.
	*
	* @param genre the genre
	* @return the genre that was added
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre addGenre(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGenre(genre);
	}

	/**
	* Creates a new genre with the primary key. Does not add the genre to the database.
	*
	* @param genreId the primary key for the new genre
	* @return the new genre
	*/
	public static com.liferay.test.portlet.model.Genre createGenre(long genreId) {
		return getService().createGenre(genreId);
	}

	/**
	* Deletes the genre with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genreId the primary key of the genre
	* @return the genre that was removed
	* @throws PortalException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre deleteGenre(long genreId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGenre(genreId);
	}

	/**
	* Deletes the genre from the database. Also notifies the appropriate model listeners.
	*
	* @param genre the genre
	* @return the genre that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre deleteGenre(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().deleteGenre(genre);
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.GenreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.GenreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

	public static com.liferay.test.portlet.model.Genre fetchGenre(long genreId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchGenre(genreId);
	}

	/**
	* Returns the genre with the primary key.
	*
	* @param genreId the primary key of the genre
	* @return the genre
	* @throws PortalException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre getGenre(long genreId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getGenre(genreId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
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
	public static java.util.List<com.liferay.test.portlet.model.Genre> getGenres(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGenres(start, end);
	}

	/**
	* Returns the number of genres.
	*
	* @return the number of genres
	* @throws SystemException if a system exception occurred
	*/
	public static int getGenresCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getGenresCount();
	}

	/**
	* Updates the genre in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param genre the genre
	* @return the genre that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.test.portlet.model.Genre updateGenre(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateGenre(genre);
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

	public static java.util.List<com.liferay.test.portlet.model.Genre> getAllGenres()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllGenres();
	}

	public static com.liferay.test.portlet.model.Genre getGenreById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchGenreException {
		return getService().getGenreById(id);
	}

	public static com.liferay.test.portlet.model.Genre addGenre(
		long companyId, long groupId, long userId, long genreId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addGenre(companyId, groupId, userId, genreId, name);
	}

	public static long getMaxId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getMaxId();
	}

	public static java.util.List<com.liferay.test.portlet.model.Genre> getGenres() {
		return getService().getGenres();
	}

	public static boolean deletePermissions(long companyId, long genreId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().deletePermissions(companyId, genreId);
	}

	public static void clearService() {
		_service = null;
	}

	public static GenreLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					GenreLocalService.class.getName());

			if (invokableLocalService instanceof GenreLocalService) {
				_service = (GenreLocalService)invokableLocalService;
			}
			else {
				_service = new GenreLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(GenreLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(GenreLocalService service) {
	}

	private static GenreLocalService _service;
}