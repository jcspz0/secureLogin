package com.mis13.securityapp.service;

import java.util.List;

import com.mis13.securityapp.entity.UsuarioVO;
import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.model.Usuario;

public interface UsuarioService {
	
	List<Usuario> getAllUsuarios();
	Usuario getUsuarioByLoginUsr(String loginUsr);
	boolean	addUsuario(UsuarioVO usuario);
	void updateUsuario(UsuarioVO usuario);
	void deleteUsuario(String loginUsr);
	void updatePassword(UsuarioVO usuario, String password);
	boolean validLogin(String user, String pass);
}
