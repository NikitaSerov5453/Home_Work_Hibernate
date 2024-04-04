package web.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import web.entity.Car;


public class DBConfigHibernate {

    private static final String DB_DRIVER = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "";

    public static SessionFactory getSession() {
        return new Configuration()
                .setProperty("hibernate.connection.url", DB_URL)
                .setProperty("hibernate.connection.driver_class", DB_DRIVER)
                .setProperty("hibernate.connection.username", DB_USERNAME)
                .setProperty("hibernate.connection.password", DB_PASSWORD)
                .setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect")
                .setProperty("hibernate.show_sql", "true")
                .addAnnotatedClass(Car.class)
                .buildSessionFactory();
    }
}
