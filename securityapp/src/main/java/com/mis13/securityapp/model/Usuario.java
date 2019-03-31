package com.mis13.securityapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="loginusr")
	private String loginUsr;
	
	@Basic
	@Column(name="namesusr")
	private String namesUsr;
	
	@Basic
	@Column(name="pwdusr")
	private String pwdUsr;
	
	@Basic
	@Column(name="statususr")
	private String statususr;

	@Column(name="deletedusr")
	private Date deletedUsr;
	
	@Column(name="createdusr")
	private Date createdUsr;
	
	@Column(name="lastchangepwdusr")
	private Date lastChangePwdUsr;
	
	@Column(name="lastloginusr")
	private Date lastLoginUsr;
	
	@Basic
	@Column(name="typeusr")
	private String typeusr;

	
	
	public Usuario() {
		super();
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

	public String getPwdUsr() {
		return pwdUsr;
	}

	public void setPwdUsr(String pwdUsr) {
		this.pwdUsr = pwdUsr;
	}

	public String getStatususr() {
		return statususr;
	}

	public void setStatususr(String statususr) {
		this.statususr = statususr;
	}

	public Date getDeletedUsr() {
		return deletedUsr;
	}

	public void setDeletedUsr(Date deletedUsr) {
		this.deletedUsr = deletedUsr;
	}

	public Date getCreatedUsr() {
		return createdUsr;
	}

	public void setCreatedUsr(Date createdUsr) {
		this.createdUsr = createdUsr;
	}

	public Date getLastChangePwdUsr() {
		return lastChangePwdUsr;
	}

	public void setLastChangePwdUsr(Date lastChangePwdUsr) {
		this.lastChangePwdUsr = lastChangePwdUsr;
	}

	public Date getLastLoginUsr() {
		return lastLoginUsr;
	}

	public void setLastLoginUsr(Date lastLoginUsr) {
		this.lastLoginUsr = lastLoginUsr;
	}

	public String getTypeusr() {
		return typeusr;
	}

	public void setTypeusr(String typeusr) {
		this.typeusr = typeusr;
	}
	
	

}
