package repository;


import java.awt.Point;
import java.util.HashMap;
import java.util.HashSet;

import model.Driver;

public class CoordinateMap {
	
	HashMap<Point,HashSet<Driver>> driverMap;

	public CoordinateMap() {
		
		driverMap = new HashMap<Point,HashSet<Driver>>();
	}

	public HashMap<Point, HashSet<Driver>> getDriverMap() {
		return driverMap;
	}

	public void setDriverMap(HashMap<Point, HashSet<Driver>> driverMap) {
		this.driverMap = driverMap;
	}

	@Override
	public String toString() {
		return "CoordinateMap \n [driverMap=\n" + driverMap + "";
	}
	
	
	
	

}
