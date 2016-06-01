package com.liferay.test.portlet.permissions;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.model.Publisher;

public class PublisherPermission {
	public static boolean contains(long groupId, long publisherId, String actionId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Publisher.class.getName(), publisherId,
				actionId));
	}

	public static boolean hasViewPermission(long groupId, long publisherId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Publisher.class.getName(), publisherId,
				"VIEW"));
	}

	public static boolean hasEditPermission(long groupId, long publisherId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Publisher.class.getName(), publisherId,
				"UPDATE"));
	}

	public static boolean hasDeletePermission(long groupId, long publisherId)
			throws PortalException, SystemException {
		PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
		return (permissionChecker.hasPermission(groupId, Publisher.class.getName(), publisherId,
				"DELETE"));
	}
}