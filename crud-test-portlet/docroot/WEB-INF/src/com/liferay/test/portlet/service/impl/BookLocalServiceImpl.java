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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.test.portlet.NoSuchBookException;
import com.liferay.test.portlet.model.Book;
import com.liferay.test.portlet.service.BookLocalServiceUtil;
import com.liferay.test.portlet.service.base.BookLocalServiceBaseImpl;

/**
 * The implementation of the book local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.liferay.test.portlet.service.BookLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author kmv
 * @see com.liferay.test.portlet.service.base.BookLocalServiceBaseImpl
 * @see com.liferay.test.portlet.service.BookLocalServiceUtil
 */
public class BookLocalServiceImpl extends BookLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.liferay.test.portlet.service.BookLocalServiceUtil} to access the book
	 * local service.
	 */
	private static final Log log = LogFactoryUtil.getLog(BookLocalServiceImpl.class);

	public List<Book> getAllBooks() throws SystemException {
		List<Book> books = null;
		books = bookPersistence.findAll();
		return books;
	}

	public Book getBookById(long id) throws NoSuchBookException, SystemException {
		return bookPersistence.findByPrimaryKey(id);
	}

	public Book addBook(long companyId, long groupId, long userId, long bookId, String name,
			long author, long genre, long publisher, String date) throws SystemException,
			PortalException {
		Book newBook = bookPersistence.create(0);
		newBook.setBookId(bookId);
		newBook.setName(name);
		newBook.setAuthorId(author);
		newBook.setGenreId(genre);
		newBook.setPublisherId(publisher);
		newBook.setReleaseDate(date);
		bookLocalService.addBook(newBook);
		try {
			resourceLocalService.addResources(companyId, groupId, userId, Book.class.getName(),
					bookId, false, true, true);
		} catch (PortalException e) {
			throw e;
		}
		return newBook;
	}

	public long getMaxId() throws SystemException {
		List<Book> books = bookPersistence.findAll();
		long maxId = 0;
		for (Book book : books) {
			maxId = Math.max(maxId, book.getBookId());
		}
		return maxId;
	}

	public List<Book> getBooks() {
		List<Book> books = null;
		try {
			books = BookLocalServiceUtil.getAllBooks();
		} catch (SystemException e) {
		}
		if (books == null) {
			books = new ArrayList<Book>();
		}
		return books;
	}

	@Override
	public Book addBook(long userId, long bookId, String name) throws SystemException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean deletePermissions(long companyId, long bookId) throws PortalException,
			SystemException {
		resourceLocalService.deleteResource(companyId, Book.class.getName(),
				ResourceConstants.SCOPE_INDIVIDUAL, bookId);
		return true;
		// resourceLocalService.
	}
}