package com.mupei.tutor.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mupei.tutor.model.User;
import com.mupei.tutor.service.UserService;
import com.mupei.tutor.vo.Json;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/reg")
	public Json reg(@RequestParam("username") String userName,@RequestParam("password") String password) {
		Json json = new Json();
		try {
			User user = userService.saveUser(userName,password);
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
	
	@GetMapping("/login")
	public Json login(HttpServletResponse response, @RequestParam("username") String userName,@RequestParam("password") String password) {
		Json json = new Json();
		try {
			User user = userService.findByUserNameAndPassword(userName,password);
			json.setObj(user);	
			if(user!=null)
			{
				json.setSuccess(true);
			}
			else
				json.setSuccess(false);
		} catch (Exception e) {
			e.printStackTrace();
			json.setSuccess(false);
		}
		return json;
	}
}
