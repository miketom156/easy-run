package com.job5156.common.util;

import java.net.URL;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.ImprovedNamingStrategy;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

public class HibernateCountUtil {
	// ThreadLocal是隔离多个线程的数据共享，不存在多个线程之间共享资源
	private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();
	private static final BasicDataSource basicDataSource = new BasicDataSource();
	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {
		try {
			// 采用默认的hibernate.cfg.xml来启动一个Configuration的实例
			URL configFileURL = HibernateActionUtil.class.getResource("/hibernate-count.cfg.xml");
			Configuration configuration = new Configuration().configure(configFileURL).setNamingStrategy(
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

    /**
     * Called by the garbage collector on an object when garbage collection
     * determines that there are no more references to the object.
     * A subclass overrides the {@code finalize} method to dispose of
     * system resources or to perform other cleanup.
     * <p/>
     * The general contract of {@code finalize} is that it is invoked
     * if and when the Java<font size="-2"><sup>TM</sup></font> virtual
     * machine has determined that there is no longer any
     * means by which this object can be accessed by any thread that has
     * not yet died, except as a result of an action taken by the
     * finalization of some other object or class which is ready to be
     * finalized. The {@code finalize} method may take any action, including
     * making this object available again to other threads; the usual purpose
     * of {@code finalize}, however, is to perform cleanup actions before
     * the object is irrevocably discarded. For example, the finalize method
     * for an object that represents an input/output connection might perform
     * explicit I/O transactions to break the connection before the object is
     * permanently discarded.
     * <p/>
     * The {@code finalize} method of class {@code Object} performs no
     * special action; it simply returns normally. Subclasses of
     * {@code Object} may override this definition.
     * <p/>
     * The Java programming language does not guarantee which thread will
     * invoke the {@code finalize} method for any given object. It is
     * guaranteed, however, that the thread that invokes finalize will not
     * be holding any user-visible synchronization locks when finalize is
     * invoked. If an uncaught exception is thrown by the finalize method,
     * the exception is ignored and finalization of that object terminates.
     * <p/>
     * After the {@code finalize} method has been invoked for an object, no
     * further action is taken until the Java virtual machine has again
     * determined that there is no longer any means by which this object can
     * be accessed by any thread that has not yet died, including possible
     * actions by other objects or classes which are ready to be finalized,
     * at which point the object may be discarded.
     * <p/>
     * The {@code finalize} method is never invoked more than once by a Java
     * virtual machine for any given object.
     * <p/>
     * Any exception thrown by the {@code finalize} method causes
     * the finalization of this object to be halted, but is otherwise
     * ignored.
     *
     * @throws Throwable the {@code Exception} raised by this method
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
