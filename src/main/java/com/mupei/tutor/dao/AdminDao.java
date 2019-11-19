package com.mupei.tutor.dao;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.mupei.tutor.model.Admin;

public interface AdminDao extends CrudRepository<Admin, Integer> {

	public Admin findByNameAndPassword(String name, String pswd);

	public ArrayList<Admin> findByName(String name);

	public ArrayList<Admin> findByNameLike(String condition);

}
