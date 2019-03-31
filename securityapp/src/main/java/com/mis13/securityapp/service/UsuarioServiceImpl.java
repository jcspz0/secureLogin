package com.mis13.securityapp.service;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mis13.securityapp.entity.UsuarioVO;
import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.model.Usuario;
import com.mis13.securityapp.repository.ParametroRepository;
import com.mis13.securityapp.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> getAllUsuarios() {
		List<Usuario> list = new ArrayList<>();
		usuarioRepository.fetchUsuarios().forEach(e -> list.add(e));
		return list;
	}
	
	@Override
	public boolean addUsuario(UsuarioVO usuario) {
		if (usuario.getLoginUsr()==null || usuario.getNamesUsr()==null || usuario.getTypeusr()==null) {
			return false;
		}
		List<Usuario> list = usuarioRepository.fetchUserByLoginUsr(usuario.getLoginUsr());
		
		if (list.size() > 0) {
			
			Usuario user = list.get(0);
			user.setLoginUsr(usuario.getLoginUsr());
			user.setNamesUsr(usuario.getNamesUsr());
			user.setPwdUsr(encryptPassword(usuario.getLoginUsr()));
			user.setTypeusr(usuario.getTypeusr());
			user.setCreatedUsr(convertToDateViaInstant(java.time.LocalDateTime.now()));
			user.setStatususr("1");
			
			usuarioRepository.save(list.get(0));
        } else {
        	
        	Usuario user = new Usuario();
    		user.setLoginUsr(usuario.getLoginUsr());
    		user.setNamesUsr(usuario.getNamesUsr());
    		user.setPwdUsr(encryptPassword(usuario.getLoginUsr()));
    		user.setTypeusr(usuario.getTypeusr());
    		user.setCreatedUsr(convertToDateViaInstant(java.time.LocalDateTime.now()));
    		user.setStatususr("1");
        	
        	usuarioRepository.save(user);
        }
        return true;
	}
	
	@Override
	public Usuario getUsuarioByLoginUsr(String loginUsr) {
		Usuario result= new Usuario();
		List<Usuario> list =  usuarioRepository.fetchUserByLoginUsr(loginUsr);
			if (list.size() > 0) {
			result = list.get(0);
        } 
		return result;
	}
	
	@Override
	public void updateUsuario(UsuarioVO usuario) {
		List<Usuario> list = usuarioRepository.fetchUserByLoginUsr(usuario.getLoginUsr());
		Usuario user = list.get(0);
		user.setLoginUsr(usuario.getLoginUsr());
		user.setNamesUsr(usuario.getNamesUsr());
		user.setTypeusr(usuario.getTypeusr());
		usuarioRepository.save(user);
	}

	@Override
	public void deleteUsuario(String loginUsr) {
		usuarioRepository.delete(getUsuarioByLoginUsr(loginUsr));
	}
	
	private Date convertToDateViaInstant(LocalDateTime dateToConvert) {
	    return java.util.Date
	      .from(dateToConvert.atZone(ZoneId.systemDefault())
	      .toInstant());
	}
	
	private String encryptPassword(String pass) {
		try {
		/*SecureRandom random = new SecureRandom();
		byte[] salt = new byte[16];
		random.nextBytes(salt);
		*/
		//byte[] salt = "+5iN0vthXf3MN+//QdGg4g==".getBytes();
		byte[] salt = "MIS013".getBytes();
		
		KeySpec spec = new PBEKeySpec(pass.toCharArray(), salt, 65536, 128);
		SecretKeyFactory factory;
		
		factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		byte[] hash = factory.generateSecret(spec).getEncoded();
		Base64.Encoder enc = Base64.getEncoder();
		System.out.printf("salt: %s%n", enc.encodeToString(salt));
		System.out.printf("hash: %s%n", enc.encodeToString(hash));
		
		return enc.encodeToString(hash);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al encriptar - NoSuchAlgorithmException");
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error al encriptar - InvalidKeySpecException");
		}
		return "";
		
	}

	@Override
	public void updatePassword(UsuarioVO usuario, String password) {
		List<Usuario> list = usuarioRepository.fetchUserByLoginUsr(usuario.getLoginUsr());
		Usuario user = list.get(0);
		user.setPwdUsr(encryptPassword(password));
		usuarioRepository.save(user);
		
	}

	@Override
	public boolean validLogin(String user, String pass) {
		Usuario usuario= new Usuario();
		List<Usuario> list =  usuarioRepository.fetchUserByLoginUsr(user);
		if (list.size() > 0) {
			usuario = list.get(0);
			return usuario.getPwdUsr().compareTo(encryptPassword(pass)) == 0;
        }else {
        	return false;
        }
		
	}
	
}
