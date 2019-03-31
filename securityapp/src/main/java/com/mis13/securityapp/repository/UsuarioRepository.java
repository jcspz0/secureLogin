package com.mis13.securityapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	List<Usuario> findByLoginUsr(String loginUsr);

    @Query("SELECT a FROM Usuario a WHERE a.loginUsr=:loginUsr")
    List<Usuario> fetchUserByLoginUsr(@Param("loginUsr") String loginUsr);
    
    @Query("SELECT a FROM Usuario a")
    List<Usuario> fetchUsuarios();

}
