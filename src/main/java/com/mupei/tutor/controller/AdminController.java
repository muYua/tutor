package com.mupei.tutor.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mupei.tutor.model.Admin;
import com.mupei.tutor.model.User;
import com.mupei.tutor.service.AdminService;
import com.mupei.tutor.service.UserService;
import com.mupei.tutor.vo.Json;

@Controller
@RequestMapping({"/admin","/"})
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	
	@RequestMapping({"/index","/"})
	public String index() {
		return "login";
	}
	
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
	@ResponseBody
	@GetMapping("/login")
	public Json login(@RequestParam("name") String name,@RequestParam("pswd") String pswd) {
		Json json = new Json();
		try {
			Admin login = adminService.login(name,pswd);
			json.setObj(login);
			if(login!=null)
				json.setSuccess(true);
			else
				json.setSuccess(false);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@GetMapping("/getUsers")
	public Json getUsers() {
		Json json = new Json();
		try {
			ArrayList<User> userList = userService.getUsers();
			json.setObj(userList);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@GetMapping("/getAdmins")
	public Json getAdmins() {
		Json json = new Json();
		try {
			ArrayList<Admin> admin = adminService.getAdmins();
			json.setObj(admin);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@DeleteMapping("/delUser")
	public Json delUser(@RequestParam Integer id) {
		Json json = new Json();
		try {
			userService.delUser(id);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@DeleteMapping("/delAdmin")
	public Json delAdmin(@RequestParam Integer id) {
		Json json = new Json();
		try {
			adminService.delAdmin(id);
			json.setSuccess(true);
		} catch (Exception e) {
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@PostMapping("/addUser")
	public Json addUser(@RequestParam("name") String name,@RequestParam("pswd") String pswd) {
		Json json = new Json();
		try {
			 User user = userService.saveUser(name, pswd);
			 if(user!=null)
				 json.setSuccess(true);
			 else
				 json.setSuccess(false);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@PostMapping("/addAdmin")
	public Json addAdmin(@RequestParam("name") String name,@RequestParam("pswd") String pswd) {
		Json json = new Json();
		try {
			 Admin admin = adminService.saveAdmin(name,pswd);
			 if(admin!=null)
				 json.setSuccess(true);
			 else
				 json.setSuccess(false);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@PutMapping("/updateUser")
	public Json updateUser(@RequestParam Integer id,@RequestParam String name,@RequestParam String pswd) {
		Json json = new Json();
		try {
			userService.updateUser(id,name,pswd);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@PutMapping("/updateAdmin")
	public Json updateAdmin(@RequestParam Integer id,@RequestParam String name,@RequestParam String pswd) {
		Json json = new Json();
		try {
			adminService.updateAmin(id,name,pswd);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@GetMapping("/searchUser")
	public Json searchUser(Integer key,String name) {
		Json json = new Json();
		try {
			ArrayList<User> users = userService.searchUser(key,name);
			json.setObj(users);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
	
	@ResponseBody
	@GetMapping("/searchAdmin")
	public Json searchAdmin(Integer key,String name) {
		Json json = new Json();
		try {
			ArrayList<Admin> admins = adminService.searchAdmin(key,name);
			json.setObj(admins);
			json.setSuccess(true);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
}
