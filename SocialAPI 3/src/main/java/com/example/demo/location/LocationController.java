package com.example.demo.location;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LocationController {
	
	
	@Autowired  
	public LocationService locationService;
	
	@RequestMapping(value="/locations")//GET
	public List<Location>getAllLocations(){
		return locationService.getAllLocations();
		
	}
	
	@RequestMapping(value="/locations/{id}") //GET
	public Location getLocation(@PathVariable String id){
		return locationService.getLocation(id);
		
	}
	
	@RequestMapping(value="/locations", method=RequestMethod.POST)
	public void addLocation(@RequestBody Location location) {
		locationService.addLocation(location);
		
	}
	
	@RequestMapping(value="/locations/{id}", method=RequestMethod.PUT)
	public void addLocation(@PathVariable String id, @RequestBody Location location) {
		locationService.updateLocation(id,location);
		
	}
	
	@RequestMapping(value="/locations/{id}", method=RequestMethod.DELETE)
	public void deleteLocation(@PathVariable String id) {
		locationService.deleteLocation(id);
		
	}
	

}
