package com.liferay.test.portlet.holders;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.NoSuchAuthorException;
import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.permissions.AuthorPermission;
import com.liferay.test.portlet.service.AuthorLocalServiceUtil;

public class AuthorsHolder {
	private long authorId;
	private String name;
	private String birthDate;
	private boolean viewPermission;
	private boolean editPermission;
	private boolean deletePermission;

	public AuthorsHolder(long groupId, long id) throws PortalException, SystemException {
		Author author;
			author = AuthorLocalServiceUtil.getAuthorById(id);
			this.setAuthorId(id);
			this.setName(author.getName());
			this.setBirthDate(author.getBirthDate());
			
			this.viewPermission = AuthorPermission.hasViewPermission(groupId, id);
			this.editPermission = AuthorPermission.hasEditPermission(groupId, id);
			this.deletePermission = AuthorPermission.hasDeletePermission(groupId, id);
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
