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

package com.liferay.test.portlet.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Book}.
 * </p>
 *
 * @author kmv
 * @see Book
 * @generated
 */
public class BookWrapper implements Book, ModelWrapper<Book> {
	public BookWrapper(Book book) {
		_book = book;
	}

	@Override
	public Class<?> getModelClass() {
		return Book.class;
	}

	@Override
	public String getModelClassName() {
		return Book.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("bookId", getBookId());
		attributes.put("genreId", getGenreId());
		attributes.put("publisherId", getPublisherId());
		attributes.put("authorId", getAuthorId());
		attributes.put("name", getName());
		attributes.put("releaseDate", getReleaseDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long bookId = (Long)attributes.get("bookId");

		if (bookId != null) {
			setBookId(bookId);
		}

		Long genreId = (Long)attributes.get("genreId");

		if (genreId != null) {
			setGenreId(genreId);
		}

		Long publisherId = (Long)attributes.get("publisherId");

		if (publisherId != null) {
			setPublisherId(publisherId);
		}

		Long authorId = (Long)attributes.get("authorId");

		if (authorId != null) {
			setAuthorId(authorId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String releaseDate = (String)attributes.get("releaseDate");

		if (releaseDate != null) {
			setReleaseDate(releaseDate);
		}
	}

	/**
	* Returns the primary key of this book.
	*
	* @return the primary key of this book
	*/
	@Override
	public long getPrimaryKey() {
		return _book.getPrimaryKey();
	}

	/**
	* Sets the primary key of this book.
	*
	* @param primaryKey the primary key of this book
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_book.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the book ID of this book.
	*
	* @return the book ID of this book
	*/
	@Override
	public long getBookId() {
		return _book.getBookId();
	}

	/**
	* Sets the book ID of this book.
	*
	* @param bookId the book ID of this book
	*/
	@Override
	public void setBookId(long bookId) {
		_book.setBookId(bookId);
	}

	/**
	* Returns the genre ID of this book.
	*
	* @return the genre ID of this book
	*/
	@Override
	public long getGenreId() {
		return _book.getGenreId();
	}

	/**
	* Sets the genre ID of this book.
	*
	* @param genreId the genre ID of this book
	*/
	@Override
	public void setGenreId(long genreId) {
		_book.setGenreId(genreId);
	}

	/**
	* Returns the publisher ID of this book.
	*
	* @return the publisher ID of this book
	*/
	@Override
	public long getPublisherId() {
		return _book.getPublisherId();
	}

	/**
	* Sets the publisher ID of this book.
	*
	* @param publisherId the publisher ID of this book
	*/
	@Override
	public void setPublisherId(long publisherId) {
		_book.setPublisherId(publisherId);
	}

	/**
	* Returns the author ID of this book.
	*
	* @return the author ID of this book
	*/
	@Override
	public long getAuthorId() {
		return _book.getAuthorId();
	}

	/**
	* Sets the author ID of this book.
	*
	* @param authorId the author ID of this book
	*/
	@Override
	public void setAuthorId(long authorId) {
		_book.setAuthorId(authorId);
	}

	/**
	* Returns the name of this book.
	*
	* @return the name of this book
	*/
	@Override
	public java.lang.String getName() {
		return _book.getName();
	}

	/**
	* Sets the name of this book.
	*
	* @param name the name of this book
	*/
	@Override
	public void setName(java.lang.String name) {
		_book.setName(name);
	}

	/**
	* Returns the release date of this book.
	*
	* @return the release date of this book
	*/
	@Override
	public java.lang.String getReleaseDate() {
		return _book.getReleaseDate();
	}

	/**
	* Sets the release date of this book.
	*
	* @param releaseDate the release date of this book
	*/
	@Override
	public void setReleaseDate(java.lang.String releaseDate) {
		_book.setReleaseDate(releaseDate);
	}

	@Override
	public boolean isNew() {
		return _book.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_book.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _book.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_book.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _book.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _book.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_book.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _book.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_book.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_book.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_book.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new BookWrapper((Book)_book.clone());
	}

	@Override
	public int compareTo(com.liferay.test.portlet.model.Book book) {
		return _book.compareTo(book);
	}

	@Override
	public int hashCode() {
		return _book.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.liferay.test.portlet.model.Book> toCacheModel() {
		return _book.toCacheModel();
	}

	@Override
	public com.liferay.test.portlet.model.Book toEscapedModel() {
		return new BookWrapper(_book.toEscapedModel());
	}

	@Override
	public com.liferay.test.portlet.model.Book toUnescapedModel() {
		return new BookWrapper(_book.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _book.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _book.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_book.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BookWrapper)) {
			return false;
		}

		BookWrapper bookWrapper = (BookWrapper)obj;

		if (Validator.equals(_book, bookWrapper._book)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Book getWrappedBook() {
		return _book;
	}

	@Override
	public Book getWrappedModel() {
		return _book;
	}

	@Override
	public void resetOriginalValues() {
		_book.resetOriginalValues();
	}

	private Book _book;
}