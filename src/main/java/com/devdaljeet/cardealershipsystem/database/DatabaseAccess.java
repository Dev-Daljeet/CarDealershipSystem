package com.devdaljeet.cardealershipsystem.database;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.devdaljeet.cardealershipsystem.beans.Car;

/**Represents the access class which manipulates the database
 * @author Dajeet Singh
 * @version 1.0
 */
@Repository
public class DatabaseAccess {
	
	@Autowired
	NamedParameterJdbcTemplate jdbc;
	
	/**Adds a car to database
	 * @param car An instance of class Car
	 */
	public void addCar(Car car)
	{
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		//query is not vulnerable to sql injection because all dealership inputs are taken from valid array
		String query = String.format("INSERT INTO %s (make, model, colour, price, vin) VALUES (:make, :model, :colour, :price, :vin)",car.getDealership());
		parameters.addValue("make",car.getMake());
		parameters.addValue("model",car.getModel());
		parameters.addValue("colour",car.getColour());
		parameters.addValue("price",car.getPrice());
		parameters.addValue("vin",car.getVin());
		jdbc.update(query, parameters);
	}
	
	/**Returns/gets all cars from database
	 * @param dealership A string which represents the name of car dealership
	 * @return cars An array list of all cars
	 */
	public ArrayList<Car> getCars(String dealership){
		ArrayList<Car> cars = new ArrayList<>();
		String query = String.format("SELECT * FROM %s", dealership);
		List<Map<String, Object>> rows = jdbc.queryForList(query, new HashMap<String,Object>());
		
		for(Map<String, Object> row: rows) {
			Car car= new Car();
			car.setId((Integer)(row.get("id")));
			car.setMake((String)(row.get("make")));
			car.setModel((String)(row.get("model")));
			car.setColour((String)(row.get("colour")));
			car.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			car.setVin((String)(row.get("vin")));
			car.setDealership((String)dealership);
			cars.add(car);
		}
		return cars;		
	}
	
	/**Returns/gets a car of specific ID from database
	 * @param id An integer which represents the ID of a car in dealership
	 * @param dealership A string which represents the name of car dealership
	 * @return car An instance of class Car
	 */
	public Car getCarById(int id, String dealership) {
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<>();
		String query = String.format("SELECT * FROM %s WHERE id=:id", dealership);
		parameters.addValue("id",id);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		
		for(Map<String, Object> row: rows) {
			Car car= new Car();
			car.setId((Integer)(row.get("id")));
			car.setMake((String)(row.get("make")));
			car.setModel((String)(row.get("model")));
			car.setColour((String)(row.get("colour")));
			car.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			car.setVin((String)(row.get("vin")));
			car.setDealership((String)dealership);
			cars.add(car);
		}
		if(cars.size()>0) 
		{
			return cars.get(0);
		}
		else 
		{
			return null;
		}
	}
	
