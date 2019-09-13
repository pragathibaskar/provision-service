package com.cg.provisionService.domain;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;







@Repository
public interface Db extends JpaRepository<Provision, Composite>{

	@Query(value="select * from provision p where p.periodo_certificacion=?1",
			nativeQuery=true)
      Page<Provision> findByPeriodo(Date date,Pageable page);

	
	@Query(value="select * from provision p where p.codigo_sap_expediente=:codigo and p.periodo_certificacion=:date",
			nativeQuery=true)
	Provision findByCodigoAndPeriodo(@PathParam("codigo_sap_expediente") String codigo, @PathParam("periodo_certificacion") Date date);
	
	
	@Query(value="select * from provision p where p.periodo_certificacion=?2 and (LOWER( p.codigo_sap_expediente) LIKE ?1 or LOWER(p.cod_sociedad) LIKE ?1)",
			nativeQuery=true)
		Page<Provision> search(String searchString,Date date,Pageable page);
}
