package com.mupei.tutor.service;

import java.util.ArrayList;

import com.mupei.tutor.model.User;

public interface UserService {

	public User saveUser(String userName, String password);

	public User findByUserNameAndPassword(String userName, String password);

	public ArrayList<User> getUsers();

	public void delUser(Integer id);

	public void updateUser(Integer id, String name, String pswd);

	public ArrayList<User> searchUser(Integer key, String name);

}
