package com.jtc.india;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class CHibernateUtil {
static SessionFactory factory = null;
static {
try {
Configuration configuration = new Configuration();
configuration = configuration.configure("hibernate.cfg.xml");
factory = configuration.buildSessionFactory();
} 
catch (Exception e) 
{
e.printStackTrace();
}
}
public static SessionFactory getSessionFactory()
{
return factory;
}
}
