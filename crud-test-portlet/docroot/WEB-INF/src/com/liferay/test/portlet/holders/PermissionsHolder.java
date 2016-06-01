package com.liferay.test.portlet.holders;

import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.permissions.PermissionClass;

public class PermissionsHolder {
	public PermissionClass globalPermissions;
	
	public PermissionsHolder() {
		
	}
	
	public void checkGlobalPermissions(long groupId, String companyId) {
		globalPermissions = new PermissionClass();
		globalPermissions.view = PermissionThreadLocal.getPermissionChecker().hasPermission(
				groupId, companyId, 0, "VIEW");
		globalPermissions.update = PermissionThreadLocal.getPermissionChecker().hasPermission(
				groupId, companyId, 0, "UPDATE");
		globalPermissions.delete = PermissionThreadLocal.getPermissionChecker().hasPermission(
				groupId, companyId, 0, "DELETE");
		globalPermissions.add = PermissionThreadLocal.getPermissionChecker().hasPermission(
				groupId, companyId, 0, "ADD_TO_PAGE");
	}
	
	public PermissionClass getGlobalPermissions() {
		return globalPermissions;
	}
}
