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
 *         ����Ϊstruts2��Action,�û���½ע���޸���Ϣ����Ҫ���ʸ�Action ��������:2014-05-07 ��*
 *         �޸��ߣ��޸����ڣ��޸����ݡ�
 */
public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	private UserService userService;
	private User userInDatabase;
	private User userTemp = new User();// �ͻ��˴�����username,password�Ȼ�ӳ�䵽�ö���
	private String userJson;

	/**
	 * �û���¼���
	 * <p>
	 * ��֤�û���¼
	 * </p>
	 * 
	 * @return loginSuccess(��½�ɹ�)��logingFail(��¼ʧ��)
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
	 * �û�ע��
	 * <p>
	 * ������ݿ����Ƿ��Ѿ�����ע���˸��û���
	 * </p>
	 * 
	 * @return registerSuccess(ע��ɹ�)��registerFail(ע��ʧ��)
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
