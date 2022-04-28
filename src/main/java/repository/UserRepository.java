package repository;

import java.util.ArrayList;
import java.util.List;

import model.User;
public class UserRepository {
	
	List<User> userList;
	
	public UserRepository() {
		
		this.userList = new ArrayList<User>();
	}

	public UserRepository(List<User> userList) {
		
		this.userList = userList;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public void addUser(User user)
	{
		this.userList.add(user);
	}
	
	public void removeUser(User user)
	{
		this.userList.remove(user);
		
	}
	

}
