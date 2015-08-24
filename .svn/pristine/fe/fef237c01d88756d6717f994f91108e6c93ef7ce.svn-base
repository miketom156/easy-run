package com.job5156.common.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class HibernateUtil {
	// ThreadLocal是隔离多个线程的数据共享，不存在多个线程之间共享资源
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static final BasicDataSource basicDataSource = new BasicDataSource();
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;
	
	static {
		try {
			// 采用默认的hibernate.cfg.xml来启动一个Configuration的实例
			Configuration configuration = new Configuration().configure().setNamingStrategy(
					ImprovedNamingStrategy.INSTANCE);
			// 由Configuration的实例来创建一个SessionFactory实例
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			initDataSource(configuration);
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

    private static void initDataSource(Configuration configuration){
        basicDataSource.setDriverClassName(configuration.getProperty("connection.driver_class"));
        basicDataSource.setUrl(configuration.getProperty("connection.url"));
        basicDataSource.setUsername(configuration.getProperty("connection.username"));
        basicDataSource.setPassword(configuration.getProperty("connection.password"));
    }
    
	/**
	 * 获取当前线程绑定的session
	 * 
	 * @return
	 */
	public static Session currentSession() {
		Session session = (Session) threadLocal.get();
		// 如果该线程还没有Session,则创建一个新的Session
		if (session == null) {
			session = sessionFactory.openSession();
			// session.setFlushMode(FlushMode.NEVER);
			session.setFlushMode(FlushMode.MANUAL);
			threadLocal.set(session);
		}
		return session;
	}

	/**
	 * 关闭当前线程绑定的session
	 */
	public static void closeSession() {
		Session session = (Session) threadLocal.get();
		if (session != null) {
			session.close();
		}
		threadLocal.set(null);

        if(basicDataSource!=null && !basicDataSource.isClosed()){
            try {
                basicDataSource.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	}

	public static SessionFactory getSessionFactory() {
		if (sessionFactory != null) {
			return sessionFactory;
		} else {
			return null;
		}
	}

	public static JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(basicDataSource);
	}
}
