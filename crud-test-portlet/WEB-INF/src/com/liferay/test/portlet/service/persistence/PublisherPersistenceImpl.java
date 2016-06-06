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

import com.liferay.test.portlet.NoSuchPublisherException;
import com.liferay.test.portlet.model.Publisher;
import com.liferay.test.portlet.model.impl.PublisherImpl;
import com.liferay.test.portlet.model.impl.PublisherModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the publisher service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author kmv
 * @see PublisherPersistence
 * @see PublisherUtil
 * @generated
 */
public class PublisherPersistenceImpl extends BasePersistenceImpl<Publisher>
	implements PublisherPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link PublisherUtil} to access the publisher persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = PublisherImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PublisherModelImpl.ENTITY_CACHE_ENABLED,
			PublisherModelImpl.FINDER_CACHE_ENABLED, PublisherImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PublisherModelImpl.ENTITY_CACHE_ENABLED,
			PublisherModelImpl.FINDER_CACHE_ENABLED, PublisherImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PublisherModelImpl.ENTITY_CACHE_ENABLED,
			PublisherModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public PublisherPersistenceImpl() {
		setModelClass(Publisher.class);
	}

	/**
	 * Caches the publisher in the entity cache if it is enabled.
	 *
	 * @param publisher the publisher
	 */
	@Override
	public void cacheResult(Publisher publisher) {
		EntityCacheUtil.putResult(PublisherModelImpl.ENTITY_CACHE_ENABLED,
			PublisherImpl.class, publisher.getPrimaryKey(), publisher);

		publisher.resetOriginalValues();
	}

	/**
	 * Caches the publishers in the entity cache if it is enabled.
	 *
	 * @param publishers the publishers
	 */
	@Override
	public void cacheResult(List<Publisher> publishers) {
		for (Publisher publisher : publishers) {
			if (EntityCacheUtil.getResult(
						PublisherModelImpl.ENTITY_CACHE_ENABLED,
						PublisherImpl.class, publisher.getPrimaryKey()) == null) {
				cacheResult(publisher);
			}
			else {
				publisher.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all publishers.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(PublisherImpl.class.getName());
		}

		EntityCacheUtil.clearCache(PublisherImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the publisher.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Publisher publisher) {
		EntityCacheUtil.removeResult(PublisherModelImpl.ENTITY_CACHE_ENABLED,
			PublisherImpl.class, publisher.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Publisher> publishers) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Publisher publisher : publishers) {
			EntityCacheUtil.removeResult(PublisherModelImpl.ENTITY_CACHE_ENABLED,
				PublisherImpl.class, publisher.getPrimaryKey());
		}
	}

	/**
	 * Creates a new publisher with the primary key. Does not add the publisher to the database.
	 *
	 * @param publisherId the primary key for the new publisher
	 * @return the new publisher
	 */
	@Override
	public Publisher create(long publisherId) {
		Publisher publisher = new PublisherImpl();

		publisher.setNew(true);
		publisher.setPrimaryKey(publisherId);

		return publisher;
	}

	/**
	 * Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher that was removed
	 * @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publisher remove(long publisherId)
		throws NoSuchPublisherException, SystemException {
		return remove((Serializable)publisherId);
	}

	/**
	 * Removes the publisher with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the publisher
	 * @return the publisher that was removed
	 * @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publisher remove(Serializable primaryKey)
		throws NoSuchPublisherException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Publisher publisher = (Publisher)session.get(PublisherImpl.class,
					primaryKey);

			if (publisher == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPublisherException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(publisher);
		}
		catch (NoSuchPublisherException nsee) {
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
	protected Publisher removeImpl(Publisher publisher)
		throws SystemException {
		publisher = toUnwrappedModel(publisher);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(publisher)) {
				publisher = (Publisher)session.get(PublisherImpl.class,
						publisher.getPrimaryKeyObj());
			}

			if (publisher != null) {
				session.delete(publisher);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (publisher != null) {
			clearCache(publisher);
		}

		return publisher;
	}

	@Override
	public Publisher updateImpl(
		com.liferay.test.portlet.model.Publisher publisher)
		throws SystemException {
		publisher = toUnwrappedModel(publisher);

		boolean isNew = publisher.isNew();

		Session session = null;

		try {
			session = openSession();

			if (publisher.isNew()) {
				session.save(publisher);

				publisher.setNew(false);
			}
			else {
				session.merge(publisher);
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

		EntityCacheUtil.putResult(PublisherModelImpl.ENTITY_CACHE_ENABLED,
			PublisherImpl.class, publisher.getPrimaryKey(), publisher);

		return publisher;
	}

	protected Publisher toUnwrappedModel(Publisher publisher) {
		if (publisher instanceof PublisherImpl) {
			return publisher;
		}

		PublisherImpl publisherImpl = new PublisherImpl();

		publisherImpl.setNew(publisher.isNew());
		publisherImpl.setPrimaryKey(publisher.getPrimaryKey());

		publisherImpl.setPublisherId(publisher.getPublisherId());
		publisherImpl.setName(publisher.getName());

		return publisherImpl;
	}

	/**
	 * Returns the publisher with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the publisher
	 * @return the publisher
	 * @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publisher findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPublisherException, SystemException {
		Publisher publisher = fetchByPrimaryKey(primaryKey);

		if (publisher == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPublisherException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return publisher;
	}

	/**
	 * Returns the publisher with the primary key or throws a {@link com.liferay.test.portlet.NoSuchPublisherException} if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher
	 * @throws com.liferay.test.portlet.NoSuchPublisherException if a publisher with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publisher findByPrimaryKey(long publisherId)
		throws NoSuchPublisherException, SystemException {
		return findByPrimaryKey((Serializable)publisherId);
	}

	/**
	 * Returns the publisher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the publisher
	 * @return the publisher, or <code>null</code> if a publisher with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publisher fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Publisher publisher = (Publisher)EntityCacheUtil.getResult(PublisherModelImpl.ENTITY_CACHE_ENABLED,
				PublisherImpl.class, primaryKey);

		if (publisher == _nullPublisher) {
			return null;
		}

		if (publisher == null) {
			Session session = null;

			try {
				session = openSession();

				publisher = (Publisher)session.get(PublisherImpl.class,
						primaryKey);

				if (publisher != null) {
					cacheResult(publisher);
				}
				else {
					EntityCacheUtil.putResult(PublisherModelImpl.ENTITY_CACHE_ENABLED,
						PublisherImpl.class, primaryKey, _nullPublisher);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(PublisherModelImpl.ENTITY_CACHE_ENABLED,
					PublisherImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return publisher;
	}

	/**
	 * Returns the publisher with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param publisherId the primary key of the publisher
	 * @return the publisher, or <code>null</code> if a publisher with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Publisher fetchByPrimaryKey(long publisherId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)publisherId);
	}

	/**
	 * Returns all the publishers.
	 *
	 * @return the publishers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publisher> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.PublisherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @return the range of publishers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publisher> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the publishers.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.test.portlet.model.impl.PublisherModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of publishers
	 * @param end the upper bound of the range of publishers (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of publishers
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Publisher> findAll(int start, int end,
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

		List<Publisher> list = (List<Publisher>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_PUBLISHER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PUBLISHER;

				if (pagination) {
					sql = sql.concat(PublisherModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Publisher>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Publisher>(list);
				}
				else {
					list = (List<Publisher>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the publishers from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Publisher publisher : findAll()) {
			remove(publisher);
		}
	}

	/**
	 * Returns the number of publishers.
	 *
	 * @return the number of publishers
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

				Query q = session.createQuery(_SQL_COUNT_PUBLISHER);

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
	 * Initializes the publisher persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.test.portlet.model.Publisher")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Publisher>> listenersList = new ArrayList<ModelListener<Publisher>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Publisher>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(PublisherImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_PUBLISHER = "SELECT publisher FROM Publisher publisher";
	private static final String _SQL_COUNT_PUBLISHER = "SELECT COUNT(publisher) FROM Publisher publisher";
	private static final String _ORDER_BY_ENTITY_ALIAS = "publisher.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Publisher exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(PublisherPersistenceImpl.class);
	private static Publisher _nullPublisher = new PublisherImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Publisher> toCacheModel() {
				return _nullPublisherCacheModel;
			}
		};

	private static CacheModel<Publisher> _nullPublisherCacheModel = new CacheModel<Publisher>() {
			@Override
			public Publisher toEntityModel() {
				return _nullPublisher;
			}
		};
}