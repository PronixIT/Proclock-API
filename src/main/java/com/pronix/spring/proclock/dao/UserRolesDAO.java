package com.pronix.spring.proclock.dao;

import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.UserDetails;
import com.pronix.spring.proclock.models.UserRoles;

public interface UserRolesDAO extends CrudRepository<UserRoles, Long>{

	UserRoles findByUserDetails(UserDetails userDetails);

}
