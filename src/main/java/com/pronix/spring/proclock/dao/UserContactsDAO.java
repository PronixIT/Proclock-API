package com.pronix.spring.proclock.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.UserContacts;
import com.pronix.spring.proclock.models.UserDetails;

@Transactional
public interface UserContactsDAO extends CrudRepository<UserContacts, Long>{

	UserContacts findByEmailId(String emailId);

	UserContacts findByUserDetails(UserDetails userDetails);

}
