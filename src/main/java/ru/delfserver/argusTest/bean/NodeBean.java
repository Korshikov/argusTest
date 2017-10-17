package ru.delfserver.argusTest.bean;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import ru.delfserver.argusTest.dao.ConnectionUnitDao;
import ru.delfserver.argusTest.dao.ConnectionUnitDaoImpl;
import ru.delfserver.argusTest.dao.NodeDao;
import ru.delfserver.argusTest.dao.NodeDaoImpl;
import ru.delfserver.argusTest.dao.PointDao;
import ru.delfserver.argusTest.dao.PointDaoImpl;
import ru.delfserver.argusTest.entity.Node;
import ru.delfserver.argusTest.util.HibernateUtil;

@Named
@ApplicationScoped
public class NodeBean{

  private NodeDao nodeDao;
  private ConnectionUnitDao connectionUnitDao;
  private PointDao pointDao;

  public NodeBean() {
    this.nodeDao = new NodeDaoImpl(HibernateUtil.getSessionFactory());
    this.connectionUnitDao = new ConnectionUnitDaoImpl(HibernateUtil.getSessionFactory());
    this.pointDao = new PointDaoImpl(HibernateUtil.getSessionFactory());
  }

  public List<Node> getAllNodes() {
    Optional<List<Node>> nodes = nodeDao.getAllNodes();
    return nodes.orElseGet(Collections::emptyList);
  }

}
