package ua.nure.stepanenko.SummaryTask4.db.transaction;

import ua.nure.stepanenko.SummaryTask4.exception.db.DBException;
import ua.nure.stepanenko.SummaryTask4.model.entyty.Car;

import java.util.List;

/**
 * Created by eugen on 22.05.2017.
 */
public interface CarTransactionManager {

    boolean createCar(Car car) throws DBException;

    List<Car> getCars() throws DBException;

    List<Car> getCarsByClass(String clazz, String sort) throws DBException;

    List<Car> getCarsByMark(String mark, String sort) throws DBException;

    boolean updateCar(Car car) throws DBException;

    boolean setCarFieldThereIsByCarId(boolean thereIs, int carId) throws DBException;

    boolean deleteCarById(int id) throws DBException;
}
