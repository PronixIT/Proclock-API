package com.pronix.spring.proclock.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.RefStatus;

public interface RefStatusDAO extends CrudRepository<RefStatus, Long> {
	
	public static final String findByValue = 
			"Select * from ref_status where value = ?1";
	
	@Query(value = findByValue, nativeQuery = true)
	RefStatus findByValue(String statusValue);
	
}
