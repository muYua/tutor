package com.mupei.tutor.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mupei.tutor.dao.AdminDao;
import com.mupei.tutor.model.Admin;
import com.mupei.tutor.service.AdminService;

@Service("adminService")
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminDao adminDao;

	@Override
	public Admin login(String name, String pswd) {
		return adminDao.findByNameAndPassword(name,pswd);
	}

	@Override
	public ArrayList<Admin> getAdmins() {
		return (ArrayList<Admin>) adminDao.findAll();
	}

	@Override
	public void delAdmin(Integer id) {
		Admin admin = adminDao.findById(id).get();
		adminDao.delete(admin);
	}

	@Override
	public Admin saveAdmin(String name, String pswd) {
		Admin admin = new Admin(name,pswd);
		return adminDao.save(admin);
	}

	@Override
	public void updateAmin(Integer id, String name, String pswd) {
		Admin admin = new Admin(id,name,pswd);
		adminDao.save(admin);
	}

	@Override
	public ArrayList<Admin> searchAdmin(Integer key, String name) {
		String condition="";
		switch(key) {
			case 0://准确查询
				return adminDao.findByName(name);
			case 1://全模糊查询
				condition = "%"+name+"%";
				return adminDao.findByNameLike(condition);
			case 2://姓氏查询
				condition = name+"%";
				return adminDao.findByNameLike(condition);
			default:
				return null;
		}
	}
}
