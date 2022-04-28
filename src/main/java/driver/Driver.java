package driver;

import service.AppService;

public class Driver {

	public static void main(String[] args) {
		
		//Onboard Users to the Application
		
		AppService appservice = new AppService();
		appservice.add_user("Abhishek, M, 23");
		appservice.update_userLocation("Abhishek",0,0);
		appservice.add_user("Rahul , M, 29");
		appservice.update_userLocation("Rahul",10,0);
		appservice.add_user("Nandini, F, 22") ;
		appservice.update_userLocation("Nandini",15,6);
		//appservice.show_user();
		//Onboard Drivers to the Cab Booking Application
		
		
		appservice.add_driver("Driver1, M, 22","Swift, KA-01-12345",10,1);
		appservice.add_driver("Driver2, M, 29","Swift, KA-01-12345",11,10);
		appservice.add_driver("Driver3, M, 24","Swift, KA-01-12345",5,3);
		//appservice.show_driver();
		
		// User attempt to get a ride
		
		appservice.find_ride("Abhishek",0,0,20,1);
		appservice.find_ride("Rahul" ,10,0,15,3);
		appservice.choose_ride("Rahul","Driver1");
		appservice.calculateBill("Rahul");
		//appservice.show_driver();
		appservice.change_driver_status("Driver1", false);
		appservice.find_ride("Nandini",15,6,20,4);
		//Show earning by Driver
		//appservice.show_driver();
		appservice.find_total_earning();
		
		

	}

}
