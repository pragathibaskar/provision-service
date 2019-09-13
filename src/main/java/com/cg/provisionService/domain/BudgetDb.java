package com.cg.provisionService.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface BudgetDb extends JpaRepository<Budget, String>{
	
	@Query(value="select * from budget b where LOWER( b.codigo_sap_expediente) LIKE ?1",
			nativeQuery=true)
	List<Budget> search(String cod);

}
