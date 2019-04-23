package com.pronix.spring.proclock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.Manager;
import com.pronix.spring.proclock.pojos.ManagerPojo;

public interface ManagerDAO extends CrudRepository<Manager, Long>{

	public static final String findProjectsByCompanyId = 
			"Select * from manager where project_id = ?1";
	
	@Query(value = findProjectsByCompanyId, nativeQuery = true)
	List<Manager> findManagersByProjectId(Long projectId);

}
