package com.liferay.test.portlet.permissions;

import com.liferay.test.portlet.model.Genre;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;

public class GenrePermission {
	public static boolean contains(long groupId, long genreId, String actionId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Genre.class.getName(), genreId, actionId));
	}
	
	public static boolean hasViewPermission(long groupId, long genreId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Genre.class.getName(), genreId, "VIEW"));
	}
	
	public static boolean hasEditPermission(long groupId, long genreId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Genre.class.getName(), genreId, "UPDATE"));
	}
	
	public static boolean hasDeletePermission(long groupId, long genreId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Genre.class.getName(), genreId, "DELETE"));
	}
}