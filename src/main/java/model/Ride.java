package model;

import java.awt.Point;

public class Ride {
	
	private Driver driver;
	private User user;
	private Point source;
	private Point destination;
	private double billPerKm;
	
	
	public Ride(Driver driver, User user, Point source, Point destination, double billPerKm) {
		super();
		this.driver = driver;
		this.user = user;
		this.source = source;
		this.destination = destination;
		this.billPerKm = billPerKm;
	}
	
	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Point getSource() {
		return source;
	}

	public void setSource(Point source) {
		this.source = source;
	}

	public Point getDestination() {
		return destination;
	}

	public void setDestination(Point destination) {
		this.destination = destination;
	}

	public double getBillPerKm() {
		return billPerKm;
	}

	public void setBillPerKm(double billPerKm) {
		this.billPerKm = billPerKm;
	}

	public double getBill()
	{
		int y2= (int) destination.getY();
		int y1= (int) source.getY();
		int x2= (int) destination.getX();
		int x1= (int) source.getX();
		return Math.ceil( Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1))*billPerKm);
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Ride other = (Ride) obj;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
	
	
	
	

}
