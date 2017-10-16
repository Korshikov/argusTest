package ru.delfserver.argusTest.bean;


import java.util.Collection;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import ru.delfserver.argusTest.dao.NodeDao;
import ru.delfserver.argusTest.dao.NodeDaoImpl;
import ru.delfserver.argusTest.entity.Node;
import ru.delfserver.argusTest.util.HibernateUtil;

@Named
@ViewScoped
public class NodeBean {
  Collection<Node> nodes;

  public Collection<Node> getAllNodes(){
    NodeDao nodeDao = new NodeDaoImpl(HibernateUtil.getSessionFactory());
    return nodeDao.getAllNodes();
  }
}
