package com.liferay.test.portlet.permissions;

import com.liferay.test.portlet.model.Author;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;

public class AuthorPermission {
	public static boolean contains(long groupId, long authorId, String actionId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Author.class.getName(), authorId, actionId));
	}
	
	public static boolean hasViewPermission(long groupId, long authorId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Author.class.getName(), authorId, "VIEW"));
	}
	
	public static boolean hasEditPermission(long groupId, long authorId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Author.class.getName(), authorId, "UPDATE"));
	}
	
	public static boolean hasDeletePermission(long groupId, long authorId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Author.class.getName(), authorId, "DELETE"));
	}
}