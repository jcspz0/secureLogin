package com.mis13.securityapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.model.TipoUsuario;
import com.mis13.securityapp.service.ParametroService;
import com.mis13.securityapp.service.TipoUsuarioService;

@Controller
@RequestMapping("api")
//@CrossOrigin(origins = {"http://localhost:4200","http://192.168.1.12:8081","http://localhost:8081","http://192.168.33.10:8081","http://10.0.2.15:8081"}, maxAge = 4800, allowCredentials = "false")
public class TipoUsuarioController {
	
	@Autowired
	private TipoUsuarioService tipoUsuarioService;
	
	@GetMapping("tipousuarios")
	public ResponseEntity<List<TipoUsuario>> getAllTipoUsuarios() {
		List<TipoUsuario> list = tipoUsuarioService.getAllTipoUsuarios();
		return new ResponseEntity<List<TipoUsuario>>(list, HttpStatus.OK);
	}
	
	

}
