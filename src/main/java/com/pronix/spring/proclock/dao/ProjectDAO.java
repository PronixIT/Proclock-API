package com.pronix.spring.proclock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.Project;

public interface ProjectDAO extends CrudRepository<Project, Long>{

	public static final String findProjectsByCompanyId = 
			"Select * from project where company_id = ?1";
	
	@Query(value = findProjectsByCompanyId, nativeQuery = true)
	List<Project> findProjectsByCompanyId(Long companyId);

}
