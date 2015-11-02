package br.com.bruno.fiveware.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtils {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	
    private static SessionFactory buildSessionFactory() {
    
     Configuration configuration = new Configuration();
     configuration.configure();

     ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().
     applySettings(configuration.getProperties()).buildServiceRegistry();
     SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
  return sessionFactory;
    }
  
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
	
}
