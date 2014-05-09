package com.innovation.identity.dao;



import com.innovation.identity.model.User;

public interface UserDAO{
	public void add(User user);
	public void update(User user);
	public boolean exists(String username);
	public User get(String username);
}