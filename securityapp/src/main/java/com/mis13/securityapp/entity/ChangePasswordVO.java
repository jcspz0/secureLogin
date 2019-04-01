package com.mis13.securityapp.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

import com.mis13.securityapp.model.Usuario;

public class ChangePasswordVO {
	
	private String user;
	
	private String password;
	
	private String newPassword;
	
	public ChangePasswordVO() {
		super();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	
	
}
