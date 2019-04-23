package com.pronix.spring.proclock.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.UserDetails;

@Transactional
public interface UserDetailsDAO extends CrudRepository<UserDetails, Long>{

}
