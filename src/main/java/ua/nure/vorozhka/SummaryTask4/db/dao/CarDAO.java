package ua.nure.vorozhka.SummaryTask4.db.dao;

import ua.nure.vorozhka.SummaryTask4.model.constant.Class;
import ua.nure.vorozhka.SummaryTask4.model.constant.Mark;
import ua.nure.vorozhka.SummaryTask4.model.entyty.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Stanislav on 21.05.2017.
 */
public abstract class CarDAO {

    public abstract boolean createCar(Connection connection, Car car) throws SQLException;

    public abstract List<Car> getCars(Connection connection) throws SQLException;

    public abstract List<Car> getCarsByClass(Connection connection, String clazz, String sort) throws SQLException;

    public abstract List<Car> getCarsByMark(Connection connection, String mark, String sort) throws SQLException;

    public abstract boolean updateCar(Connection connection, Car car) throws SQLException;

    public abstract boolean setCarFieldThereIsByCarId(
            Connection connection, boolean thereIs, int carId) throws SQLException;

    public abstract boolean deleteCarById(Connection connection, int id) throws SQLException;

    protected Car getCar(ResultSet resultSet) throws SQLException {
        Car car = new Car();
        car.setId(resultSet.getInt("id"));
        car.setMark(Mark.getMarkById(resultSet.getInt("mark_id")));
        car.setClazz(Class.getClassById(resultSet.getInt("class_id")));
        car.setName(resultSet.getString("name"));
        car.setCost(resultSet.getInt("cost"));
        car.setThereIs(resultSet.getBoolean("there_is"));
        return car;
    }
}
