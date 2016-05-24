package com.liferay.test.portlet.service.permission;

import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.model.Book;
import com.liferay.test.portlet.service.BookLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;

public class PublisherPermission {
    public static void check(PermissionChecker permissionChecker, long groupId,
            long publisherId, String actionId) throws PortalException,
            SystemException {

        if (!contains(permissionChecker, groupId, publisherId, actionId)) {
            throw new PrincipalException();
        }
    }

    public static boolean contains(PermissionChecker permissionChecker, long groupId,
            long publisherId, String actionId) throws PortalException,
            SystemException {
        return (permissionChecker.hasPermission(groupId,Author.class.getName(), publisherId, actionId));
        
    	//return permissionChecker.hasOwnerPermission(20154, Book.class.getName(), bookId, 20198, actionId); 
    }
}