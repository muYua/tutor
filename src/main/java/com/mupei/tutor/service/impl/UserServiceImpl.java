package com.mupei.tutor.service.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mupei.tutor.dao.UserDao;
import com.mupei.tutor.model.User;
import com.mupei.tutor.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public User saveUser(String userName, String password) {
		User user = new User(userName,password);
		return userDao.save(user);
	}

	@Override
	public User findByUserNameAndPassword(String userName, String password) {
		return userDao.findByUserNameAndPassword(userName, password);
	}

	@Override
	public ArrayList<User> getUsers() {
		return (ArrayList<User>) userDao.findAll();
	}

	@Override
	public void delUser(Integer id) {
		Optional<User> optional = userDao.findById(id);
		User user = optional.get();
		userDao.delete(user);
	}

	@Override
	public void updateUser(Integer id, String name, String pswd) {
		User user = new User(id,name,pswd);
		userDao.save(user);
	}

	@Override
	public ArrayList<User> searchUser(Integer key, String name) {
		String condition="";
		switch(key) {
			case 0://准确查询
				return userDao.findByUserName(name);
			case 1://全模糊查询
				condition = "%"+name+"%";
				return userDao.findByUserNameLike(condition);
			case 2://姓氏查询
				condition = name+"%";
				return userDao.findByUserNameLike(condition);
			default:
				return null;
		}
	}
	
}
