package com.liferay.test.portlet.holders;

import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.test.portlet.NoSuchAuthorException;
import com.liferay.test.portlet.NoSuchBookException;
import com.liferay.test.portlet.NoSuchGenreException;
import com.liferay.test.portlet.NoSuchPublisherException;
import com.liferay.test.portlet.model.Author;
import com.liferay.test.portlet.model.Book;
import com.liferay.test.portlet.model.Genre;
import com.liferay.test.portlet.model.Publisher;
import com.liferay.test.portlet.permissions.BookPermission;
import com.liferay.test.portlet.service.AuthorLocalServiceUtil;
import com.liferay.test.portlet.service.BookLocalServiceUtil;
import com.liferay.test.portlet.service.GenreLocalServiceUtil;
import com.liferay.test.portlet.service.PublisherLocalServiceUtil;

public class BooksHolder {
	private long bookId;
	private String name;
	private String releaseDate;
	private String genre;
	private String author;
	private String publisher;
	private boolean viewPermission;
	private boolean editPermission;
	private boolean deletePermission;

	public BooksHolder(long groupId, long id) throws NestableException {
		Book book;
		Genre genre;
		Author author;
		Publisher publisher;
		try {
			book = BookLocalServiceUtil.getBookById(id);
			genre = GenreLocalServiceUtil.getGenreById(book.getGenreId());
			author = AuthorLocalServiceUtil.getAuthorById(book.getAuthorId());
			publisher = PublisherLocalServiceUtil.getPublisherById(book.getPublisherId());

			this.bookId = id;
			this.name = book.getName();
			this.releaseDate = book.getReleaseDate();
			this.genre = genre.getName();
			this.author = author.getName();
			this.publisher = publisher.getName();
	
			this.viewPermission = BookPermission.hasViewPermission(groupId, id);
			this.editPermission = BookPermission.hasEditPermission(groupId, id);
			this.deletePermission = BookPermission.hasDeletePermission(groupId, id);
		} catch (NoSuchBookException | SystemException | NoSuchPublisherException
				| NoSuchAuthorException | NoSuchGenreException e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public boolean isViewPermission() {
		return viewPermission;
	}

	public void setViewPermission(boolean viewPermission) {
		this.viewPermission = viewPermission;
	}

	public boolean isEditPermission() {
		return editPermission;
	}

	public void setEditPermission(boolean editPermission) {
		this.editPermission = editPermission;
	}

	public boolean isDeletePermission() {
		return deletePermission;
	}

	public void setDeletePermission(boolean deletePermission) {
		this.deletePermission = deletePermission;
	}

}
