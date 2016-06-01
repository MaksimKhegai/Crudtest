package com.liferay.test.portlet.permissions;

import com.liferay.test.portlet.model.Author;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class AuthorPermission {
	public static void check(PermissionChecker permissionChecker, long groupId, long authorId,
			String actionId) throws PortalException, SystemException {

		if (!contains(permissionChecker, groupId, authorId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker, long groupId,
			long authorId, String actionId) throws PortalException, SystemException {
		return (permissionChecker
				.hasPermission(groupId, Author.class.getName(), authorId, actionId));

		// return permissionChecker.hasOwnerPermission(20154,
		// Book.class.getName(), bookId, 20198, actionId);
	}
}