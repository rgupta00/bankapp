package com.bankapp.model.service.user;

import com.bankapp.model.persistance.user.User;

public interface UserService {
	public User getUser(String username, String password);
	public void addUser(User user);
}
