package com.mis13.securityapp.service;

import java.util.List;

import com.mis13.securityapp.model.Parametro;

public interface ParametroService {
	
	List<Parametro> getAllParametros();
	Parametro getParametroByName(String name);
	boolean	addParametro(Parametro parametro);
	void updateParametro(Parametro parametro);

}
