package com.mis13.securityapp.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Parametros")
public class Parametro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_Prm")
	private long idPrm;
	
	@Basic
	@Column(name="paramprm")
	private String paramPrm;
	
	@Basic
	@Column(name="valprm")
	private String valPrm;
	
	public long getIdPrm() {
		return idPrm;
	}
	public void setIdPrm(long idPrm) {
		this.idPrm = idPrm;
	}
	public String getParamPrm() {
		return paramPrm;
	}
	public void setParamPrm(String paramPrm) {
		this.paramPrm = paramPrm;
	}
	public String getValPrm() {
		return valPrm;
	}
	public void setValPrm(String valPrm) {
		this.valPrm = valPrm;
	}

	

}
