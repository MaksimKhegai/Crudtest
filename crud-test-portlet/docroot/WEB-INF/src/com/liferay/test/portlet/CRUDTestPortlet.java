package com.liferay.test.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.PageContext;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.ResourceLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.test.portlet.service.AuthorLocalServiceUtil;
import com.liferay.test.portlet.service.BookLocalServiceUtil;
import com.liferay.test.portlet.service.GenreLocalServiceUtil;
import com.liferay.test.portlet.service.PublisherLocalServiceUtil;
import com.liferay.test.portlet.holders.AuthorsHolder;
import com.liferay.test.portlet.holders.BooksHolder;
import com.liferay.test.portlet.holders.GenresHolder;
import com.liferay.test.portlet.holders.PermissionsHolder;
import com.liferay.test.portlet.holders.PublishersHolder;
import com.liferay.test.portlet.model.*;

/**
 * Portlet implementation class CRUDTestPortlet
 */

public class CRUDTestPortlet extends MVCPortlet {
	private long currentBookIndex = 0;
	private long currentAuthorIndex = 0;
	private long currentGenreIndex = 0;
	private long currentPublisherIndex = 0;

	/*
	 * private boolean booksUpdated = true; private boolean authorsUpdated =
	 * true; private boolean genresUpdated = true; private boolean
	 * publishersUpdated = true;
	 */

	/**
	 * Overrides base render method
	 * 
	 * @param request
	 *            Render request object
	 * @param response
	 *            Render response object
	 * @throws IOException
	 * @throws PortletException
	 * @throws P
	 */
	public void render(RenderRequest request, RenderResponse response) throws IOException,
			PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		try {
			request.setAttribute("booksArray", getAllBooksInfo(groupId));
			request.setAttribute("authorsArray", getAllAuthorsInfo(groupId));
			request.setAttribute("genresArray", getAllGenresInfo(groupId));
			request.setAttribute("publishersArray", getAllPublishersInfo(groupId));
		} catch (SystemException | PortalException e1) {
			SessionErrors.add(request, "getInfoError");
			return;
		}
		request.setAttribute("currentBookIndex", currentBookIndex);
		request.setAttribute("currentAuthorIndex", currentAuthorIndex);
		request.setAttribute("currentGenreIndex", currentGenreIndex);
		request.setAttribute("currentPublisherIndex", currentPublisherIndex);

		PermissionsHolder permissionsObject = new PermissionsHolder();
		permissionsObject.checkGlobalPermissions(groupId,
				String.valueOf(PortalUtil.getCompanyId(request)));

