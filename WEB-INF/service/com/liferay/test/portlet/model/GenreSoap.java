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
public class GenreSoap implements Serializable {
	public static GenreSoap toSoapModel(Genre model) {
		GenreSoap soapModel = new GenreSoap();

		soapModel.setGenreId(model.getGenreId());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static GenreSoap[] toSoapModels(Genre[] models) {
		GenreSoap[] soapModels = new GenreSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GenreSoap[][] toSoapModels(Genre[][] models) {
		GenreSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GenreSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GenreSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GenreSoap[] toSoapModels(List<Genre> models) {
		List<GenreSoap> soapModels = new ArrayList<GenreSoap>(models.size());

		for (Genre model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GenreSoap[soapModels.size()]);
	}

	public GenreSoap() {
	}

	public long getPrimaryKey() {
		return _genreId;
	}

	public void setPrimaryKey(long pk) {
		setGenreId(pk);
	}

	public long getGenreId() {
		return _genreId;
	}

	public void setGenreId(long genreId) {
		_genreId = genreId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _genreId;
	private String _name;
}