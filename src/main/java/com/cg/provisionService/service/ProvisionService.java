package com.cg.provisionService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.provisionService.domain.Cert;
import com.cg.provisionService.domain.Db;
import com.cg.provisionService.domain.Provision;

@Service
public class ProvisionService {
	
	@Autowired
	private Db db;
	
	@SuppressWarnings("deprecation")
	public Provision findCodigo(Cert p)
	{
		Provision pro = db.findByCodigoAndPeriodo(p.getCodigo(), p.getPeriodo());
		if(pro!=null)
		return pro;
		else 
		return null;
	}
	
	
	public Provision createNew(Provision p) {
      Provision con = db.findByCodigoAndPeriodo(p.getKey().getCodigo(), p.getKey().getPeriodo());
		if(con==null)
		{
		db.saveAndFlush(p);
		return p;
		}
		else
		{
		System.out.println("it already exists");
		return null;
		}
		
		
	}
	public List<Provision> getAll()
	{
		return db.findAll();
	}


	
	public void deleteById(Provision entity) {
		db.delete(entity);
		
	}
	

}
