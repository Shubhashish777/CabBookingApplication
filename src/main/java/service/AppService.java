package service;

import java.awt.Point;
import java.util.HashSet;

import model.Driver;
import model.Ride;
import model.User;
import repository.CoordinateMap;
import repository.DriverRepository;
import repository.UserRepository;

public class AppService {
	
	private CoordinateMap driverMap;
	private UserRepository userRepository;
	private DriverRepository driverRepository;
	
	public AppService(){
		
		this.driverMap= new CoordinateMap();
		this.userRepository= new UserRepository();
		this.driverRepository= new DriverRepository();
		
	}
	
	public void add_user(String user_detail)
	{
		
		String data[]= user_detail.split(",");
		
		String name=data[0].strip();
		String gender=data[1].strip();
		int age = Integer.parseInt(data[2].strip());
		userRepository.addUser(new User(name,gender,age));
		
	}
	
	public void show_user() {
		
		System.out.println(userRepository.getUserList());
	}
	

	
	public void update_userLocation(String userName, int x, int y) {
		
		Point currentLocation= new Point(x,y);
		for (User user:userRepository.getUserList() )
		{
			if (user.getName().equals(userName)) {
				
				user.setLocation(currentLocation);
			}
		}
		
	}
	
	public void addMap(Point currentLocation,Driver driver)
	{
		driver.setCurrentLocation(currentLocation);
		int x=(int) currentLocation.getX();
		int y= (int) currentLocation.getY();
		for (int i=-5;i<=5;i++) {
			for (int j=-5; j<=5; j++) {
				if((i*i+j*j)<=25) {
					currentLocation= new Point(x+i,y+j);
					driverMap.getDriverMap().putIfAbsent(currentLocation, new HashSet<Driver>());
					driverMap.getDriverMap().get(currentLocation).add(driver);			
				}
			}
		}
	}
	
	public void removeMap(Point currentLocation,Driver driver)
	{
		int x=(int) currentLocation.getX();
		int y= (int) currentLocation.getY();
		for (int i=-5;i<=5;i++) {
			for (int j=-5; j<=5; j++) {
				if((i*i+j*j)<=25) {
					currentLocation= new Point(x+i,y+j);
				    if (driverMap.getDriverMap().containsKey(currentLocation))
					driverMap.getDriverMap().get(currentLocation).remove(driver);		
				}
			}
		}
	}
	
	public void add_driver(String driver_detail,String vehicleDetails,  int x, int y)
	{
		
		String data[]= driver_detail.split(",");
		
		String name=data[0].strip();
		String gender=data[1].strip();
		int age = Integer.parseInt(data[2].strip());
		Point currentLocation= new Point(x,y);
		Driver driver=new Driver(name, gender,age,  vehicleDetails, currentLocation);
		driverRepository.addDriver(driver);
		driverMap.getDriverMap().putIfAbsent(currentLocation, new HashSet<Driver>());
		driverMap.getDriverMap().get(currentLocation).add(driver);
		
		addMap(currentLocation,driver);
     }
	public void change_driver_status(String driverName, Boolean bool)
	{
		for(Driver driver: driverRepository.getDriverList()) {
					
					if (driver.getDriverName().equals(driverName)) {
						
						driver.setAvailable(bool);
						
					}
				}
				
	}
	public void update_driverlocation(String driverName, int s, int t) {
		
		for(Driver driver: driverRepository.getDriverList()) {
			
			if (driver.getDriverName().equals(driverName)) {
				
				
				Point currentLocation= driver.getCurrentLocation();
				removeMap(currentLocation,driver);
				addMap(new Point(s,t),driver);
				
			}
		}
		
		
		
	}
	
		public void show_driver() {
				
			System.out.println(driverRepository.getDriverList());
			}
	
		public HashSet<Driver> find_ride(String userName, int x, int y, int s, int t) {
			Point currentLocation= new Point(x,y);
			Point destination= new Point(s,t);
			update_userLocation(userName, x,  y);
			for (User user:userRepository.getUserList() )
			{
				if (user.getName().equals(userName)) {
					
					user.setCurrentRide(new Ride(new Driver(), user,currentLocation, destination,1 ));
				}
			}
			//System.out.println(driverMap.getDriverMap().get(currentLocation));
			HashSet<Driver> driverList= new HashSet<Driver> ();
			for (Driver driver: driverMap.getDriverMap().getOrDefault(currentLocation, new HashSet<Driver> () ))
			{
				if (driver.isAvailable())driverList.add(driver);
			}
			
			if (driverList.size()==0)System.out.println("No Ride Found");
			else System.out.println(driverList);
			return driverList;
		}
		
		public void choose_ride(String userName, String driverName) {
			
			Ride ride = null; 
		
			for (User user:userRepository.getUserList() )
			{
				if (user.getName().equals(userName)) {
					
					ride=user.getCurrentRide();
				}
			}
			
			Point currentLocation=ride.getSource();
			for (Driver driver: driverMap.getDriverMap().get(currentLocation))
			{
				if (driver.getDriverName().equals(driverName)) {
					
					ride.setDriver(driver);
				
					System.out.println("Ride Started");
				}
				
			}
		
			
			
		}
		
		public void calculateBill(String userName)
		{
			Ride ride = null; 
			
			for (User user:userRepository.getUserList() )
			{
				if (user.getName().equals(userName)) {
					
					ride=user.getCurrentRide();
				}
			}
			
			Driver driver=ride.getDriver();
			double bill= ride.getBill();
			Point destination=ride.getDestination();
			
			driver.setDriverEarning(driver.getDriverEarning()+bill);
			update_driverlocation(driver.getDriverName(),destination.x,destination.y);
			update_userLocation(userName,destination.x,destination.y);
			
			System.out.println("Ride Ended Bill Amount: "+bill);
			
			
		}
		
		public void find_total_earning()
		{
			for(Driver driver: driverRepository.getDriverList()) {
				
				System.out.println(driver.getDriverName()+"\t earn \t"+ driver.getDriverEarning());
				
			}
			
		}
		
		
}