	/**Edits/Updates a car in database
	 * @param car An instance of class Car
	 * @return A boolean value which checks if car is transfered to new dealership or not
	 */
	public boolean editCar(Car car)
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		String query;
		if(car.getDealership().equals(car.getNewDealership()))
		{
			query = String.format("UPDATE %s SET make=:make,model=:model,colour=:colour,price=:price,vin=:vin where id=:id",car.getDealership());
			parameters.addValue("make",car.getMake());
			parameters.addValue("model",car.getModel());
			parameters.addValue("colour",car.getColour());
			parameters.addValue("price",car.getPrice());
			parameters.addValue("vin",car.getVin());
			parameters.addValue("id",car.getId());
			jdbc.update(query, parameters);
			return false;
		}
		else 
		{
			query = String.format("INSERT INTO %s (make, model, colour, price, vin) VALUES (:make, :model, :colour, :price, :vin)",car.getNewDealership());
			parameters.addValue("make",car.getMake());
			parameters.addValue("model",car.getModel());
			parameters.addValue("colour",car.getColour());
			parameters.addValue("price",car.getPrice());
			parameters.addValue("vin",car.getVin());
			parameters.addValue("id",car.getId());
			jdbc.update(query, parameters);
			return true;
		}	
	}
	
	/**Delete a car from database
	 * @param id An integer which represents the ID of a car in dealership
	 * @param dealership A string which represents the name of car dealership
	 */
	public void deleteCar(int id, String dealership)
	{
		MapSqlParameterSource  parameters = new MapSqlParameterSource();
		String query = String.format("DELETE FROM %s WHERE id=:id",dealership);
		parameters.addValue("id",id);
		jdbc.update(query, parameters);
	}

	/**Returns/gets cars of specific ID from database
	 * @param id An integer which represents the ID of a car in dealership
	 * @param dealership A string which represents the name of car dealership
	 * @return cars An array list of cars
	 */
	public ArrayList<Car> searchCarById(int id, String dealership) 
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<>();
		String query = String.format("SELECT * FROM %s WHERE id=:id", dealership);
		parameters.addValue("id",id);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) 
		{
			Car car= new Car();
			car.setId((Integer)(row.get("id")));
			car.setMake((String)(row.get("make")));
			car.setModel((String)(row.get("model")));
			car.setColour((String)(row.get("colour")));
			car.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			car.setVin((String)(row.get("vin")));
			car.setDealership((String)dealership);
			cars.add(car);
		}
		return cars;
	}
	
	/**Returns/gets cars of specific make from database
	 * @param make A String which represents the make of a car in dealership
	 * @param dealership A string which represents the name of car dealership
	 * @return cars An array list of cars
	 */
	public ArrayList<Car> searchCarByMake(String make, String dealership) 
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<>();
		String query = String.format("SELECT * FROM %s WHERE make=:make", dealership);
		parameters.addValue("make",make);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) 
		{
			Car car= new Car();
			car.setId((Integer)(row.get("id")));
			car.setMake((String)(row.get("make")));
			car.setModel((String)(row.get("model")));
			car.setColour((String)(row.get("colour")));
			car.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			car.setVin((String)(row.get("vin")));
			car.setDealership((String)dealership);
			cars.add(car);
		}
		return cars;
	}
	
	/**Returns/gets cars of specific model from database
	 * @param modelForCar A String which represents the model of a car in dealership
	 * @param dealership A string which represents the name of car dealership
	 * @return cars An array list of cars
	 */
	public ArrayList<Car> searchCarByModel(String modelForCar, String dealership) 
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<>();
		String query = String.format("SELECT * FROM %s WHERE model=:model", dealership);
		parameters.addValue("model",modelForCar);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) 
		{
			Car car= new Car();
			car.setId((Integer)(row.get("id")));
			car.setMake((String)(row.get("make")));
			car.setModel((String)(row.get("model")));
			car.setColour((String)(row.get("colour")));
			car.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			car.setVin((String)(row.get("vin")));
			car.setDealership((String)dealership);
			cars.add(car);
		}
		return cars;
	}
	
	/**Returns/gets cars of specific price from database
	 * @param min An double which represents the minimum price of a car
	 * @param max An double which represents the maximum price of a car
	 * @param dealership A string which represents the name of car dealership
	 * @return cars An array list of cars
	 */
	public ArrayList<Car> searchCarByPrice(double min, double max, String dealership) 
	{
		MapSqlParameterSource parameters = new MapSqlParameterSource();
		ArrayList<Car> cars = new ArrayList<>();
		String query = String.format("SELECT * FROM %s WHERE price BETWEEN :min AND :max", dealership);
		parameters.addValue("min",min);
		parameters.addValue("max",max);
		List<Map<String, Object>> rows = jdbc.queryForList(query, parameters);
		for(Map<String, Object> row: rows) 
		{
			Car car= new Car();
			car.setId((Integer)(row.get("id")));
			car.setMake((String)(row.get("make")));
			car.setModel((String)(row.get("model")));
			car.setColour((String)(row.get("colour")));
			car.setPrice(((BigDecimal)(row.get("price"))).doubleValue());
			car.setVin((String)(row.get("vin")));
			car.setDealership((String)dealership);
			cars.add(car);
		}
		return cars;
	}
	
		
}
