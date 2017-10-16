package ru.delfserver.argusTest.dao;

import java.util.List;
import ru.delfserver.argusTest.entity.Node;

public interface NodeDao {

  void create(Node node);

  void save(Node node);

  void delete(Node node);

  Node findById(Long nodeId);

  List<Node> getAllNodes();
}
