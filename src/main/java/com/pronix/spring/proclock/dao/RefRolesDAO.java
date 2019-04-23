package com.pronix.spring.proclock.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.RefRoles;

@Transactional
public interface RefRolesDAO  extends CrudRepository<RefRoles, Long>{

	public static final String findByValue = 
			"Select * from ref_roles where value = ?1";
	
	@Query(value = findByValue, nativeQuery = true)
	RefRoles findByValue(String refRole);

}
