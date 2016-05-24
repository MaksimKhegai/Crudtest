package com.liferay.test.portlet;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.model.Book;
import com.liferay.test.portlet.model.Genre;
import com.liferay.test.portlet.model.Publisher;
import com.liferay.test.portlet.service.AuthorLocalServiceUtil;
import com.liferay.test.portlet.service.BookLocalServiceUtil;
import com.liferay.test.portlet.service.GenreLocalServiceUtil;
import com.liferay.test.portlet.service.PublisherLocalServiceUtil;
import com.liferay.test.portlet.service.permission.AuthorPermission;
import com.liferay.test.portlet.service.permission.BookPermission;
import com.liferay.test.portlet.service.permission.GenrePermission;
import com.liferay.test.portlet.service.permission.PublisherPermission;

public class PermissionsHolder {
	public List<PermissionClass> bookPermissions;
	public List<PermissionClass> authorPermissions;
	public List<PermissionClass> publisherPermissions;
	public List<PermissionClass> genrePermissions;
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
	
	public void checkBookPermissions(long groupId) throws PortalException, SystemException {
		bookPermissions = new ArrayList<PermissionClass>();
		for (Book book : BookLocalServiceUtil.getBooks()) {
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			long bookId = book.getBookId();
			PermissionClass permission = new PermissionClass();
			permission.view = BookPermission.contains(permissionChecker, groupId, bookId, "VIEW");
			permission.update = BookPermission.contains(permissionChecker, groupId, bookId, "UPDATE");
			permission.delete = BookPermission.contains(permissionChecker, groupId, bookId, "DELETE");
			permission.add = BookPermission.contains(permissionChecker, groupId, bookId, "ADD_TO_PAGE");
			bookPermissions.add(permission);
		}
	}
	
	public void checkAuthorPermissions(long groupId) throws PortalException, SystemException {
		authorPermissions = new ArrayList<PermissionClass>();
		for (Author author : AuthorLocalServiceUtil.getAuthors()) {
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			long authorId = author.getAuthorId();
			PermissionClass permission = new PermissionClass();
			permission.view = AuthorPermission.contains(permissionChecker, groupId, authorId, "VIEW");
			permission.update = AuthorPermission.contains(permissionChecker, groupId, authorId, "UPDATE");
			permission.delete = AuthorPermission.contains(permissionChecker, groupId, authorId, "DELETE");
			permission.add = AuthorPermission.contains(permissionChecker, groupId, authorId, "ADD_TO_PAGE");
			authorPermissions.add(permission);
		}
	}
	
	public void checkPublisherPermissions(long groupId) throws PortalException, SystemException {
		publisherPermissions = new ArrayList<PermissionClass>();
		for (Publisher publisher : PublisherLocalServiceUtil.getPublishers()) {
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			long publisherId = publisher.getPublisherId();
			PermissionClass permission = new PermissionClass();
			permission.view = PublisherPermission.contains(permissionChecker, groupId, publisherId, "VIEW");
			permission.update = PublisherPermission.contains(permissionChecker, groupId, publisherId, "UPDATE");
			permission.delete = PublisherPermission.contains(permissionChecker, groupId, publisherId, "DELETE");
			permission.add = PublisherPermission.contains(permissionChecker, groupId, publisherId, "ADD_TO_PAGE");
			publisherPermissions.add(permission);
		}
	}
	
	public void checkGenrePermissions(long groupId) throws PortalException, SystemException {
		genrePermissions = new ArrayList<PermissionClass>();
		for (Genre genre : GenreLocalServiceUtil.getGenres()) {
			PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
			long genreId = genre.getGenreId();
			PermissionClass permission = new PermissionClass();
			permission.view = GenrePermission.contains(permissionChecker, groupId, genreId, "VIEW");
			permission.update = GenrePermission.contains(permissionChecker, groupId, genreId, "UPDATE");
			permission.delete = GenrePermission.contains(permissionChecker, groupId, genreId, "DELETE");
			permission.add = GenrePermission.contains(permissionChecker, groupId, genreId, "ADD_TO_PAGE");
			genrePermissions.add(permission);
		}
	}
	
	public List<PermissionClass> getBookPermissions() {
		return bookPermissions;
	}
	
	public List<PermissionClass> getAuthorPermissions() {
		return authorPermissions;
	}
	
	public List<PermissionClass> getGenrePermissions() {
		return genrePermissions;
	}
	
	public List<PermissionClass> getPublisherPermissions() {
		return publisherPermissions;
	}
	
	public PermissionClass getGlobalPermissions() {
		return globalPermissions;
	}
}
