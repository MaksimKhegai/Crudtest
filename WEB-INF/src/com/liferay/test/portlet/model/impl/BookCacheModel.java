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

package com.liferay.test.portlet.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.test.portlet.model.Book;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Book in entity cache.
 *
 * @author kmv
 * @see Book
 * @generated
 */
public class BookCacheModel implements CacheModel<Book>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{bookId=");
		sb.append(bookId);
		sb.append(", genreId=");
		sb.append(genreId);
		sb.append(", publisherId=");
		sb.append(publisherId);
		sb.append(", authorId=");
		sb.append(authorId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", releaseDate=");
		sb.append(releaseDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Book toEntityModel() {
		BookImpl bookImpl = new BookImpl();

		bookImpl.setBookId(bookId);
		bookImpl.setGenreId(genreId);
		bookImpl.setPublisherId(publisherId);
		bookImpl.setAuthorId(authorId);

		if (name == null) {
			bookImpl.setName(StringPool.BLANK);
		}
		else {
			bookImpl.setName(name);
		}

		if (releaseDate == null) {
			bookImpl.setReleaseDate(StringPool.BLANK);
		}
		else {
			bookImpl.setReleaseDate(releaseDate);
		}

		bookImpl.resetOriginalValues();

		return bookImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		bookId = objectInput.readLong();
		genreId = objectInput.readLong();
		publisherId = objectInput.readLong();
		authorId = objectInput.readLong();
		name = objectInput.readUTF();
		releaseDate = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(bookId);
		objectOutput.writeLong(genreId);
		objectOutput.writeLong(publisherId);
		objectOutput.writeLong(authorId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (releaseDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(releaseDate);
		}
	}

	public long bookId;
	public long genreId;
	public long publisherId;
	public long authorId;
	public String name;
	public String releaseDate;
}