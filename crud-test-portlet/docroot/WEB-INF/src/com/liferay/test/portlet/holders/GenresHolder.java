package com.liferay.test.portlet.holders;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.model.Genre;
import com.liferay.test.portlet.permissions.BookPermission;
import com.liferay.test.portlet.permissions.GenrePermission;
import com.liferay.test.portlet.service.GenreLocalServiceUtil;

public class GenresHolder {
	private long genreId;
	private String name;
	private boolean viewPermission;
	private boolean editPermission;
	private boolean deletePermission;

	public GenresHolder(long groupId, long id) throws SystemException,
			PortalException {
		Genre genre = GenreLocalServiceUtil.getGenreById(id);

		this.setGenreId(id);
		this.setName(genre.getName());
		
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		this.viewPermission = GenrePermission.contains(permissionChecker, groupId, id, "VIEW");
		this.editPermission = GenrePermission.contains(permissionChecker, groupId, id, "UPDATE");
		this.deletePermission = GenrePermission.contains(permissionChecker, groupId, id, "DELETE");
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

	public long getGenreId() {
		return genreId;
	}

	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
