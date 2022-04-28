/**
 * 
 */
package model;
import java.awt.Point;
/**
 * @author Shubhashish PC
 *
 */
public class User {
	
	private String name;
	private String gender;
	private int age;
	private Point location;
	private Ride currentRide;
	
	public Ride getCurrentRide() {
		return currentRide;
	}

	public void setCurrentRide(Ride currentRide) {
		this.currentRide = currentRide;
	}

	public User(String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.location = new Point(0,0);
	}
	
	public User(String name, String gender, int age, Point location) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Point getLocation() {
		return location;
	}

	public void setLocation(Point location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		User other = (User) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", gender=" + gender + ", age=" + age + ", location=" + location + "]";
	}
	
	
	
	
	

}
