package ru.delfserver.argusTest.dao;

import java.util.List;
import java.util.Optional;
import ru.delfserver.argusTest.entity.Node;

public interface NodeDao {

  void create(Node node);

  void save(Node node);

  void delete(Node node);

  Node findById(Long nodeId);

  Optional<List<Node>> getAllNodes();
}
