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
import com.liferay.test.portlet.NoSuchAuthorException;
import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.model.Book;
import com.liferay.test.portlet.service.AuthorLocalServiceUtil;
import com.liferay.test.portlet.service.base.AuthorLocalServiceBaseImpl;

/**
 * The implementation of the author local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.test.portlet.service.AuthorLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author kmv
 * @see com.liferay.test.portlet.service.base.AuthorLocalServiceBaseImpl
 * @see com.liferay.test.portlet.service.AuthorLocalServiceUtil
 */
public class AuthorLocalServiceImpl extends AuthorLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.test.portlet.service.AuthorLocalServiceUtil} to access the author local service.
	 */
	public List<Author> getAllAuthors() throws SystemException {
		List<Author> books = null;
		books = authorPersistence.findAll();
		return books;
	}
	
	public Author getAuthorById(long id) throws SystemException, NoSuchAuthorException {
		return authorPersistence.findByPrimaryKey(id);
	}
	
	public Author addAuthor(long companyId, long groupId, long userId, long authorId, String name, String birthDate) 
							throws SystemException {
		Author newAuthor = authorPersistence.create(0);
		try {
			resourceLocalService.addResources(
					companyId, groupId, userId, Author.class.getName(),
					authorId, false,
				    true, true);
		} catch (PortalException e) {
		}
		newAuthor.setAuthorId(authorId);
		newAuthor.setName(name);
		newAuthor.setBirthDate(birthDate);
		authorPersistence.update(newAuthor);
		return newAuthor;
	}
	
	public long getMaxId() throws SystemException {
		List<Author> authors = authorPersistence.findAll();
		long maxId = 0;
		for (Author author : authors) {
			maxId = Math.max(maxId, author.getAuthorId());
		}
		return maxId;
	}

	public Author addAuthor(long userId, long authorId, String name)
			throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Author> getAuthors() {
		List<Author> authors = null;
		try {
			authors = AuthorLocalServiceUtil.getAllAuthors();
		} catch (SystemException e) {
		}
		if (authors==null) {
			authors = new ArrayList<Author>();
		}
		return authors;
	}
	
	public boolean deletePermissions(long companyId, long authorId) throws PortalException, SystemException {
		resourceLocalService.deleteResource(companyId, Author.class.getName(), 
								ResourceConstants.SCOPE_INDIVIDUAL, authorId);
		return true;
		//resourceLocalService.
	}
}