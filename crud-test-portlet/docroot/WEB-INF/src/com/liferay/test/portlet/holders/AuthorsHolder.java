package com.liferay.test.portlet.holders;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.permissions.AuthorPermission;
import com.liferay.test.portlet.permissions.BookPermission;
import com.liferay.test.portlet.service.AuthorLocalServiceUtil;

public class AuthorsHolder {
	private long authorId;
	private String name;
	private String birthDate;
	private boolean viewPermission;
	private boolean editPermission;
	private boolean deletePermission;

	public AuthorsHolder(long groupId, long id) throws SystemException,
			PortalException {
		Author author = AuthorLocalServiceUtil.getAuthorById(id);

		this.setAuthorId(id);
		this.setName(author.getName());
		this.setBirthDate(author.getBirthDate());
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		this.viewPermission = AuthorPermission.contains(permissionChecker, groupId, id, "VIEW");
		this.editPermission = AuthorPermission.contains(permissionChecker, groupId, id, "UPDATE");
		this.deletePermission = AuthorPermission.contains(permissionChecker, groupId, id, "DELETE");
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

	public long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

}
