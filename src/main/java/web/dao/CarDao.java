package web.dao;

import web.entity.Car;

import java.util.List;

public interface CarDao {

    void createTable();

    void dropTable();

    void saveCar(Car car);

    void deleteCarById(Long id);

    void updateCar(Car car);

    Car findCarById(Long id);

    List<Car> getAll();
}
