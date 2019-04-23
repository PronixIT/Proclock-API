package com.pronix.spring.proclock.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.pronix.spring.proclock.models.Project;
import com.pronix.spring.proclock.models.RefStatus;
import com.pronix.spring.proclock.models.UserDetails;
import com.pronix.spring.proclock.models.UserTimeSheet;

public interface UserTimeSheetDAO extends CrudRepository<UserTimeSheet, Long>{
	
	public static final String findByUserId = "select * from user_timesheet where user_id = ?1";
	
	public static final String countOfPendingTimesheets = "select count(*) from user_timesheet where user_id = ?1 and status_id = 1";
	
	public static final String countOfAcceptedTimesheets = "select count(*) from user_timesheet where user_id = ?1 and status_id = 2";
	
	public static final String countOfRejectedTimesheets = "select count(*) from user_timesheet where user_id = ?1 and status_id = 3";
	
	@Query(value = findByUserId, nativeQuery = true)
	List<UserTimeSheet> findAllById(Long userId);

	@Query(value = countOfPendingTimesheets, nativeQuery = true)
	int countOfPendingTimesheets(Long userId);

	@Query(value = countOfAcceptedTimesheets, nativeQuery = true)
	int countOfAcceptedTimesheets(Long userId);

	@Query(value = countOfRejectedTimesheets, nativeQuery = true)
	int countOfRejectedTimesheets(Long userId);

	List<UserTimeSheet> findByUserDetails(UserDetails userDetails);

	List<UserTimeSheet> findByProject(Project project);

	List<UserTimeSheet> findByProjectAndRefStatus(Project project, RefStatus refStatus);

}
