package com.devdaljeet.cardealershipsystem.controllers;

import java.text.DecimalFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.devdaljeet.cardealershipsystem.beans.Car;
import com.devdaljeet.cardealershipsystem.database.DatabaseAccess;

/**Represents a controller which has all URL mappings
 * @author Daljeet Singh
 * @version 1.0
 */
@Controller
public class HomeController {
	
	@Autowired
	private DatabaseAccess dataObj;
	
	/**Directs to home page of application
	 * @return A HTML page which acts as home page
	 */
	@GetMapping("/")
	public String goHome(Model model)
	{
		return "home.html";
	}
	
	/**Directs to add page through which user can add a car 
	 * @return A HTML page which acts as add car page
	 */
	@GetMapping("/list")
	public String goToAddCarPage(Model model)
	{
		model.addAttribute("car", new Car());
		return "addCar.html";
	}
	
	/**Adds the car to the database
	 * @return A HTML page which acts as add car page
	 */
	@GetMapping("/add")
	public String addCar(Model model, @ModelAttribute Car car)
	{
		dataObj.addCar(car);
		model.addAttribute("car",new Car());
		return "addCar.html";
	}
	
	/**Views/Returns all cars present in database
	 * @return A HTML page which acts as view car page
	 */
	@GetMapping("/view")
	public String viewCars(Model model)
	{
		model.addAttribute("carsFromD1",dataObj.getCars("Deals_on_Wheels"));
		model.addAttribute("carsFromD2",dataObj.getCars("Steals_and_Deals"));
		model.addAttribute("carsFromD3",dataObj.getCars("Rhyme_and_Crime"));
		return "viewCar.html";
	}
	
	/**Directs to edit car page for editing the properties of car
	 * @return A HTML page which acts as edit car page
	 */
	@GetMapping("/edit/{dealership}/{id}")
	public String goToEditPage(Model model, @PathVariable String dealership, @PathVariable int id){
		Car car = dataObj.getCarById(id, dealership);
		car.setNewDealership(dealership);
		model.addAttribute("car", car);
		return "editCar.html";
	}
	
	/**Saves the edited properties of a car to database
	 * @return (Redirects to) A HTML page which acts as view car page
	 */
	@GetMapping("/edit")
	public String editCar(Model model, @ModelAttribute Car car)
	{
		boolean checkTransfer = dataObj.editCar(car);
		if(checkTransfer == true)
		{
			dataObj.deleteCar(car.getId(), car.getDealership());
		}
		return "redirect:/view";
	}
	
	/**Delete the car from database
	 * @return (Redirects to) A HTML page which acts as view car page
	 */
	@GetMapping("/delete/{dealership}/{id}")
	public String deleteCar(Model model,  @PathVariable String dealership, @PathVariable int id){
		dataObj.deleteCar(id, dealership);
		return "redirect:/view";
	}
	
	/**Directs to search page for searching a car
	 * @return A HTML page which acts as search car page
	 */
	@GetMapping("/search")
	public String goToSearchPage()
	{
		return "searchCar.html";
	}
	
	/**Searches the car by ID and returns the result
	 * @return A HTML page which acts as view car page
	 */
	@GetMapping("/searchId")
	public String searchCarId(Model model, @RequestParam int id)
	{
		model.addAttribute("carsFromD1",dataObj.searchCarById(id,"Deals_on_Wheels"));
		model.addAttribute("carsFromD2",dataObj.searchCarById(id,"Steals_and_Deals"));
		model.addAttribute("carsFromD3",dataObj.searchCarById(id,"Rhyme_and_Crime"));
		return "viewCar.html";
	}
	
	/**Searches the car by make and returns the result
	 * @return A HTML page which acts as view car page
	 */
	@GetMapping("/searchMake")
	public String searchCarMake(Model model, @RequestParam String make)
	{
		model.addAttribute("carsFromD1",dataObj.searchCarByMake(make,"Deals_on_Wheels"));
		model.addAttribute("carsFromD2",dataObj.searchCarByMake(make,"Steals_and_Deals"));
		model.addAttribute("carsFromD3",dataObj.searchCarByMake(make,"Rhyme_and_Crime"));
		return "viewCar.html";
	}
	
	/**Searches the car by model and returns the result
	 * @return A HTML page which acts as view car page
	 */
	@GetMapping("/searchModel")
	public String searchCarModel(Model model, @RequestParam String modelForCar)
	{
		model.addAttribute("carsFromD1",dataObj.searchCarByModel(modelForCar,"Deals_on_Wheels"));
		model.addAttribute("carsFromD2",dataObj.searchCarByModel(modelForCar,"Steals_and_Deals"));
		model.addAttribute("carsFromD3",dataObj.searchCarByModel(modelForCar,"Rhyme_and_Crime"));
		return "viewCar.html";
	}
	
	/**Searches the car by price range (min-max) and returns the result
	 * @return A HTML page which acts as view car page
	 */
	@GetMapping("/searchPrice")
	public String searchCarPrice(Model model, @RequestParam double min, @RequestParam double max )
	{
		model.addAttribute("carsFromD1",dataObj.searchCarByPrice(min,max,"Deals_on_Wheels"));
		model.addAttribute("carsFromD2",dataObj.searchCarByPrice(min,max,"Steals_and_Deals"));
		model.addAttribute("carsFromD3",dataObj.searchCarByPrice(min,max,"Rhyme_and_Crime"));
		return "viewCar.html";
	}
	
	/**Return a receipt page of the car and delete the car from database
	 * @return A HTML page which acts as receipt page for car
	 */
	@GetMapping("/purchase/{dealership}/{id}")
	public String purchaseCar(Model model,  @PathVariable String dealership, @PathVariable int id)
	{
		Car car = dataObj.getCarById(id, dealership);
		DecimalFormat decimalFormat = new DecimalFormat("#########0.##");
		double taxes=Double.parseDouble(decimalFormat.format(car.getPrice()*0.13));
		car.setPrice(Double.parseDouble(decimalFormat.format(car.getPrice()+taxes)));
		model.addAttribute("car",car);
		model.addAttribute("taxes",taxes);
		dataObj.deleteCar(id, dealership);
		return "receipt.html";	
	}
}
