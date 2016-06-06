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

package com.liferay.test.portlet.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.test.portlet.NoSuchGenreException;
import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.model.Genre;
import com.liferay.test.portlet.service.GenreLocalServiceUtil;
import com.liferay.test.portlet.service.base.GenreLocalServiceBaseImpl;

/**
 * The implementation of the genre local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.test.portlet.service.GenreLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author kmv
 * @see com.liferay.test.portlet.service.base.GenreLocalServiceBaseImpl
 * @see com.liferay.test.portlet.service.GenreLocalServiceUtil
 */
public class GenreLocalServiceImpl extends GenreLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.test.portlet.service.GenreLocalServiceUtil} to access the genre local service.
	 */
	public List<Genre> getAllGenres() throws com.liferay.portal.kernel.exception.SystemException {
		List<Genre> genres = null;
		genres = genrePersistence.findAll();
		return genres;
	}
	
	public Genre getGenreById(long id) throws NoSuchGenreException, com.liferay.portal.kernel.exception.SystemException {
		return genrePersistence.findByPrimaryKey(id);
	}
	
	public Genre addGenre(long companyId, long groupId, long userId, long genreId, String name) throws com.liferay.portal.kernel.exception.SystemException {
		Genre newGenre = genrePersistence.create(0);
		try {
			resourceLocalService.addResources(
					companyId, groupId, userId, Author.class.getName(),
					genreId, false,
				    true, true);
		} catch (PortalException e) {
		}
		newGenre.setGenreId(genreId);
		newGenre.setName(name);
		genrePersistence.update(newGenre);
		return newGenre;
	}
	
	public long getMaxId() throws com.liferay.portal.kernel.exception.SystemException {
		List<Genre> genres = genrePersistence.findAll();
		long maxId = 0;
		for (Genre genre : genres) {
			maxId = Math.max(maxId, genre.getGenreId());
		}
		return maxId;
	}
	
	public List<Genre> getGenres() {
		List<Genre> genres = null;
		try {
			genres = GenreLocalServiceUtil.getAllGenres();
		} catch (SystemException e) {
		}
		if (genres==null) {
			genres = new ArrayList<Genre>();
		}
		return genres;
	}
	
	public boolean deletePermissions(long companyId, long genreId) throws PortalException, SystemException {
		resourceLocalService.deleteResource(companyId, Genre.class.getName(), 
								ResourceConstants.SCOPE_INDIVIDUAL, genreId);
		return true;
		//resourceLocalService.
	}
}