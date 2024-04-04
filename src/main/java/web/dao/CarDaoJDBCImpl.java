package web.dao;

import web.config.DBConfigJDBC;
import web.entity.Car;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoJDBCImpl implements CarDao{

    @Override
    public void createTable() {

        Connection connection = DBConfigJDBC.getConnection();

        String sql = """
                CREATE TABLE IF NOT EXISTS car (
                id BIGSERIAL PRIMARY KEY,
                name VARCHAR (40),
                power INTEGER,
                engine_type VARCHAR (40)
                )
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void dropTable() {
        Connection connection = DBConfigJDBC.getConnection();
        String sql = """
                DROP TABLE IF EXISTS car;
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    @Override
    public void saveCar(Car car) {

        Connection connection = DBConfigJDBC.getConnection();

        String sql = """
        INSERT INTO car(name, power, engine_type)
        VALUES(?, ?, ?)
        """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getPower());
            preparedStatement.setString(3, car.getEngineType().toString());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCarById(Long id) {

        Connection connection = DBConfigJDBC.getConnection();

        String sql = """
                DELETE FROM Car WHERE id = ?
                """;

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCar(Car car) {
        Connection connection = DBConfigJDBC.getConnection();

        String sql = "UPDATE Car SET name=?, power=?, engine_type=? WHERE  id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, car.getName());
            preparedStatement.setInt(2, car.getPower());
            preparedStatement.setString(3, car.getEngineType().toString());
            preparedStatement.setLong(4, car.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Car findCarById(Long id) {
        Connection connection = DBConfigJDBC.getConnection();

        String sql = String.format("SELECT * FROM Car WHERE id = %d", id);

        Car car = new Car();

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            resultSet.next();
            car.setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setPower(resultSet.getInt("power"))
                    .setEngineType(resultSet.getString("engine_type"));

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }

    @Override
    public List<Car> getAll() {
        Connection connection = DBConfigJDBC.getConnection();

        List<Car> carList = new ArrayList<>();

        String sql = "SELECT * FROM Car";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getLong("id"))
                        .setName(resultSet.getString("name"))
                        .setPower(resultSet.getInt("power"))
                        .setEngineType(resultSet.getString("engine_type"));

                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;
    }
}
