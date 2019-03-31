package com.mis13.securityapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis13.securityapp.model.Parametro;
import com.mis13.securityapp.model.TipoUsuario;

@Repository
public interface TipoUsuarioRepository extends CrudRepository<TipoUsuario, Long>{
    
    @Query("SELECT a FROM TipoUsuario a")
    List<TipoUsuario> fetchTipoUsuarios();

}