		/*
		 * System.out.println(request.getAttribute(
		 * "javax.servlet.include.request_uri"));
		 */
		request.setAttribute("permissionsObject", permissionsObject);
		SessionMessages.clear(request);
		super.render(request, response);
	}

	/**
	 * Get all information about books in one array
	 * 
	 * @return array containing BooksHolders
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<BooksHolder> getAllBooksInfo(long groupId) throws SystemException, PortalException {
		List<BooksHolder> list = new ArrayList<BooksHolder>();
		for (Book book : BookLocalServiceUtil.getBooks()) {
			BooksHolder booksHolder = new BooksHolder(groupId, book.getBookId());
			list.add(booksHolder);
		}
		return list;
	}

	/**
	 * Get all information about authors in one array
	 * 
	 * @return array containing AuthorsHolders
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<AuthorsHolder> getAllAuthorsInfo(long groupId) throws SystemException,
			PortalException {
		List<AuthorsHolder> list = new ArrayList<AuthorsHolder>();
		for (Author author : AuthorLocalServiceUtil.getAuthors()) {
			AuthorsHolder authorsHolder = new AuthorsHolder(groupId, author.getAuthorId());
			list.add(authorsHolder);
		}
		return list;
	}

	/**
	 * Get all information about genres in one array
	 * 
	 * @return array containing GenresHolders
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<GenresHolder> getAllGenresInfo(long groupId) throws SystemException,
			PortalException {
		List<GenresHolder> list = new ArrayList<GenresHolder>();
		for (Genre genre : GenreLocalServiceUtil.getGenres()) {
			GenresHolder genresHolder = new GenresHolder(groupId, genre.getGenreId());
			list.add(genresHolder);
		}
		return list;
	}

	/**
	 * Get all information about publishers in one array
	 * 
	 * @return array containing PublishersHolders
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<PublishersHolder> getAllPublishersInfo(long groupId) throws SystemException,
			PortalException {
		List<PublishersHolder> list = new ArrayList<PublishersHolder>();
		for (Publisher publisher : PublisherLocalServiceUtil.getPublishers()) {
			PublishersHolder publishersHolder = new PublishersHolder(groupId,
					publisher.getPublisherId());
			list.add(publishersHolder);
		}
		return list;
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
	public void addAuthor(ActionRequest request, ActionResponse response) {
		if (!isAProperDate(ParamUtil.getString(request, "BirthDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/add_author.jsp");
			SessionErrors.add(request, "dateError");
			return;
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = themeDisplay.getLayout().getGroupId();
		long authorId;
		try {
			authorId = AuthorLocalServiceUtil.getMaxId() + 1;
		} catch (SystemException e1) {
			SessionErrors.add(request, "idError");
			return;
		}
		try {
			AuthorLocalServiceUtil.addAuthor(companyId, groupId,
					PortalUtil.getUserId(request), authorId, ParamUtil.getString(request, "Name"),
					ParamUtil.getString(request, "BirthDate"));
		} catch (SystemException e) {
			SessionErrors.add(request, "addError");
			return;
		}
		try {
			ResourceLocalServiceUtil.updateResources(companyId, groupId, Author.class.getName(),
					String.valueOf(authorId), request.getParameterValues("groupPermissions"),
					request.getParameterValues("guestPermissions"));
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "permissionsUpdateError");
		}
		response.setRenderParameter("mvcPath", "/html/crudtest/show_authors.jsp");
	}

	/**
	 * Removes an author from database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void removeAuthor(ActionRequest request, ActionResponse response) {
		Author author = AuthorLocalServiceUtil.getAuthors().get(
				ParamUtil.getInteger(request, "AuthorIndex"));
		try {
			AuthorLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request),
					author.getAuthorId());
			AuthorLocalServiceUtil.deleteAuthor(author.getAuthorId());
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "deleteError");
			return;
		}

		response.setRenderParameter("mvcPath", "/html/crudtest/show_authors.jsp");
	}

	/**
	 * Redirects to the edit page while passing author index
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void editAuthor(ActionRequest request, ActionResponse response) {
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
	public void updateAuthor(ActionRequest request, ActionResponse response) {
		if (!isAProperDate(ParamUtil.getString(request, "BirthDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/edit_author.jsp");
			SessionErrors.add(request, "dateError");
			return;
		}
		Author author = AuthorLocalServiceUtil.getAuthors().get(
				ParamUtil.getInteger(request, "AuthorIndex"));
		author.setName(ParamUtil.getString(request, "Name"));
		author.setBirthDate(ParamUtil.getString(request, "BirthDate"));
		try {
			AuthorLocalServiceUtil.updateAuthor(author);
		} catch (SystemException e) {
			SessionErrors.add(request, "updateError");
			return;
		}
		response.setRenderParameter("mvcPath", "/html/crudtest/show_authors.jsp");
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
	public void addBook(ActionRequest request, ActionResponse response) {
		if (!isAProperDate(ParamUtil.getString(request, "ReleaseDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/add_book.jsp");
			SessionErrors.add(request, "dateError");
			return;
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		long companyId = PortalUtil.getCompanyId(request);
		long bookId;
		try {
			bookId = BookLocalServiceUtil.getMaxId() + 1;
		} catch (SystemException e1) {
			SessionErrors.add(request, "idError");
			return;
		}
		try {
			BookLocalServiceUtil.addBook(PortalUtil.getCompanyId(request), groupId,
					PortalUtil.getUserId(request), bookId, ParamUtil.getString(request, "Name"),
					ParamUtil.getLong(request, "Author"), ParamUtil.getLong(request, "Genre"),
					ParamUtil.getLong(request, "Publisher"),
					ParamUtil.getString(request, "ReleaseDate"));
		} catch (PortalException e) {
			SessionErrors.add(request, "resourceAddError");
			return;
		} catch (SystemException e) {
			SessionErrors.add(request, "addError");
			return;
		}
		// PermissionThreadLocal.getPermissionChecker().hasPermission();

		/*
		 * Role user = null; try { user =
		 * RoleLocalServiceUtil.getRole(companyId, "GUEST");
		 * System.out.println(user.getUserId()); } catch (PortalException e) {
		 * e.printStackTrace(); }
		 */
		try {
			ResourceLocalServiceUtil.updateResources(companyId, groupId, Book.class.getName(),
					String.valueOf(bookId), request.getParameterValues("groupPermissions"),
					request.getParameterValues("guestPermissions"));
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "permissionsUpdateError");
		}

	}

	/**
	 * Removes a book from database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void removeBook(ActionRequest request, ActionResponse response) {
		Book book = BookLocalServiceUtil.getBooks().get(ParamUtil.getInteger(request, "BookIndex"));
		try {
			BookLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request),
					book.getBookId());
			BookLocalServiceUtil.deleteBook(book.getBookId());
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "deleteError");
			return;
		}
	}

	/**
	 * Redirects to the edit page while passing book index
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void editBook(ActionRequest request, ActionResponse response) {
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
	public void updateBook(ActionRequest request, ActionResponse response) {
		if (!isAProperDate(ParamUtil.getString(request, "ReleaseDate"))) {
			response.setRenderParameter("mvcPath", "/html/crudtest/edit_book.jsp");
			SessionErrors.add(request, "request_error", "Wrong date format.");
			return;
		}
		Book book = BookLocalServiceUtil.getBooks().get(ParamUtil.getInteger(request, "BookIndex"));
		book.setName(ParamUtil.getString(request, "Name"));
		book.setAuthorId(ParamUtil.getLong(request, "Author"));
		book.setGenreId(ParamUtil.getLong(request, "Genre"));
		book.setPublisherId(ParamUtil.getLong(request, "Publisher"));
		book.setReleaseDate(ParamUtil.getString(request, "ReleaseDate"));
		try {
			BookLocalServiceUtil.updateBook(book);
		} catch (SystemException e) {
			SessionErrors.add(request, "updateError");
			return;
		}

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
	public void addGenre(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		long companyId = PortalUtil.getCompanyId(request);
		long genreId;
		try {
			genreId = GenreLocalServiceUtil.getMaxId() + 1;
		} catch (SystemException e1) {
			SessionErrors.add(request, "idError");
			return;
		}
		try {
			GenreLocalServiceUtil.addGenre(companyId, groupId,
					PortalUtil.getUserId(request), genreId, ParamUtil.getString(request, "Name"));
		} catch (SystemException e) {
			SessionErrors.add(request, "addError");
			return;
		}
		try {
			ResourceLocalServiceUtil.updateResources(companyId, groupId, Genre.class.getName(),
					String.valueOf(genreId), request.getParameterValues("groupPermissions"),
					request.getParameterValues("guestPermissions"));
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "permissionsUpdateError");
			return;
		}
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
	public void removeGenre(ActionRequest request, ActionResponse response) {
		Genre genre = GenreLocalServiceUtil.getGenres().get(
				ParamUtil.getInteger(request, "GenreIndex"));
		try {
			GenreLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request),
					genre.getGenreId());
			GenreLocalServiceUtil.deleteGenre(genre.getGenreId());
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "deleteError");
			return;
		}

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
	public void editGenre(ActionRequest request, ActionResponse response) {
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
	public void updateGenre(ActionRequest request, ActionResponse response) {
		Genre genre = GenreLocalServiceUtil.getGenres().get(
				ParamUtil.getInteger(request, "GenreIndex"));
		genre.setName(ParamUtil.getString(request, "Name"));
		try {
			GenreLocalServiceUtil.updateGenre(genre);
		} catch (SystemException e) {
			SessionErrors.add(request, "updateError");
			return;
		}
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
	public void addPublisher(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getLayout().getGroupId();
		long companyId = PortalUtil.getCompanyId(request);
		long publisherId;
		try {
			publisherId = PublisherLocalServiceUtil.getMaxId() + 1;
		} catch (SystemException e1) {
			SessionErrors.add(request, "idError");
			return;
		}
		try {
			PublisherLocalServiceUtil.addPublisher(companyId,
					groupId, PortalUtil.getUserId(request), publisherId,
					ParamUtil.getString(request, "Name"));
		} catch (SystemException e) {
			SessionErrors.add(request, "addError");
			return;
		}
		try {
			ResourceLocalServiceUtil.updateResources(companyId, groupId, Publisher.class.getName(),
					String.valueOf(publisherId), request.getParameterValues("groupPermissions"),
					request.getParameterValues("guestPermissions"));
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "permissionsUpdateError");
		}
		response.setRenderParameter("mvcPath", "/html/crudtest/show_publishers.jsp");
	}

	/**
	 * Removes a publisher from database
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void removePublisher(ActionRequest request, ActionResponse response) {
		Publisher publisher = PublisherLocalServiceUtil.getPublishers().get(
				ParamUtil.getInteger(request, "PublisherIndex"));
		try {
			PublisherLocalServiceUtil.deletePermissions(PortalUtil.getCompanyId(request),
					publisher.getPublisherId());
			PublisherLocalServiceUtil.deletePublisher(publisher.getPublisherId());
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "deleteError");
			return;
		}

		response.setRenderParameter("mvcPath", "/html/crudtest/show_publishers.jsp");
	}

	/**
	 * Redirects to the edit page while passing publisher index
	 * 
	 * @param request
	 *            Action request object
	 * @param response
	 *            Action response object
	 */
	public void editPublisher(ActionRequest request, ActionResponse response) {
		response.setRenderParameter("mvcPath", "/html/crudtest/edit_publisher.jsp");
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
	public void updatePublisher(ActionRequest request, ActionResponse response) {
		Publisher publisher = PublisherLocalServiceUtil.getPublishers().get(
				ParamUtil.getInteger(request, "PublisherIndex"));
		publisher.setName(ParamUtil.getString(request, "Name"));
		try {
			PublisherLocalServiceUtil.updatePublisher(publisher);
		} catch (SystemException e) {
			SessionErrors.add(request, "updateError");
			return;
		}
		response.setRenderParameter("mvcPath", "/html/crudtest/show_publishers.jsp");
	}
}
