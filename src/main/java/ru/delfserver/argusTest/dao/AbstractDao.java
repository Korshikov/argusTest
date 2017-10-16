package ru.delfserver.argusTest.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
    return getSession().get(persistentClass, key);
  }

  public void create(T entity) {
    getSession().persist(entity);
  }

  public void save(T entity) {
    getSession().update(entity);
  }

  public void delete(T entity) {
    getSession().delete(entity);
  }

  protected CriteriaQuery<T> createEntitySelectCriteria() {
    CriteriaBuilder builder = getSession().getCriteriaBuilder();
    CriteriaQuery<T> criteria = builder.createQuery(persistentClass);
    Root<T> root = criteria.from(persistentClass);
    criteria.select(root);
    return criteria;
  }
}
