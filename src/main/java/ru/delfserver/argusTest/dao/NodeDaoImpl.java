package ru.delfserver.argusTest.dao;

import java.util.List;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.SessionFactory;
import ru.delfserver.argusTest.entity.Node;

public class NodeDaoImpl extends AbstractDao<Long, Node> implements NodeDao {

  public NodeDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }


  @Override
  public List<Node> getAllNodes() {
    CriteriaQuery<Node> criteriaSelectQuery = createEntitySelectCriteria();
    return getSession().createQuery(criteriaSelectQuery).getResultList();
  }
}
