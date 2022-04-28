/**
 * 
 */
package model;

import java.awt.Point;

/**
 * @author Shubhashish PC
 *
 */
public class Driver {
	
	private String driverName;
	private String driverGender;
	private int driverAge;
	private String vehicleDetais;
	private Point currentLocation;
	private double driverEarning;
	private boolean available;
	
	public Driver(String driverName, String driverGender, int driverAge, String vehicleDetais, Point currentLocation) {
		super();
		this.driverName = driverName;
		this.driverGender = driverGender;
		this.driverAge = driverAge;
		this.vehicleDetais = vehicleDetais;
		this.currentLocation = currentLocation;
		this.driverEarning=0;
		this.available=true;
	}

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverGender() {
		return driverGender;
	}

	public void setDriverGender(String driverGender) {
		this.driverGender = driverGender;
	}

	public int getDriverAge() {
		return driverAge;
	}

	public void setDriverAge(int driverAge) {
		this.driverAge = driverAge;
	}

	public String getVehicleDetais() {
		return vehicleDetais;
	}

	public void setVehicleDetais(String vehicleDetais) {
		this.vehicleDetais = vehicleDetais;
	}

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}
	
	

	public double getDriverEarning() {
		return driverEarning;
	}

	public void setDriverEarning(double driverEarning) {
		this.driverEarning = driverEarning;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((driverName == null) ? 0 : driverName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Driver other = (Driver) obj;
		if (driverName == null) {
			if (other.driverName != null)
				return false;
		} else if (!driverName.equals(other.driverName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n" + driverName + " "+" " +", available=" + available + "\n";
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	
	
	
	
	

}
