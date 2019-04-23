package com.pronix.spring.proclock.controllers;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pronix.spring.proclock.models.Company;
import com.pronix.spring.proclock.models.Manager;
import com.pronix.spring.proclock.models.Project;
import com.pronix.spring.proclock.models.UserTimeSheet;
import com.pronix.spring.proclock.pojos.CompanyPojo;
import com.pronix.spring.proclock.pojos.Employee;
import com.pronix.spring.proclock.pojos.LoginDetailsPojo;
import com.pronix.spring.proclock.pojos.ManagerPojo;
import com.pronix.spring.proclock.pojos.ManagerStatusReportPojo;
import com.pronix.spring.proclock.pojos.ProjectPojo;
import com.pronix.spring.proclock.pojos.ResetPassword;
import com.pronix.spring.proclock.pojos.StatusRes;
import com.pronix.spring.proclock.pojos.UserDashboardData;
import com.pronix.spring.proclock.pojos.UserDetailsPojo;
import com.pronix.spring.proclock.pojos.UserStatusReportPojo;
import com.pronix.spring.proclock.pojos.UserTimeSheetPojo;
import com.pronix.spring.proclock.services.UserServices;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/proClock")
public class ApiController {
	
	@Autowired
	private UserServices userServices;
	
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	public Object registerAdmin(@RequestBody UserDetailsPojo userDetailsPojo) {
		return userServices.registerUser(userDetailsPojo);
	}
	/*
	@RequestMapping("/getRoles")
	public List<RefRoles> getRoles() {
		return userServices.getRoles();
	}
	*/
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public Object login(@RequestBody LoginDetailsPojo loginDetailsPojo) {
		return userServices.login(loginDetailsPojo);
	}
	
	/*@RequestMapping(method = RequestMethod.POST, value = "/test")
	public Object test(@RequestBody LoginDetailsPojo lotestginDetailsPojo) {
		return new StatusRes("Test Connected");
	}*/
	
	@RequestMapping(method = RequestMethod.POST, value = "/resetPassword")
	public StatusRes resetPassword(@RequestBody ResetPassword resetPassword) {
		return userServices.resetPassword(resetPassword);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/changePassword")
	public StatusRes changePassword(@RequestBody ResetPassword changePassword) {
		return userServices.changePassword(changePassword);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateTimesheet")
	public StatusRes updateTimesheet(@RequestBody UserTimeSheetPojo userTimeSheetPojo) {
		return userServices.updateTimesheet(userTimeSheetPojo);
	}
	
	@RequestMapping("/viewTimesheet/{id}")
	public List<UserTimeSheet> viewTimesheet(@PathVariable("id") Long userId) {
		return userServices.viewTimesheet(userId);
	}
	
	@RequestMapping("/viewCompanies/{id}")
	public List<Company> viewCompanies(@PathVariable("id") Long userId) {
		return userServices.viewCompanies(userId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addCompany")
	public StatusRes addCompany(@RequestBody CompanyPojo company) {
		return userServices.addCompany(company);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateCompany")
	public StatusRes updateCompany(@RequestBody CompanyPojo company) {
		return userServices.updateCompany(company);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addProject")
	public StatusRes addProject(@RequestBody ProjectPojo project) {
		return userServices.addProject(project);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateProject")
	public StatusRes updateProject(@RequestBody ProjectPojo project) {
		return userServices.updateProject(project);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addManager")
	public StatusRes addManager(@RequestBody ManagerPojo Manager) {
		return userServices.addManager(Manager);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/updateManager")
	public StatusRes updateManager(@RequestBody ManagerPojo Manager) {
		return userServices.updateManager(Manager);
	}
	
	@RequestMapping("/viewProjects/{id}")
	public List<Project> viewProjects(@PathVariable("id") Long companyId) {
		return userServices.viewProjects(companyId);
	}
	
	@RequestMapping("/viewManagers/{id}")
	public List<Manager> viewManagers(@PathVariable("id") Long projectId) {
		return userServices.viewManagers(projectId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/addEmployee")
	public StatusRes addEmployee(@RequestBody Employee employee) {
		return userServices.addEmployee(employee);
	}
	
	@RequestMapping("/viewEmployees/{id}")
	public List<Employee> viewEmployees(@PathVariable("id") Long userId) {
		return userServices.viewEmployees(userId);
	}
	
	@RequestMapping("/userDashboard/{id}")
	public UserDashboardData userDashboard(@PathVariable("id") Long userId) {
		return userServices.userDashboard(userId);
	}
	
	@RequestMapping("/userStatusReport/{id}")
	public List<UserStatusReportPojo> userStatusReport(@PathVariable("id") Long userId) {
		return userServices.userStatusReport(userId);
	}
	
	@RequestMapping("/managerStatusReport/{id}")
	public List<ManagerStatusReportPojo> managerStatusReport(@PathVariable("id") Long userId) {
		return userServices.managerStatusReport(userId);
	}
	
	@RequestMapping("/getProjectlist/{id}")
	public List<Project> getProjectlist(@PathVariable("id") Long userId) {
		return userServices.getProjectlist(userId);
	}
}
