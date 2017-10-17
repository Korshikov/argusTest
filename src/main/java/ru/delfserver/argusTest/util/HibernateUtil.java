package ru.delfserver.argusTest.util;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.transaction.TransactionManager;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import ru.delfserver.argusTest.entity.ConnectionUnit;
import ru.delfserver.argusTest.entity.Node;
import ru.delfserver.argusTest.entity.Point;

public class HibernateUtil {

  private static SessionFactory sessionFactory;

  static {
    Configuration configuration = new  Configuration().configure();
    configuration.addAnnotatedClass(Node.class);
    configuration.addAnnotatedClass(ConnectionUnit.class);
    configuration.addAnnotatedClass(Point.class);
    StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
        .applySettings(configuration.getProperties());
    sessionFactory = configuration.buildSessionFactory(builder.build());
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
}