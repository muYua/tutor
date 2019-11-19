package com.mupei.tutor.model;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_user")
public class User {
	
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "user_pswd")
	private String password;
	
	@Column(name = "content")
	private ArrayList<Integer> content;
	
	//构造方法
	public User() {
		
	}
	
	public User(Integer id, String name, String pswd) {
		this.id=id;
		this.userName=name;
		this.password=pswd;
	}

	public User(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ArrayList<Integer> getContent() {
		return content;
	}

	public void setContent(ArrayList<Integer> content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", password=" + password + ", content=" + content + "]";
	}
	
}
