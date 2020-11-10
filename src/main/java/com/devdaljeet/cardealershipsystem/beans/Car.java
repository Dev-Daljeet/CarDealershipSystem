package com.devdaljeet.cardealershipsystem.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

/** Represents a car which is located in a car dealership
 * @author Daljeet Singh
 * @version 1.0
 */
public class Car implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	private String make;
	private String model;
	private String colour;
	private double price;
	private String vin;
	private String dealership;
	
	//To use for moving car from one dealership to another
	private String newDealership;
	
	//Dealership names
	private String[] dealerships = {"Deals_on_Wheels","Steals_and_Deals","Rhyme_and_Crime"};
}