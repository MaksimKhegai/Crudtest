package com.liferay.test.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.security.permission.PermissionThreadLocal;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.test.portlet.service.AuthorLocalServiceUtil;
import com.liferay.test.portlet.service.BookLocalServiceUtil;
import com.liferay.test.portlet.service.GenreLocalServiceUtil;
import com.liferay.test.portlet.service.PublisherLocalServiceUtil;
import com.liferay.test.portlet.service.impl.BookLocalServiceImpl;
import com.liferay.test.portlet.model.*;

/**
 * Portlet implementation class CRUDTestPortlet
 */

public class CRUDTestPortlet extends MVCPortlet {
	private long currentBookIndex = 0;
	private long currentAuthorIndex = 0;
	private long currentGenreIndex = 0;
	private long currentPublisherIndex = 0;
	
	private static final Log log = LogFactoryUtil.getLog(BookLocalServiceImpl.class);
	/**
	 * Overrides base render method
	 * 
	 * @param request
	 *            Render request object
	 * @param response
	 *            Render response object
	 */
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {
		request.setAttribute("booksArray", BookLocalServiceUtil.getBooks());
		request.setAttribute("currentBookIndex", currentBookIndex);
		request.setAttribute("authorsArray",
				AuthorLocalServiceUtil.getAuthors());
		request.setAttribute("currentAuthorIndex", currentAuthorIndex);
		request.setAttribute("genresArray", GenreLocalServiceUtil.getGenres());
		request.setAttribute("currentGenreIndex", currentGenreIndex);
		request.setAttribute("publishersArray",
				PublisherLocalServiceUtil.getPublishers());
		request.setAttribute("currentPublisherIndex", currentPublisherIndex);
		
		PermissionsHolder permissionsObject = new PermissionsHolder();
		try {
			ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long portletGroupId= themeDisplay.getLayout().getGroupId();
			permissionsObject.checkGlobalPermissions(portletGroupId, 
					String.valueOf(PortalUtil.getCompanyId(request)));
			permissionsObject.checkBookPermissions(portletGroupId);
			permissionsObject.checkAuthorPermissions(portletGroupId);
			permissionsObject.checkPublisherPermissions(portletGroupId);
			permissionsObject.checkGenrePermissions(portletGroupId);
			request.setAttribute("permissionsObject", permissionsObject);
		} catch (PortalException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SessionMessages.clear(request);
		super.render(request, response);
	}

	/**
	 * Check if string is a proper date
	 * 
	 * @param string
	 * @return true if the string is in a proper date format
	 */
	public boolean isAProperDate(String string) {
		Pattern p = Pattern.compile("\\d\\d\\.\\d\\d\\.\\d\\d");
		Matcher m = p.matcher(string);
		if (!m.matches()) {
			return false;
		}
		return true;
	}

	// Authors
	/**
	 * Adds a new author to the database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void addAuthor(ActionRequest request, ActionResponse response)
			throws SystemException {
		if (!isAProperDate(ParamUtil.getString(request, "BirthDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/add_author.jsp");
			SessionErrors.add(request, "error-key");
			//SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			return;
		}
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long portletGroupId= themeDisplay.getLayout().getGroupId();
				
		AuthorLocalServiceUtil.addAuthor(
				PortalUtil.getCompanyId(request),
				portletGroupId, 
				PortalUtil.getUserId(request),
				AuthorLocalServiceUtil.getMaxId() + 1,
				ParamUtil.getString(request, "Name"),
				ParamUtil.getString(request, "BirthDate"));
		response.setRenderParameter("mvcPath",
				"/html/crudtest/show_authors.jsp");
	}

	/**
	 * Removes an author from database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void removeAuthor(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		Author author = AuthorLocalServiceUtil.getAuthors().get(
				ParamUtil.getInteger(request, "AuthorIndex"));
		AuthorLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request), 
								author.getAuthorId());
		AuthorLocalServiceUtil.deleteAuthor(author.getAuthorId());
		response.setRenderParameter("mvcPath",
				"/html/crudtest/show_authors.jsp");
	}

	/**
	 * Redirects to the edit page while passing author index
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void editAuthor(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchBookException, ParseException {
		response.setRenderParameter("mvcPath", "/html/crudtest/edit_author.jsp");
		currentAuthorIndex = ParamUtil.getLong(request, "AuthorIndex");
	}

	/**
	 * Updates an author in database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void updateAuthor(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchBookException, ParseException,
			NoSuchAuthorException {
		if (!isAProperDate(ParamUtil.getString(request, "BirthDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/edit_author.jsp");
			SessionErrors.add(request, "request_error", "Wrong date format.");
			return;
		}
		Author author = AuthorLocalServiceUtil.getAuthors().get(
				ParamUtil.getInteger(request, "AuthorIndex"));
		author.setName(ParamUtil.getString(request, "Name"));
		author.setBirthDate(ParamUtil.getString(request, "BirthDate"));
		AuthorLocalServiceUtil.updateAuthor(author);
		response.setRenderParameter("mvcPath",
				"/html/crudtest/show_authors.jsp");
	}

	// Books
	/**
	 * Adds a new book to the database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void addBook(ActionRequest request, ActionResponse response)
			throws SystemException {
		if (!isAProperDate(ParamUtil.getString(request, "ReleaseDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/add_book.jsp");
			SessionErrors.add(request, "request_error", "Wrong date format.");
			return;
		}
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long portletGroupId= themeDisplay.getLayout().getGroupId();
		BookLocalServiceUtil.addBook(
				PortalUtil.getCompanyId(request),
				portletGroupId, 
				PortalUtil.getUserId(request), 
				BookLocalServiceUtil.getMaxId() + 1,
				ParamUtil.getString(request, "Name"),
				ParamUtil.getLong(request, "Author"),
				ParamUtil.getLong(request, "Genre"),
				ParamUtil.getLong(request, "Publisher"),
				ParamUtil.getString(request, "ReleaseDate"));
		//PermissionThreadLocal.getPermissionChecker().hasPermission();
	}

	/**
	 * Removes a book from database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void removeBook(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		Book book = BookLocalServiceUtil.getBooks().get(
				ParamUtil.getInteger(request, "BookIndex"));
		BookLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request), book.getBookId());
		BookLocalServiceUtil.deleteBook(book.getBookId());
	}

	/**
	 * Redirects to the edit page while passing book index
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void editBook(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchBookException, ParseException {
		response.setRenderParameter("mvcPath", "/html/crudtest/edit_book.jsp");
		currentBookIndex = ParamUtil.getLong(request, "BookIndex");
	}

	/**
	 * Updates a book in database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void updateBook(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchBookException, ParseException {
		if (!isAProperDate(ParamUtil.getString(request, "ReleaseDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/edit_book.jsp");
			SessionErrors.add(request, "request_error", "Wrong date format.");
			return;
		}
		Book book = BookLocalServiceUtil.getBooks().get(
				ParamUtil.getInteger(request, "BookIndex"));
		book.setName(ParamUtil.getString(request, "Name"));
		book.setAuthorId(ParamUtil.getLong(request, "Author"));
		book.setGenreId(ParamUtil.getLong(request, "Genre"));
		book.setPublisherId(ParamUtil.getLong(request, "Publisher"));
		book.setReleaseDate(ParamUtil.getString(request, "ReleaseDate"));
		BookLocalServiceUtil.updateBook(book);
	}

	// Genres
	/**
	 * Adds a new genre to the database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void addGenre(ActionRequest request, ActionResponse response)
			throws SystemException {
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long portletGroupId= themeDisplay.getLayout().getGroupId();
		GenreLocalServiceUtil.addGenre(PortalUtil.getCompanyId(request),
				portletGroupId, 
				PortalUtil.getUserId(request),
				GenreLocalServiceUtil.getMaxId() + 1,
				ParamUtil.getString(request, "Name"));
		response.setRenderParameter("mvcPath", "/html/crudtest/show_genres.jsp");
	}

	/**
	 * Removes a genre from database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void removeGenre(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		Genre genre = GenreLocalServiceUtil.getGenres().get(
				ParamUtil.getInteger(request, "GenreIndex"));
		GenreLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request), 
								genre.getGenreId());
		GenreLocalServiceUtil.deleteGenre(genre.getGenreId());
		response.setRenderParameter("mvcPath", "/html/crudtest/show_genres.jsp");
	}

	/**
	 * Redirects to the edit page while passing genre index
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void editGenre(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchGenreException, ParseException {
		response.setRenderParameter("mvcPath", "/html/crudtest/edit_genre.jsp");
		currentGenreIndex = ParamUtil.getLong(request, "GenreIndex");
	}

	/**
	 * Updates a genre in database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void updateGenre(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchGenreException, ParseException {
		Genre genre = GenreLocalServiceUtil.getGenres().get(
				ParamUtil.getInteger(request, "GenreIndex"));
		genre.setName(ParamUtil.getString(request, "Name"));
		GenreLocalServiceUtil.updateGenre(genre);
		response.setRenderParameter("mvcPath", "/html/crudtest/show_genres.jsp");
	}

	// Publishers
	/**
	 * Adds a new publisher to the database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void addPublisher(ActionRequest request, ActionResponse response)
			throws SystemException {
		ThemeDisplay themeDisplay= (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long portletGroupId= themeDisplay.getLayout().getGroupId();
		PublisherLocalServiceUtil.addPublisher(
				PortalUtil.getCompanyId(request),
				portletGroupId, 
				PortalUtil.getUserId(request),
				PublisherLocalServiceUtil.getMaxId() + 1,
				ParamUtil.getString(request, "Name"));
		response.setRenderParameter("mvcPath",
				"/html/crudtest/show_publishers.jsp");
	}

	/**
	 * Removes a publisher from database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void removePublisher(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException {
		Publisher publisher = PublisherLocalServiceUtil.getPublishers().get(
				ParamUtil.getInteger(request, "PublisherIndex"));
		PublisherLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request), 
								publisher.getPublisherId());
		PublisherLocalServiceUtil.deletePublisher(publisher.getPublisherId());
		response.setRenderParameter("mvcPath",
				"/html/crudtest/show_publishers.jsp");
	}

	/**
	 * Redirects to the edit page while passing publisher index
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void editPublisher(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchPublisherException, ParseException {
		response.setRenderParameter("mvcPath",
				"/html/crudtest/edit_publisher.jsp");
		currentPublisherIndex = ParamUtil.getLong(request, "PublisherIndex");
	}

	/**
	 * Updates a publisher in database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void updatePublisher(ActionRequest request, ActionResponse response)
			throws SystemException, NoSuchPublisherException, ParseException {
		Publisher publisher = PublisherLocalServiceUtil.getPublishers().get(
				ParamUtil.getInteger(request, "PublisherIndex"));
		publisher.setName(ParamUtil.getString(request, "Name"));
		PublisherLocalServiceUtil.updatePublisher(publisher);
		response.setRenderParameter("mvcPath",
				"/html/crudtest/show_publishers.jsp");
	}
}
