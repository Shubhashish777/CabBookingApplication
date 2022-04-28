package repository;

import java.util.ArrayList;
import java.util.List;

import model.Driver;


public class DriverRepository {
	
	List<Driver> driverList;

	public DriverRepository() {
		
		this.driverList = new ArrayList<Driver>();
	}
	
	

	public DriverRepository(List<Driver> driverList) {
		
		this.driverList = driverList;
	}



	public List<Driver> getDriverList() {
		return driverList;
	}

	public void setDriverList(List<Driver> driverList) {
		this.driverList = driverList;
	}
	
	public void addDriver(Driver driver)
	{
		this.driverList.add(driver);
	}
	
	public void removeDriver(Driver driver)
	{
		this.driverList.remove(driver);
		
	}
	
	
}
