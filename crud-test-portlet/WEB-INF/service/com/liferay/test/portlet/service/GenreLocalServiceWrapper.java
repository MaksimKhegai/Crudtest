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
 * Provides a wrapper for {@link GenreLocalService}.
 *
 * @author kmv
 * @see GenreLocalService
 * @generated
 */
public class GenreLocalServiceWrapper implements GenreLocalService,
	ServiceWrapper<GenreLocalService> {
	public GenreLocalServiceWrapper(GenreLocalService genreLocalService) {
		_genreLocalService = genreLocalService;
	}

	/**
	* Adds the genre to the database. Also notifies the appropriate model listeners.
	*
	* @param genre the genre
	* @return the genre that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Genre addGenre(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.addGenre(genre);
	}

	/**
	* Creates a new genre with the primary key. Does not add the genre to the database.
	*
	* @param genreId the primary key for the new genre
	* @return the new genre
	*/
	@Override
	public com.liferay.test.portlet.model.Genre createGenre(long genreId) {
		return _genreLocalService.createGenre(genreId);
	}

	/**
	* Deletes the genre with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param genreId the primary key of the genre
	* @return the genre that was removed
	* @throws PortalException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Genre deleteGenre(long genreId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.deleteGenre(genreId);
	}

	/**
	* Deletes the genre from the database. Also notifies the appropriate model listeners.
	*
	* @param genre the genre
	* @return the genre that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Genre deleteGenre(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.deleteGenre(genre);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _genreLocalService.dynamicQuery();
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
		return _genreLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _genreLocalService.dynamicQueryCount(dynamicQuery);
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
		return _genreLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.test.portlet.model.Genre fetchGenre(long genreId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.fetchGenre(genreId);
	}

	/**
	* Returns the genre with the primary key.
	*
	* @param genreId the primary key of the genre
	* @return the genre
	* @throws PortalException if a genre with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Genre getGenre(long genreId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.getGenre(genreId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.liferay.test.portlet.model.Genre> getGenres(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.getGenres(start, end);
	}

	/**
	* Returns the number of genres.
	*
	* @return the number of genres
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getGenresCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.getGenresCount();
	}

	/**
	* Updates the genre in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param genre the genre
	* @return the genre that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.test.portlet.model.Genre updateGenre(
		com.liferay.test.portlet.model.Genre genre)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.updateGenre(genre);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _genreLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_genreLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _genreLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.liferay.test.portlet.model.Genre> getAllGenres()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.getAllGenres();
	}

	@Override
	public com.liferay.test.portlet.model.Genre getGenreById(long id)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.test.portlet.NoSuchGenreException {
		return _genreLocalService.getGenreById(id);
	}

	@Override
	public com.liferay.test.portlet.model.Genre addGenre(long companyId,
		long groupId, long userId, long genreId, java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.addGenre(companyId, groupId, userId, genreId,
			name);
	}

	@Override
	public long getMaxId()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.getMaxId();
	}

	@Override
	public java.util.List<com.liferay.test.portlet.model.Genre> getGenres() {
		return _genreLocalService.getGenres();
	}

	@Override
	public boolean deletePermissions(long companyId, long genreId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _genreLocalService.deletePermissions(companyId, genreId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public GenreLocalService getWrappedGenreLocalService() {
		return _genreLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedGenreLocalService(GenreLocalService genreLocalService) {
		_genreLocalService = genreLocalService;
	}

	@Override
	public GenreLocalService getWrappedService() {
		return _genreLocalService;
	}

	@Override
	public void setWrappedService(GenreLocalService genreLocalService) {
		_genreLocalService = genreLocalService;
	}

	private GenreLocalService _genreLocalService;
}