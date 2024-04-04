package web.service;

import web.dao.CarDao;
import web.entity.Car;

import web.enums.EngineType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {


    private final CarDao carDao;
    private boolean flag;

    @Override
    public void createTable() {
        carDao.createTable();
    }

    @Override
    public void dropTable() {
        carDao.dropTable();
    }

    @Override
    public void saveCar(Car car) {
        carDao.saveCar(car);
    }

    @Override
    public void deleteCarById(Long id) {
        carDao.deleteCarById(id);
    }

    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }

    @Override
    public Car findCarById(Long id) {
        return carDao.findCarById(id);
    }

    @Override
    public List<Car> getAll() {
        return carDao.getAll();
    }

    private void initializingTable() {
        Car porsche = Car.builder()
                .name("Porsche 911 Turbo S, 2023")
                .power(650)
                .engineType(EngineType.GASOLINE)
                .build();
        Car tesla = Car.builder()
                .name("Tesla Roadster")
                .power(1000)
                .engineType(EngineType.ELECTRIC)
                .build();
        Car ram = Car.builder()
                .name("Ram 1500 Crew Cab")
                .power(260)
                .engineType(EngineType.DIESEL)
                .build();
        Car lada = Car.builder()
                .name("Lada Priora")
                .power(98)
                .engineType(EngineType.GASOLINE)
                .build();
        Car chery = Car.builder()
                .name("Chery TIGGO 8 PRO")
                .power(235)
                .engineType(EngineType.HYBRID)
                .build();
        Car nissan = Car.builder()
                .name("Nissan GT-R")
                .power(485)
                .engineType(EngineType.GASOLINE)
                .build();
        carDao.saveCar(porsche);
        carDao.saveCar(tesla);
        carDao.saveCar(ram);
        carDao.saveCar(lada);
        carDao.saveCar(chery);
        carDao.saveCar(nissan);
    }

    @Override
    public void initialize() {
        if (!flag) {
            initializingTable();
            flag = true;
        }
    }

    @Override
    public void printAllEntity() {
        carDao.getAll().forEach(System.out::println);
    }

    @Override
    public Long countingAllEntitiesInDatabase() {
        return (long) carDao.getAll().size();
    }

    @Override
    public List<Car> findCarByEngineType(String engineType) {
        List<Car> cars = new ArrayList<>();

        for (Car car : carDao.getAll()) {
            if (car.getEngineType() == EngineType.valueOf(engineType)) {
                cars.add(car);
            }
        }
        return cars;
    }

    @Override
    public void addNewCar(String name, Integer power, EngineType engineType) {
        Car car = Car.builder()
                .name(name)
                .power(power)
                .engineType(engineType)
                .build();
        carDao.saveCar(car);
    }

}
