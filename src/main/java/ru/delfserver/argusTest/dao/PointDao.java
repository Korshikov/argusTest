package ru.delfserver.argusTest.dao;

import ru.delfserver.argusTest.entity.Point;

public interface PointDao {
  void create(Point point);
  void save(Point point);
  void delete(Point point);
  Point findById(Long pointId);
}
