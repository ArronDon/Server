package com.innovation.identity.action;

import com.google.gson.Gson;
import com.innovation.identity.model.User;
import com.innovation.identity.service.UserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * UserAction
 * 
 * @author MrChen <br/>
 *         该类为struts2的Action,用户登陆注册修改信息等需要访问该Action 创建日期:2014-05-07 　*
 *         修改者，修改日期，修改内容。
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private User userInDatabase;
	private User userTemp = new User();// 客户端传来的username,password等会映射到该对象
	private String userJson;

	/**
	 * 用户登录检查
	 * <p>
	 * 验证用户登录
	 * </p>
	 * 
	 * @return loginSuccess(登陆成功)，logingFail(登录失败)
	 */
	public String login() {
		userInDatabase = userService.get(userTemp.getUsername());
		if (userInDatabase.equals(userTemp)) {
			Gson userGson = new Gson();
			userJson = userGson.toJson(userInDatabase);
			System.out.println(userJson);
		}
		return Action.SUCCESS;
	}

	/**
	 * 用户注册
	 * <p>
	 * 检查数据库中是否已经有人注册了该用户名
	 * </p>
	 * 
	 * @return registerSuccess(注册成功)，registerFail(注册失败)
	 */
	public String register() throws Exception {
		if (!userService.exists(userTemp.getUsername())) {
			userService.add(userTemp);
		}
		return SUCCESS;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public User getUserTemp() {
		return userTemp;
	}

	public void setUserTemp(User userTemp) {
		this.userTemp = userTemp;
	}

	public User getUserInDatabase() {
		return userInDatabase;
	}

	public void setUserInDatabase(User userInDatabase) {
		this.userInDatabase = userInDatabase;
	}

	@Override
	public User getModel() {
		return userTemp;
	}

	public String getUserJson() {
		return userJson;
	}

	public void setUserJson(String userJson) {
		this.userJson = userJson;
	}

}
