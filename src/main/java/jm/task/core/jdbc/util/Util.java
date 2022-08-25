package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    private static final Environment environment = null;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                Properties settings = new Properties();
                settings.put(environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(environment.URL, "jdbc:mysql://localhost:3306/pp1.1.3?useSSL=false");
                settings.put(environment.USER, "root");
                settings.put(environment.PASS, "root23");
                settings.put(environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(environment.SHOW_SQL, "false");
                settings.put(environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(environment.HBM2DDL_AUTO, "create-drop");

                configuration.setProperties(settings);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
