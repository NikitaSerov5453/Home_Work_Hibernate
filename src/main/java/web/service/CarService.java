package web.service;

import web.entity.Car;
import web.enums.EngineType;

import java.util.List;

public interface CarService {

    void createTable();

    void dropTable();

    void saveCar(Car car);

    void deleteCarById(Long id);

    void updateCar(Car car);

    void initialize();

    void printAllEntity();

    void addNewCar(String name, Integer power, EngineType engineType);

    Car findCarById(Long id);

    List<Car> getAll();

    List<Car> findCarByEngineType(String engineType);

    Long countingAllEntitiesInDatabase();


}
