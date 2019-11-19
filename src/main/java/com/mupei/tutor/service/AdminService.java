package com.mupei.tutor.service;

import java.util.ArrayList;

import com.mupei.tutor.model.Admin;

public interface AdminService {

	public Admin login(String name, String pswd);

	public ArrayList<Admin> getAdmins();

	public void delAdmin(Integer id);

	public Admin saveAdmin(String name, String pswd);

	public void updateAmin(Integer id, String name, String pswd);

	public ArrayList<Admin> searchAdmin(Integer key, String name);

}
