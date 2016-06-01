package com.liferay.test.portlet.holders;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.model.Publisher;
import com.liferay.test.portlet.permissions.BookPermission;
import com.liferay.test.portlet.permissions.PublisherPermission;
import com.liferay.test.portlet.service.PublisherLocalServiceUtil;

public class PublishersHolder {
	private long publisherId;
	private String name;
	private boolean viewPermission;
	private boolean editPermission;
	private boolean deletePermission;

	public PublishersHolder(long groupId, long id) throws SystemException,
			PortalException {
		Publisher publisher = PublisherLocalServiceUtil.getPublisherById(id);

		this.setPublisherId(id);
		this.setName(publisher.getName());
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		this.viewPermission = PublisherPermission.contains(permissionChecker, groupId, id, "VIEW");
		this.editPermission = PublisherPermission.contains(permissionChecker, groupId, id, "UPDATE");
		this.deletePermission = PublisherPermission.contains(permissionChecker, groupId, id, "DELETE");
	}

	public boolean isViewPermission() {
		return viewPermission;
	}

	public void setViewPermission(boolean viewPermission) {
		this.viewPermission = viewPermission;
	}

	public boolean isEditPermission() {
		return editPermission;
	}

	public void setEditPermission(boolean editPermission) {
		this.editPermission = editPermission;
	}

	public boolean isDeletePermission() {
		return deletePermission;
	}

	public void setDeletePermission(boolean deletePermission) {
		this.deletePermission = deletePermission;
	}

	public long getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(long publisherId) {
		this.publisherId = publisherId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
