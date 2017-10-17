package ru.delfserver.argusTest.dao;

import java.util.List;
import java.util.Optional;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ru.delfserver.argusTest.entity.Node;

public class NodeDaoImpl extends AbstractDao<Long, Node> implements NodeDao {

  public NodeDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

  @Transactional
  @Override
  public Optional<List<Node>> getAllNodes() {
    Transaction transaction = null;
    List<Node> result = null;
    try {
      transaction = getSession().beginTransaction();
      CriteriaQuery<Node> criteriaSelectQuery = createEntitySelectCriteria();
      result = getSession().createQuery(criteriaSelectQuery).getResultList();
      transaction.commit();
    } catch (HibernateException e) {
      if (transaction != null) {
        transaction.rollback();
      }
    }
    return Optional.ofNullable(result);
  }

}
