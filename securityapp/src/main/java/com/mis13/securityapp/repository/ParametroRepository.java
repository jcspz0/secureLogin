package com.mis13.securityapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mis13.securityapp.model.Parametro;

@Repository
public interface ParametroRepository extends CrudRepository<Parametro, Long>{
	List<Parametro> findByParamPrm(String name);

    @Query("SELECT a FROM Parametro a WHERE a.paramPrm=:paramPrm and a.valPrm=:valPrm")
    List<Parametro> fetchParametroByNameAndValue(@Param("paramPrm") String paramPrm, @Param("valPrm") String valPrm);
    
    @Query("SELECT a FROM Parametro a WHERE a.paramPrm=:paramPrm")
    List<Parametro> fetchParametro(@Param("paramPrm") String paramPrm);
    
    @Query("SELECT a FROM Parametro a")
    List<Parametro> fetchParametros();

}
