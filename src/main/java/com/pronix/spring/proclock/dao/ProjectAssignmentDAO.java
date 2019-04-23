package com.pronix.spring.proclock.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.ProjectAssignment;
import com.pronix.spring.proclock.models.UserDetails;

public interface ProjectAssignmentDAO  extends CrudRepository<ProjectAssignment, Long>{

	List<ProjectAssignment> findByUserDetailsOrderByCompany(UserDetails userDetails);

	List<ProjectAssignment> findByAssignedUserDetailsOrderByCompany(Optional<UserDetails> findById);

}
