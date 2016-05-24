/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.test.portlet.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.test.portlet.NoSuchGenreException;
import com.liferay.test.portlet.model.Genre;
import com.liferay.test.portlet.model.impl.GenreImpl;
import com.liferay.test.portlet.model.impl.GenreModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the genre service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kmv
 * @see GenrePersistence
 * @see GenreUtil
 * @generated
 */
public class GenrePersistenceImpl extends BasePersistenceImpl<Genre>
	implements GenrePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link GenreUtil} to access the genre persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = GenreImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(GenreModelImpl.ENTITY_CACHE_ENABLED,
			GenreModelImpl.FINDER_CACHE_ENABLED, GenreImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(GenreModelImpl.ENTITY_CACHE_ENABLED,
			GenreModelImpl.FINDER_CACHE_ENABLED, GenreImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(GenreModelImpl.ENTITY_CACHE_ENABLED,
			GenreModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public GenrePersistenceImpl() {
		setModelClass(Genre.class);
	}

	/**
	 * Caches the genre in the entity cache if it is enabled.
	 *
	 * @param genre the genre
	 */
	@Override
	public void cacheResult(Genre genre) {
		EntityCacheUtil.putResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
			GenreImpl.class, genre.getPrimaryKey(), genre);

		genre.resetOriginalValues();
	}

	/**
	 * Caches the genres in the entity cache if it is enabled.
	 *
	 * @param genres the genres
	 */
	@Override
	public void cacheResult(List<Genre> genres) {
		for (Genre genre : genres) {
			if (EntityCacheUtil.getResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
						GenreImpl.class, genre.getPrimaryKey()) == null) {
				cacheResult(genre);
			}
			else {
				genre.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all genres.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(GenreImpl.class.getName());
		}

		EntityCacheUtil.clearCache(GenreImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the genre.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Genre genre) {
		EntityCacheUtil.removeResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
			GenreImpl.class, genre.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Genre> genres) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Genre genre : genres) {
			EntityCacheUtil.removeResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
				GenreImpl.class, genre.getPrimaryKey());
		}
	}

	/**
	 * Creates a new genre with the primary key. Does not add the genre to the database.
	 *
	 * @param genreId the primary key for the new genre
	 * @return the new genre
	 */
	@Override
	public Genre create(long genreId) {
		Genre genre = new GenreImpl();

		genre.setNew(true);
		genre.setPrimaryKey(genreId);

		return genre;
	}

	/**
	 * Removes the genre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param genreId the primary key of the genre
	 * @return the genre that was removed
	 * @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Genre remove(long genreId)
		throws NoSuchGenreException, SystemException {
		return remove((Serializable)genreId);
	}

	/**
	 * Removes the genre with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the genre
	 * @return the genre that was removed
	 * @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Genre remove(Serializable primaryKey)
		throws NoSuchGenreException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Genre genre = (Genre)session.get(GenreImpl.class, primaryKey);

			if (genre == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGenreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(genre);
		}
		catch (NoSuchGenreException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Genre removeImpl(Genre genre) throws SystemException {
		genre = toUnwrappedModel(genre);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(genre)) {
				genre = (Genre)session.get(GenreImpl.class,
						genre.getPrimaryKeyObj());
			}

			if (genre != null) {
				session.delete(genre);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (genre != null) {
			clearCache(genre);
		}

		return genre;
	}

	@Override
	public Genre updateImpl(com.liferay.test.portlet.model.Genre genre)
		throws SystemException {
		genre = toUnwrappedModel(genre);

		boolean isNew = genre.isNew();

		Session session = null;

		try {
			session = openSession();

			if (genre.isNew()) {
				session.save(genre);

				genre.setNew(false);
			}
			else {
				session.merge(genre);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
			GenreImpl.class, genre.getPrimaryKey(), genre);

		return genre;
	}

	protected Genre toUnwrappedModel(Genre genre) {
		if (genre instanceof GenreImpl) {
			return genre;
		}

		GenreImpl genreImpl = new GenreImpl();

		genreImpl.setNew(genre.isNew());
		genreImpl.setPrimaryKey(genre.getPrimaryKey());

		genreImpl.setGenreId(genre.getGenreId());
		genreImpl.setName(genre.getName());

		return genreImpl;
	}

	/**
	 * Returns the genre with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the genre
	 * @return the genre
	 * @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Genre findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGenreException, SystemException {
		Genre genre = fetchByPrimaryKey(primaryKey);

		if (genre == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGenreException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return genre;
	}

	/**
	 * Returns the genre with the primary key or throws a {@link com.liferay.test.portlet.NoSuchGenreException} if it could not be found.
	 *
	 * @param genreId the primary key of the genre
	 * @return the genre
	 * @throws com.liferay.test.portlet.NoSuchGenreException if a genre with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Genre findByPrimaryKey(long genreId)
		throws NoSuchGenreException, SystemException {
		return findByPrimaryKey((Serializable)genreId);
	}

	/**
	 * Returns the genre with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the genre
	 * @return the genre, or <code>null</code> if a genre with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Genre fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Genre genre = (Genre)EntityCacheUtil.getResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
				GenreImpl.class, primaryKey);

		if (genre == _nullGenre) {
			return null;
		}

		if (genre == null) {
			Session session = null;

			try {
				session = openSession();

				genre = (Genre)session.get(GenreImpl.class, primaryKey);

				if (genre != null) {
					cacheResult(genre);
				}
				else {
					EntityCacheUtil.putResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
						GenreImpl.class, primaryKey, _nullGenre);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(GenreModelImpl.ENTITY_CACHE_ENABLED,
					GenreImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return genre;
	}

	/**
	 * Returns the genre with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param genreId the primary key of the genre
	 * @return the genre, or <code>null</code> if a genre with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Genre fetchByPrimaryKey(long genreId) throws SystemException {
		return fetchByPrimaryKey((Serializable)genreId);
	}

	/**
	 * Returns all the genres.
	 *
	 * @return the genres
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Genre> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.GenreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of genres
	 * @param end the upper bound of the range of genres (not inclusive)
	 * @return the range of genres
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Genre> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the genres.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.GenreModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of genres
	 * @param end the upper bound of the range of genres (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of genres
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Genre> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Genre> list = (List<Genre>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_GENRE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GENRE;

				if (pagination) {
					sql = sql.concat(GenreModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Genre>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Genre>(list);
				}
				else {
					list = (List<Genre>)QueryUtil.list(q, getDialect(), start,
							end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the genres from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Genre genre : findAll()) {
			remove(genre);
		}
	}

	/**
	 * Returns the number of genres.
	 *
	 * @return the number of genres
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GENRE);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the genre persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.test.portlet.model.Genre")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Genre>> listenersList = new ArrayList<ModelListener<Genre>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Genre>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(GenreImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_GENRE = "SELECT genre FROM Genre genre";
	private static final String _SQL_COUNT_GENRE = "SELECT COUNT(genre) FROM Genre genre";
	private static final String _ORDER_BY_ENTITY_ALIAS = "genre.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Genre exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(GenrePersistenceImpl.class);
	private static Genre _nullGenre = new GenreImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Genre> toCacheModel() {
				return _nullGenreCacheModel;
			}
		};

	private static CacheModel<Genre> _nullGenreCacheModel = new CacheModel<Genre>() {
			@Override
			public Genre toEntityModel() {
				return _nullGenre;
			}
		};
}