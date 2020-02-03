package com.bankapp.model.persistance.user;

public interface UserDao {
	public User getUser(String username, String password);
	public void addUser(User user);
	
}
