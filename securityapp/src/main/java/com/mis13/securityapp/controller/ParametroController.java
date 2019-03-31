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
import com.mis13.securityapp.service.ParametroService;

@Controller
@RequestMapping("api")
//@CrossOrigin(origins = {"http://localhost:4200","http://192.168.1.12:8081","http://localhost:8081","http://192.168.33.10:8081","http://10.0.2.15:8081"}, maxAge = 4800, allowCredentials = "false")
public class ParametroController {
	
	@Autowired
	private ParametroService parametroService;
	
	@GetMapping("parametros")
	public ResponseEntity<List<Parametro>> getAllPersons() {
		List<Parametro> list = parametroService.getAllParametros();
		return new ResponseEntity<List<Parametro>>(list, HttpStatus.OK);
	}
	
	@GetMapping("parametro/{name}")
	public ResponseEntity<Parametro> getPersonById(@PathVariable("name") String name) {
		Parametro parametro = parametroService.getParametroByName(name);
		if(parametro==null) {
			return new ResponseEntity<Parametro>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Parametro>(parametro, HttpStatus.OK);
	}
	
	@PutMapping("parametro")
	public ResponseEntity<Parametro> updateParametro(@RequestBody Parametro parametro) {
		parametroService.updateParametro(parametro);
		return new ResponseEntity<Parametro>(parametro, HttpStatus.OK);
	}

}
