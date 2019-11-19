package com.mupei.tutor.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.mupei.tutor.model.User;

//@Repository,JpaRepository已经是IOC容器组件了
public interface UserDao extends CrudRepository<User,Integer>{

	public User findByUserNameAndPassword(String userName, String password);

	public ArrayList<User> findByUserName(String name);

	public ArrayList<User> findByUserNameLike(String condition);
		
}
