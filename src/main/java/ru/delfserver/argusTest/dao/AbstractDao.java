package ru.delfserver.argusTest.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.delfserver.argusTest.entity.Node;

/***
 * Abstract dao class
 * @param <PK> Primary key data type
 * @param <T> Entity for dao
 */
@Transactional
abstract class AbstractDao<PK extends Serializable, T> {

  private final Class<T> persistentClass;

  @SuppressWarnings("unchecked")
  AbstractDao(SessionFactory sessionFactory) {
    this.persistentClass = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
        .getActualTypeArguments()[1];
    this.sessionFactory = sessionFactory;
  }

  private final SessionFactory sessionFactory;

  protected Session getSession() {
    return sessionFactory.getCurrentSession();
  }

  @SuppressWarnings("unchecked")
  public T findById(PK key) {
    Transaction transaction = null;
    T result = null;
    try {
      transaction = getSession().beginTransaction();
      result = getSession().get(persistentClass, key);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }

    return result;
  }

  public void create(T entity) {
    Transaction transaction = null;
    try {
      transaction = getSession().beginTransaction();
      getSession().persist(entity);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
  }

  public void save(T entity) {
    Transaction transaction = null;
    try {
      transaction = getSession().beginTransaction();
      getSession().update(entity);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
  }

  public void delete(T entity) {
    Transaction transaction = null;
    try {
      transaction = getSession().beginTransaction();
      getSession().delete(entity);
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
  }

  protected CriteriaQuery<T> createEntitySelectCriteria() {
    CriteriaBuilder builder = getSession().getCriteriaBuilder();
    CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
    Root<T> root = criteria.from(persistentClass);
    criteria.select(root);
    return criteria;
  }
}
