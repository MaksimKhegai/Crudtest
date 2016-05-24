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

import com.liferay.test.portlet.model.Publisher;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Publisher in entity cache.
 *
 * @author kmv
 * @see Publisher
 * @generated
 */
public class PublisherCacheModel implements CacheModel<Publisher>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{publisherId=");
		sb.append(publisherId);
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Publisher toEntityModel() {
		PublisherImpl publisherImpl = new PublisherImpl();

		publisherImpl.setPublisherId(publisherId);

		if (name == null) {
			publisherImpl.setName(StringPool.BLANK);
		}
		else {
			publisherImpl.setName(name);
		}

		publisherImpl.resetOriginalValues();

		return publisherImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		publisherId = objectInput.readLong();
		name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(publisherId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public long publisherId;
	public String name;
}