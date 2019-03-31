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
@Table(name="tipousuario")
public class TipoUsuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_tipousr")
	private long id;
	
	@Basic
	@Column(name="tipousr")
	private String tipoUsr;
	
	@Basic
	@Column(name="desctipousr")
	private String descTipoUsr;
	
	public long getId() {
		return id;
	}
	public void setId(long idPrm) {
		this.id = idPrm;
	}
	public String getTipoUsr() {
		return tipoUsr;
	}
	public void setTipoUsr(String tipoUsr) {
		this.tipoUsr = tipoUsr;
	}
	public String getDescTipoUsr() {
		return descTipoUsr;
	}
	public void setDescTipoUsr(String descTipoUsr) {
		this.descTipoUsr = descTipoUsr;
	}

	

}
