package com.innovation.identity.dao.impl;

import javax.annotation.Resource;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Component;
import com.innovation.identity.dao.UserDAO;
import com.innovation.identity.model.User;

@Component("userDAO")
public class UserDAOImpl implements UserDAO{
	private HibernateTemplate hibernateTemplate;
	/**
	 * 添加用户
	 */
	@Override
	public void add(User user) {
		hibernateTemplate.save(user);
	}
	/**
	 * 更新用户
	 */
	@Override
	public void update(User user) {
		hibernateTemplate.update(user);
	}
	/**
	 * 获得用户
	 */
	@Override
	public User get(final String username) {
		return (User)hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) {
            	User user=(User)session.createQuery("from User u where u.username=:username").setString("username", username).uniqueResult();
            	System.out.println("time="+user.getCellphone());
                return user;
            }
        });
	}
	/**
	 * 更具用户名判断用户是否已经存在
	 */
	@Override
	public boolean exists(final String username) {
		User user=(User)hibernateTemplate.execute(new HibernateCallback() {
            public Object doInHibernate(Session session) {
                return (User)session.createQuery("from User u where u.username=:username").setString("username", username).uniqueResult();
            }
        });
		if(user!=null){
			return true;
		}
		else {
			return false;
		}
	}
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	@Resource(name="hibernateTemplate")
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
}
