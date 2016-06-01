package com.liferay.test.portlet.holders;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.NoSuchGenreException;
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

	public GenresHolder(long groupId, long id) throws PortalException, SystemException {
		Genre genre;
			genre = GenreLocalServiceUtil.getGenreById(id);
			this.setGenreId(id);
			this.setName(genre.getName());
			
			this.viewPermission = GenrePermission.hasViewPermission(groupId, id);
			this.editPermission = GenrePermission.hasEditPermission(groupId, id);
			this.deletePermission = GenrePermission.hasDeletePermission(groupId, id);
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
