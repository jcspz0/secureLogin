package com.mis13.securityapp.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

import com.mis13.securityapp.model.Usuario;

public class UsuarioVO {
	
	private String loginUsr;
	
	private String namesUsr;
	
	
	
	private String typeusr;

	public UsuarioVO() {
		super();
	}
	
	public UsuarioVO(Usuario us) {
		this.setLoginUsr(us.getLoginUsr());
		this.setNamesUsr(us.getNamesUsr());
		
		this.setTypeusr(us.getTypeusr());
	}

	public String getLoginUsr() {
		return loginUsr;
	}

	public void setLoginUsr(String loginUsr) {
		this.loginUsr = loginUsr;
	}

	public String getNamesUsr() {
		return namesUsr;
	}

	public void setNamesUsr(String namesUsr) {
		this.namesUsr = namesUsr;
	}

	public String getTypeusr() {
		return typeusr;
	}

	public void setTypeusr(String typeusr) {
		this.typeusr = typeusr;
	}
	
	

}
