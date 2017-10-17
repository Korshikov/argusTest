package ru.delfserver.argusTest.dao;

import ru.delfserver.argusTest.entity.ConnectionUnit;

public interface ConnectionUnitDao {

  void create(ConnectionUnit connectionUnit);

  void save(ConnectionUnit connectionUnit);

  void delete(ConnectionUnit connectionUnit);

  ConnectionUnit findById(Long connectionUnitId);
}
