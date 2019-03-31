package com.mis13.securityapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.repository.ParametroRepository;

@Service
public class ParametroServiceImpl implements ParametroService{
	
	@Autowired
	private ParametroRepository parametroRepository;
	
	@Override
	public List<Parametro> getAllParametros() {
		List<Parametro> list = new ArrayList<>();
		parametroRepository.fetchParametros().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public boolean addParametro(Parametro parametro) {
		if (parametro.getParamPrm()==null) {
			return false;
		}
		List<Parametro> list = parametroRepository.findByParamPrm(parametro.getParamPrm());
		if (list.size() > 0) {
			parametroRepository.save(list.get(0));
        } else {
        	parametroRepository.save(parametro);
        }
        return true;
	}
	
	@Override
	public Parametro getParametroByName(String name) {
		Parametro result= new Parametro();
		List<Parametro> list =  parametroRepository.fetchParametro(name);
			if (list.size() > 0) {
			result = list.get(0);
        } 
		return result;
	}
	
	@Override
	public void updateParametro(Parametro parametro) {
		parametroRepository.save(parametro);
	}
}
