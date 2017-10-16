package ru.delfserver.argusTest.dao;

import org.hibernate.SessionFactory;
import ru.delfserver.argusTest.entity.Point;

public class PointDaoImpl extends AbstractDao<Long, Point> implements PointDao {

  PointDaoImpl(SessionFactory sessionFactory) {
    super(sessionFactory);
  }
}
