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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author kmv
 * @generated
 */
public class PublisherSoap implements Serializable {
	public static PublisherSoap toSoapModel(Publisher model) {
		PublisherSoap soapModel = new PublisherSoap();

		soapModel.setPublisherId(model.getPublisherId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static PublisherSoap[] toSoapModels(Publisher[] models) {
		PublisherSoap[] soapModels = new PublisherSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PublisherSoap[][] toSoapModels(Publisher[][] models) {
		PublisherSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PublisherSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PublisherSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PublisherSoap[] toSoapModels(List<Publisher> models) {
		List<PublisherSoap> soapModels = new ArrayList<PublisherSoap>(models.size());

		for (Publisher model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PublisherSoap[soapModels.size()]);
	}

	public PublisherSoap() {
	}

	public long getPrimaryKey() {
		return _publisherId;
	}

	public void setPrimaryKey(long pk) {
		setPublisherId(pk);
	}

	public long getPublisherId() {
		return _publisherId;
	}

	public void setPublisherId(long publisherId) {
		_publisherId = publisherId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _publisherId;
	private String _name;
}