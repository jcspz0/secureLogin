package com.mis13.securityapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.model.TipoUsuario;
import com.mis13.securityapp.repository.ParametroRepository;
import com.mis13.securityapp.repository.TipoUsuarioRepository;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService{
	
	@Autowired
	private TipoUsuarioRepository tipoUsuarioRepository;
	
	@Override
	public List<TipoUsuario> getAllTipoUsuarios() {
		List<TipoUsuario> list = new ArrayList<>();
		tipoUsuarioRepository.fetchTipoUsuarios().forEach(e -> list.add(e));
		return list;
	}

}
