package web;

import web.dao.CarDaoHibernateImpl;
import web.dao.CarDaoJDBCImpl;
import web.enums.EngineType;
import web.service.CarService;
import web.service.CarServiceImpl;
import lombok.Builder;

public class Main {


    @Builder
    public static void main(String[] args) {

        CarService carServiceHibernate = new CarServiceImpl(new CarDaoHibernateImpl());
        CarService carServiceJDBC = new CarServiceImpl(new CarDaoJDBCImpl());

//        carServiceJDBC.dropTable();
//        carServiceJDBC.createTable();
//        carServiceJDBC.initialize();
//        carServiceJDBC.addNewCar("Audi", 500, EngineType.GASOLINE);
//        carServiceJDBC.printAllEntity();
//        System.out.println(carServiceJDBC.countingAllEntitiesInDatabase());
//        carServiceJDBC.findCarByEngineType("GASOLINE").forEach(System.out::println);
//        System.out.println(carServiceJDBC.findCarById(1L));
//        carServiceJDBC.updateCar(carServiceJDBC.findCarById(7L).setName("Audi Q7"));
//        carServiceJDBC.deleteCarById(2L);

//        carServiceHibernate.dropTable();
//        carServiceHibernate.createTable();
//        carServiceHibernate.initialize();
//        carServiceHibernate.addNewCar("Audi", 500, EngineType.GASOLINE);
//        carServiceHibernate.printAllEntity();
//        System.out.println(carServiceHibernate.countingAllEntitiesInDatabase());
//        carServiceHibernate.findCarByEngineType("GASOLINE").forEach(System.out::println);
//        System.out.println(carServiceHibernate.findCarById(1L));
//        carService.updateCar(carServiceHibernate.findCarById(7L).setName("Audi Q7"));
//        carServiceHibernate.deleteCarById(2L);
    }
}
