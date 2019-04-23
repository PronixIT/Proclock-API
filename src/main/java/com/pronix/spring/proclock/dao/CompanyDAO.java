package com.pronix.spring.proclock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.Company;

public interface CompanyDAO extends CrudRepository<Company, Long>{

	public static final String findByUserId = 
			"Select * from company where user_id = ?1";
	
	@Query(value = findByUserId, nativeQuery = true)
	List<Company> findCompaniesbyUserId(Long userId);

}
