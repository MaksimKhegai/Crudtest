package com.liferay.test.portlet.permissions;

import com.liferay.test.portlet.model.Book;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;

public class BookPermission {
	public static boolean contains(long groupId, long bookId, String actionId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Book.class.getName(), bookId, actionId));
	}
	
	public static boolean hasViewPermission(long groupId, long bookId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Book.class.getName(), bookId, "VIEW"));
	}
	
	public static boolean hasEditPermission(long groupId, long bookId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Book.class.getName(), bookId, "UPDATE"));
	}
	
	public static boolean hasDeletePermission(long groupId, long bookId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Book.class.getName(), bookId, "DELETE"));
	}
}