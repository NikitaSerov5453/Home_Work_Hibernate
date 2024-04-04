package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import web.config.DBConfigHibernate;
import web.entity.Car;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarDaoHibernateImpl implements CarDao {


    @Override
    public void createTable() {
        String sql = """
                CREATE TABLE IF NOT EXISTS car (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR (40),
                power INTEGER,
                engine_type VARCHAR (40)
                )
                """;
        try (SessionFactory sessionFactory = DBConfigHibernate.getSession()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            tx.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void dropTable() {
        String sql = """
                DROP TABLE IF EXISTS car;
                """;
        try (SessionFactory sessionFactory = DBConfigHibernate.getSession()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.createSQLQuery(sql).executeUpdate();
            tx.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCar(Car car) {
        try (SessionFactory sessionFactory = DBConfigHibernate.getSession()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.save(car);
            tx.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarById(Long id) {
        String sql = """
                DELETE FROM Car c
                WHERE c.id = :id
                """;
        try (SessionFactory sessionFactory = DBConfigHibernate.getSession();) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.createQuery(sql)
                    .setParameter("id", id)
                    .executeUpdate();

            tx.commit();

            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void updateCar(Car car) {
        try (SessionFactory sessionFactory = DBConfigHibernate.getSession()) {
            Session session = sessionFactory.openSession();

            Transaction tx = session.beginTransaction();
            session.update(car);
            tx.commit();

            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<Car> getAll() {
        String hql = "FROM Car";

        SessionFactory sessionFactory = DBConfigHibernate.getSession();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        List<Car> cars = session.createQuery(hql)
                .getResultList();

        tx.commit();

        session.close();

        return cars;
    }

    @Override
    public Car findCarById(Long id) {
        String sql = """
                FROM Car c
                WHERE c.id = :id
                """;

        SessionFactory sessionFactory = DBConfigHibernate.getSession();
        Session session = sessionFactory.openSession();

        Transaction tx = session.beginTransaction();
        Car car = (Car) session.createQuery(sql)
                .setParameter("id", id)
                .getSingleResult();
        tx.commit();

        session.close();

        return car;
    }

}
