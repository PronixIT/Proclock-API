package com.pronix.spring.proclock.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.UserDetails;
import com.pronix.spring.proclock.models.UserPassword;

@Transactional
public interface UserPasswordDAO extends CrudRepository<UserPassword, Long>{
	
	public static final String findByUserId = 
			"Select * from user_password where user_id = ?1";
	
	UserPassword findByUserName(String username);
	
	@Query(value = findByUserId, nativeQuery = true)
	UserPassword findByUserId(Long userId);

	List<UserPassword> findByCreatedByUserDetails(UserDetails userDetails);

}
