package ru.delfserver.argusTest.dao;

import org.hibernate.SessionFactory;
import ru.delfserver.argusTest.entity.ConnectionUnit;

public class ConnectionUnitDaoImpl extends AbstractDao<Long,ConnectionUnit> implements ConnectionUnitDao {

  ConnectionUnitDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }

}
