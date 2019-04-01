package com.mis13.securityapp.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import com.mis13.securityapp.entity.UsuarioVO;
import com.mis13.securityapp.entity.ChangePasswordVO;
import com.mis13.securityapp.entity.LoginVO;
import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.model.Usuario;
import com.mis13.securityapp.service.ParametroService;
import com.mis13.securityapp.service.UsuarioService;

@Controller
@RequestMapping("api")
//@CrossOrigin(origins = {"http://localhost:4200","http://192.168.1.12:8081","http://localhost:8081","http://192.168.33.10:8081","http://10.0.2.15:8081"}, maxAge = 4800, allowCredentials = "false")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping("usuarios")
	public ResponseEntity<List<UsuarioVO>> getAllUsuarios() {
		List<Usuario> list = usuarioService.getAllUsuarios();
		List<UsuarioVO> listVO = list.stream().map(us -> new UsuarioVO(us)).collect(Collectors.toList());
		return new ResponseEntity<List<UsuarioVO>>(listVO, HttpStatus.OK);
	}
	
	@GetMapping("usuario/{loginusr}")
	public ResponseEntity<UsuarioVO> getUsuarioByLoginUsr(@PathVariable("loginusr") String loginusr) {
		Usuario usuario = usuarioService.getUsuarioByLoginUsr(loginusr);
		if(usuario==null) {
			return new ResponseEntity<UsuarioVO>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<UsuarioVO>(new UsuarioVO(usuario), HttpStatus.OK);
	}
	
	@PutMapping("usuario")
	public ResponseEntity<UsuarioVO> updateUsuario(@RequestBody UsuarioVO usuario) {
		usuarioService.updateUsuario(usuario);
		return new ResponseEntity<UsuarioVO>(usuario, HttpStatus.OK);
	}
	
	@DeleteMapping("usuario/{loginusr}")
	public ResponseEntity<Void> deleteperson(@PathVariable("loginusr") String loginusr) {
		usuarioService.deleteUsuario(loginusr);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	
	@PostMapping("usuario")
	public ResponseEntity<Void> addUsuario(@RequestBody UsuarioVO usuario, UriComponentsBuilder builder) {
                boolean flag = usuarioService.addUsuario(usuario);
                if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/usuario/{id}").buildAndExpand(usuario.getLoginUsr()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PostMapping("usuario/login")
	public ResponseEntity<Void> validLogin(@RequestBody LoginVO login, UriComponentsBuilder builder) {
                boolean flag = usuarioService.validLogin(login);
                if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/usuario/{id}").buildAndExpand(login.getUser()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}
	
	@PostMapping("usuario/changePassword")
	public ResponseEntity<Void> changePassword(@RequestBody ChangePasswordVO data, UriComponentsBuilder builder) {
                boolean flag = usuarioService.changePassword(data);
                if (flag == false) {
                	return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/usuario/{id}").buildAndExpand(data.getUser()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.OK);
	}

}
