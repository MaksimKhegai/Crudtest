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
import com.liferay.test.portlet.NoSuchPublisherException;
import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.model.Publisher;
import com.liferay.test.portlet.service.PublisherLocalServiceUtil;
import com.liferay.test.portlet.service.base.PublisherLocalServiceBaseImpl;

/**
 * The implementation of the publisher local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.test.portlet.service.PublisherLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author kmv
 * @see com.liferay.test.portlet.service.base.PublisherLocalServiceBaseImpl
 * @see com.liferay.test.portlet.service.PublisherLocalServiceUtil
 */
public class PublisherLocalServiceImpl extends PublisherLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.test.portlet.service.PublisherLocalServiceUtil} to access the publisher local service.
	 */
	public List<Publisher> getAllPublishers() throws com.liferay.portal.kernel.exception.SystemException {
		List<Publisher> publishers = null;
		publishers = publisherPersistence.findAll();
		return publishers;
	}
	
	public Publisher getPublisherById(long id) throws NoSuchPublisherException, com.liferay.portal.kernel.exception.SystemException {
		return publisherPersistence.findByPrimaryKey(id);
	}
	
	public Publisher addPublisher(long companyId, long groupId, long userId, long publisherId, String name) throws com.liferay.portal.kernel.exception.SystemException {
		Publisher newPublisher = publisherPersistence.create(0);
		try {
			resourceLocalService.addResources(
					companyId, groupId, userId, Author.class.getName(),
					publisherId, false,
				    true, true);
		} catch (PortalException e) {
		}
		newPublisher.setPublisherId(publisherId);
		newPublisher.setName(name);
		publisherPersistence.update(newPublisher);
		return newPublisher;
	}
	
	public long getMaxId() throws com.liferay.portal.kernel.exception.SystemException {
		List<Publisher> publishers = publisherPersistence.findAll();
		long maxId = 0;
		for (Publisher publisher : publishers) {
			maxId = Math.max(maxId, publisher.getPublisherId());
		}
		return maxId;
	}
	
	public List<Publisher> getPublishers() {
		List<Publisher> publishers = null;
		try {
			publishers = PublisherLocalServiceUtil.getAllPublishers();
		} catch (SystemException e) {
		}
		if (publishers==null) {
			publishers = new ArrayList<Publisher>();
		}
		return publishers;
	}
	
	public boolean deletePermissions(long companyId, long publisherId) throws PortalException, SystemException {
		resourceLocalService.deleteResource(companyId, Publisher.class.getName(), 
								ResourceConstants.SCOPE_INDIVIDUAL, publisherId);
		return true;
		//resourceLocalService.
	}
}