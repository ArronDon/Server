package com.innovation.identity.service.impl;


import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.innovation.identity.dao.UserDAO;
import com.innovation.identity.model.User;
import com.innovation.identity.service.UserService;
@Component("userService")
public class UserServiceImpl implements UserService{
	private UserDAO userDAO;
	/**
	 * 添加用户
	 */
	@Override
	public void add(User user) {
		userDAO.add(user);
	}
	/**
	 * 更新用户
	 */
	@Override
	public void update(User user) {
		userDAO.update(user);
	}
	/**
	 * 获得用户信息
	 */
	@Override
	public User get(String username) {
		return userDAO.get(username);
	}
	/**
	 * 判断用户是否存在
	 */
	@Override
	public boolean exists(String username) {
		return userDAO.exists(username);
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	@Resource(name="userDAO")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

}
