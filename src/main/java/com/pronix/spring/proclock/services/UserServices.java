package com.pronix.spring.proclock.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.joda.time.Weeks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.UnexpectedRollbackException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pronix.spring.proclock.dao.CompanyDAO;
import com.pronix.spring.proclock.dao.ManagerDAO;
import com.pronix.spring.proclock.dao.ProjectAssignmentDAO;
import com.pronix.spring.proclock.dao.ProjectDAO;
import com.pronix.spring.proclock.dao.RefRolesDAO;
import com.pronix.spring.proclock.dao.RefStatusDAO;
import com.pronix.spring.proclock.dao.UserContactsDAO;
import com.pronix.spring.proclock.dao.UserDetailsDAO;
import com.pronix.spring.proclock.dao.UserPasswordDAO;
import com.pronix.spring.proclock.dao.UserRolesDAO;
import com.pronix.spring.proclock.dao.UserTimeSheetDAO;
import com.pronix.spring.proclock.models.Company;
import com.pronix.spring.proclock.models.Manager;
import com.pronix.spring.proclock.models.Project;
import com.pronix.spring.proclock.models.ProjectAssignment;
import com.pronix.spring.proclock.models.RefRoles;
import com.pronix.spring.proclock.models.RefStatus;
import com.pronix.spring.proclock.models.UserContacts;
import com.pronix.spring.proclock.models.UserDetails;
import com.pronix.spring.proclock.models.UserPassword;
import com.pronix.spring.proclock.models.UserRoles;
import com.pronix.spring.proclock.models.UserTimeSheet;
import com.pronix.spring.proclock.pojos.CompanyPojo;
import com.pronix.spring.proclock.pojos.Employee;
import com.pronix.spring.proclock.pojos.LoginDetailsPojo;
import com.pronix.spring.proclock.pojos.LoginStatusRes;
import com.pronix.spring.proclock.pojos.ManagerPojo;
import com.pronix.spring.proclock.pojos.ManagerStatusReportPojo;
import com.pronix.spring.proclock.pojos.ProjectPojo;
import com.pronix.spring.proclock.pojos.ResetPassword;
import com.pronix.spring.proclock.pojos.StatusRes;
import com.pronix.spring.proclock.pojos.UserDashboardData;
import com.pronix.spring.proclock.pojos.UserDetailsPojo;
import com.pronix.spring.proclock.pojos.UserStatusReportPojo;
import com.pronix.spring.proclock.pojos.UserTimeSheetPojo;


@Service
@Transactional(propagation = Propagation.SUPPORTS)
public class UserServices {

	@Autowired
	private UserContactsDAO userContactsDAO;

	@Autowired
	private UserDetailsDAO userDetailsDAO;
	
	@Autowired
	private UserPasswordDAO userPasswordDAO;
	
	@Autowired
	private UserRolesDAO userRolesDAO;
	
	@Autowired
	private RefRolesDAO refRolesDAO;
	
	@Autowired
	private UserTimeSheetDAO userTimeSheetDAO;
	
	@Autowired
	private RefStatusDAO refStatusDAO;

	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private ProjectDAO projectDAO;
	
	@Autowired
	private ManagerDAO managerDAO;
	
	@Autowired
	private ProjectAssignmentDAO projectAssignmentDAO;
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Object registerUser(UserDetailsPojo userDetailsPojo){
		try {
			//userContactsDAO.findByEmailId(userDetailsPojo.getEmailId());
			RefRoles refRoles = null;
			refRoles = refRolesDAO.findByValue("Admin");
			if(refRoles == null) {
				refRolesDAO.save(new RefRoles("Admin","Admin User"));
				refRoles = refRolesDAO.findByValue("Admin");
			}
			UserDetails userDetails = new UserDetails(userDetailsPojo.getFirstName(),userDetailsPojo.getLastName());
			userDetailsDAO.save(userDetails);
			UserPassword userPassword = new UserPassword(userDetailsPojo.getUserName(),getMd5("random"),userDetails,null);
			UserContacts userContacts = new UserContacts(userDetailsPojo.getEmailId(),userDetailsPojo.getPhoneNo(),userDetails);
			UserRoles userRoles = new UserRoles(refRoles,userDetails);
			userPasswordDAO.save(userPassword);
			userContactsDAO.save(userContacts);
			userRolesDAO.save(userRoles);
			return new StatusRes("success","000","ok",userDetailsDAO.findById(userPassword.getUserDetails().getUserId()));
		} catch(UnexpectedRollbackException e) {
			System.out.println("hai1"+e.getMostSpecificCause().getMessage());
			return new StatusRes("failed","004","Mobile Number or EmailId or Username is already found");
		} catch (DataIntegrityViolationException e) {
			try {
				System.out.println("hai2"+e.getMostSpecificCause().getMessage());
				String x[] = e.getMostSpecificCause().getMessage().split("\'");
				if(userDetailsPojo.getUserName().equals(x[1])) 
					return new StatusRes("failed","004","UserName is Duplicated");
				else if(userDetailsPojo.getEmailId().equals(x[1]))
					return new StatusRes("failed","004","EmailId is Duplicated");	
				else if(userDetailsPojo.getPhoneNo().equals(x[1]))
					return new StatusRes("failed","004","Phone Number is Duplicated");
				else 
					return new StatusRes("failed","004","Mobile Number or EmailId or Username is already found");
			}catch(UnexpectedRollbackException xe) {
				System.out.println("hai1"+xe.getMostSpecificCause().getMessage());
				return new StatusRes("failed","004","Mobile Number or EmailId or Username is already found");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new StatusRes("failed","004","Mobile Number or EmailId or Username is already found");
		}
	}

	public Object login(LoginDetailsPojo loginDetailsPojo) {
		UserContacts userContacts = userContactsDAO.findByEmailId(loginDetailsPojo.getEmailId());
		if(userContacts != null) {
		UserPassword userPassword = userPasswordDAO.findByUserId(userContacts.getUserDetails().getUserId());
		
			if(userPassword.getUserPassword().equals(getMd5(loginDetailsPojo.getPassword()))) {
				UserDetails userDetails = userDetailsDAO.findById(userPassword.getUserDetails().getUserId()).get();
				UserRoles userRoles = userRolesDAO.findByUserDetails(userDetails);		
				return new LoginStatusRes("success","000","ok",userDetails,refRolesDAO.findById(userRoles.getRefRoles().getRoleId()).get().getValue());
			}
			else 
				return new StatusRes("failed","003","Password Wrong");		
		}
		else 
			return new StatusRes("failed","001","Email is not Registered");		
	}

	public StatusRes resetPassword(ResetPassword resetPassword) {
		UserPassword userPassword = userPasswordDAO.findByUserId(resetPassword.getUserId());
		if(userPassword != null) {
			userPasswordDAO.save(new UserPassword(userPassword.getId(),userPassword.getUserName(),getMd5(resetPassword.getNewPassword()),
					userPassword.getUserDetails(),userPassword.getCreatedByUserDetails(),userPassword.getCreatedDate()));
			return new StatusRes("success","000","ok");
		}else 
			return new StatusRes("failed","002","User Not Found");
	}

	public StatusRes changePassword(ResetPassword changePassword) {
		UserPassword userPassword = userPasswordDAO.findByUserId(changePassword.getUserId());
		if(userPassword != null) {
			if(userPassword.getUserPassword().equals(getMd5(changePassword.getOldPassword()))) {
				userPasswordDAO.save(new UserPassword(userPassword.getId(),userPassword.getUserName(),userPassword.getUserName(),
						userPassword.getUserDetails(),userPassword.getCreatedByUserDetails(),userPassword.getCreatedDate()));
				return new StatusRes("success","000","ok");
			}else 
				return new StatusRes("failed","003","Password Wrong");		
		}
		else 
			return new StatusRes("success","002","User Not Found");
	}

	public StatusRes updateTimesheet(UserTimeSheetPojo userTimeSheetPojo) {
		RefStatus refStatus = null;
		refStatus = refStatusDAO.findByValue("Pending");
		if(refStatus == null) {
			refStatusDAO.save(new RefStatus("Pending","Pending Timesheet"));
			refStatus = refStatusDAO.findByValue("Pending");
		}
		UserDetails userDetails = userDetailsDAO.findById(userTimeSheetPojo.getUserId()).get();
		userTimeSheetDAO.save(new UserTimeSheet(userTimeSheetPojo.getStartDate(),userTimeSheetPojo.getEndDate(),userTimeSheetPojo.getMonday(),
				userTimeSheetPojo.getTuesday(),userTimeSheetPojo.getWednesday(),userTimeSheetPojo.getThursday(),userTimeSheetPojo.getFriday(),
				userTimeSheetPojo.getSaturday(),userTimeSheetPojo.getSunday(),projectDAO.findById(userTimeSheetPojo.getProjectId()).get(),refStatus,userDetails));
		return new StatusRes("success","000","ok");
	}

	public List<UserTimeSheet> viewTimesheet(Long userId) {
		return userTimeSheetDAO.findAllById(userId);
	}

	/*public List<RefRoles> getRoles() {
		return (List<RefRoles>) refRolesDAO.findAll();
	}*/

	public StatusRes addCompany(CompanyPojo company) {
		UserDetails userDetails = userDetailsDAO.findById(company.getUserId()).get();
		companyDAO.save(new Company(company.getCompanyName(),company.getCompanyAddress(),userDetails));
		return new StatusRes("success","000","ok",null);
	}

	public StatusRes addProject(ProjectPojo projectPojo) {
		Company company = companyDAO.findById(projectPojo.getCompanyId()).get();
		projectDAO.save(new Project(projectPojo.getProjectName(),projectPojo.getProjectCode(),projectPojo.getProjectVendor(),
				projectPojo.getProjectStartDate(),projectPojo.getProjectDuration(),projectPojo.getDescription(),company));
		return new StatusRes("success","000","ok",null);
	}

	public StatusRes addManager(ManagerPojo manager) {
		Project project = projectDAO.findById(manager.getProjectId()).get();
		managerDAO.save(new Manager(manager.getManagerName(),manager.getManagerEmail(),manager.getIsAuth(),getMd5("random"),project));
		return new StatusRes("success","000","ok",null);
	}
	
	public StatusRes updateManager(ManagerPojo manager) {
		Project project = projectDAO.findById(manager.getProjectId()).get();
		managerDAO.save(new Manager(manager.getManagerId(),manager.getManagerName(),manager.getManagerEmail(),manager.getIsAuth(),getMd5("random"),project));
		return new StatusRes("success","000","ok",null);
	}

	public StatusRes updateProject(ProjectPojo projectPojo) {
		Company company = companyDAO.findById(projectPojo.getCompanyId()).get();
		projectDAO.save(new Project(projectPojo.getProjectId(),projectPojo.getProjectName(),projectPojo.getProjectCode(),projectPojo.getProjectVendor(),
				projectPojo.getProjectStartDate(),projectPojo.getProjectDuration(),projectPojo.getDescription(),company));
		return new StatusRes("success","000","ok",null);
	}

	public List<Company> viewCompanies(Long userId) {
		return (List<Company>) companyDAO.findCompaniesbyUserId(userId);
	}

	public List<Project> viewProjects(Long companyId) {
		// TODO Auto-generated method stub
		return (List<Project>) projectDAO.findProjectsByCompanyId(companyId);
	}

	public List<Manager> viewManagers(Long projectId) {
		// TODO Auto-generated method stub
		return (List<Manager>) managerDAO.findManagersByProjectId(projectId);
	}

	public StatusRes addEmployee(Employee employee) {
		try {
			RefRoles refRoles = null;
			refRoles = refRolesDAO.findByValue("Employee");
			if(refRoles == null) {
				refRolesDAO.save(new RefRoles("Employee","Normal User"));
				refRoles = refRolesDAO.findByValue("Employee");
			}
			//RefRoles refRoles = refRolesDAO.findById((long) Long.parseLong(userDetailsPojo.getUserRole())).get();
			UserDetails userDetails = new UserDetails(employee.getFirstName(),employee.getLastName());
			userDetailsDAO.save(userDetails);
			UserPassword userPassword = new UserPassword(employee.getUserName(),getMd5("random"),userDetails,userDetailsDAO.findById(employee.getCreatedBy()).get());
			UserContacts userContacts = new UserContacts(employee.getEmailId(),employee.getPhoneNo(),userDetails);
			UserRoles userRoles = new UserRoles(refRoles,userDetails);
			userPasswordDAO.save(userPassword);
			userContactsDAO.save(userContacts);
			userRolesDAO.save(userRoles);
			List<Project> projectList = new ArrayList<>();
			projectList.add(projectDAO.findById(employee.getProjectId()).get());
			List<Manager> managerList = new ArrayList<>();
			managerList.add(managerDAO.findById(employee.getManagerId()).get());
			projectAssignmentDAO.save(new ProjectAssignment(userDetails,companyDAO.findById(employee.getCompanyId()).get(),projectList,managerList,userDetailsDAO.findById(employee.getCreatedBy()).get()));
			return new StatusRes("success","000","ok",userDetailsDAO.findById(userPassword.getUserDetails().getUserId()));
		} catch(UnexpectedRollbackException e) {
			System.out.println("hai"+e.getMostSpecificCause().getMessage());
			return new StatusRes("failed","004","Mobile Number or EmailId or Username is already found");
		} catch (DataIntegrityViolationException e) {
			System.out.println("hai"+e.getMostSpecificCause().getMessage());
			String x[] = e.getMostSpecificCause().getMessage().split("\'");
			if(employee.getUserName().equals(x[1])) 
				return new StatusRes("failed","004","UserName is Duplicated");
			else if(employee.getEmailId().equals(x[1]))
				return new StatusRes("failed","004","EmailId is Duplicated");	
			else if(employee.getPhoneNo().equals(x[1]))
				return new StatusRes("failed","004","Phone Number is Duplicated");
			else 
				return new StatusRes("failed","004","Mobile Number or EmailId or Username is already found");
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return new StatusRes("failed","004","Mobile Number or EmailId or Username is already found");
		}
	}
	
	public List<Employee> viewEmployees(Long userId) {
		List<Employee> employeeList = new ArrayList<>();
		List<UserPassword> userPasswordList = userPasswordDAO.findByCreatedByUserDetails(userDetailsDAO.findById(userId).get());
		for(UserPassword userPassword:userPasswordList) {
			UserDetails userDetails = userPassword.getUserDetails();
			UserContacts userContacts = userContactsDAO.findByUserDetails(userDetails);
			List<ProjectAssignment> projectAssignmentList = projectAssignmentDAO.findByUserDetailsOrderByCompany(userDetails);
			for(ProjectAssignment projectAssignment : projectAssignmentList) {
				Employee e = new Employee(userDetails.getUserId(),userDetails.getFirstName(),userDetails.getLastName(),userPassword.getUserName(),
						userContacts.getEmailId(),userContacts.getPhoneNo(),projectAssignment.getCompany().getCompanyId(),projectAssignment.getCompany().getCompanyName(),
						projectAssignment.getProjectList().get(0).getProjectId(),projectAssignment.getProjectList().get(0).getProjectName(),
						projectAssignment.getProjectList().get(0).getProjectVendor(),projectAssignment.getManagerList().get(0).getManagerId(),
						projectAssignment.getManagerList().get(0).getManagerName(),userPassword.getCreatedByUserDetails().getUserId());
				employeeList.add(e);
			}
			
		}
		return employeeList;
	} 

	public StatusRes updateCompany(CompanyPojo company) {
		UserDetails userDetails = userDetailsDAO.findById(company.getUserId()).get();
		companyDAO.save(new Company(company.getCompanyId(),company.getCompanyName(),company.getCompanyAddress(),userDetails));
		return new StatusRes("success","000","ok",null);
	}

	
	private String getMd5(String input) { 
        try { 
            // Static getInstance method is called with hashing MD5 
            MessageDigest md = MessageDigest.getInstance("MD5"); 
            // digest() method is called to calculate message digest 
            //  of an input digest() return array of byte 
            byte[] messageDigest = md.digest(input.getBytes()); 
            // Convert byte array into signum representation 
            BigInteger no = new BigInteger(1, messageDigest); 
            // Convert message digest into hex value 
            String hashtext = no.toString(16); 
            while (hashtext.length() < 32) { 
                hashtext = "0" + hashtext; 
            } 
            return hashtext; 
        }  
        // For specifying wrong message digest algorithms 
        catch (NoSuchAlgorithmException e) { 
            throw new RuntimeException(e); 
        } 
    }

	public UserDashboardData userDashboard(Long userId) {
		UserDashboardData userDashboardData = new UserDashboardData();
		userDashboardData.setCountOfPendingTimesheets(userTimeSheetDAO.countOfPendingTimesheets(userId));
		userDashboardData.setCountOfAcceptedTimesheets(userTimeSheetDAO.countOfAcceptedTimesheets(userId));
		userDashboardData.setCountOfRejectedTimesheets(userTimeSheetDAO.countOfRejectedTimesheets(userId));
		return userDashboardData;
	}

	public List<UserStatusReportPojo> userStatusReport(Long userId) {
		List<UserStatusReportPojo> userStatusReportPojoList = new ArrayList<>();
		long noOfWeeks = 0;
		List<UserPassword> userPasswordList = userPasswordDAO.findByCreatedByUserDetails(userDetailsDAO.findById(userId).get());
		for(UserPassword userPassword : userPasswordList) {
			List<UserTimeSheet> userTimeSheetList = userTimeSheetDAO.findByUserDetails(userPassword.getUserDetails());
			int weeks = Weeks.weeksBetween(new DateTime(new Date()), new DateTime(userPassword.getCreatedDate())).getWeeks();
			for(UserTimeSheet userTimeSheet : userTimeSheetList) {
				if(userTimeSheet.getRefStatus().getValue() == "Rejected") {
					noOfWeeks++;
				}
			}
			if(userTimeSheetList.size() < weeks) {
				String companyName = null;
				List<ProjectAssignment> projectAssignmentList = projectAssignmentDAO.findByUserDetailsOrderByCompany(userPassword.getUserDetails());
				for(ProjectAssignment projectAssignment : projectAssignmentList) {
					companyName = projectAssignment.getCompany().getCompanyName();
					noOfWeeks += weeks-userTimeSheetList.size();
					String name = userPassword.getUserDetails().getFirstName()+" "+userPassword.getUserDetails().getLastName();
					userStatusReportPojoList.add(new UserStatusReportPojo(userPassword.getUserDetails().getUserId(),name,companyName,userPassword.getCreatedDate().toString(),noOfWeeks));
				}
			}
		}
		return userStatusReportPojoList;
	}

	public List<ManagerStatusReportPojo> managerStatusReport(Long userId) {
		List<ManagerStatusReportPojo> managerStatusReportPojoList = new ArrayList<>();
		List<ProjectAssignment> projectAssignmentList = projectAssignmentDAO.findByAssignedUserDetailsOrderByCompany(userDetailsDAO.findById(userId));
		for(ProjectAssignment projectAssignment : projectAssignmentList) {
			List<Manager> managerList = projectAssignment.getManagerList();
			for(Manager manager : managerList) {
				RefStatus refStatus = refStatusDAO.findByValue("Pending");
				List<UserTimeSheet> userTimeSheetList = userTimeSheetDAO.findByProjectAndRefStatus(manager.getProject(),refStatus);
				if(userTimeSheetList.size() > 0) {
					managerStatusReportPojoList.add(new ManagerStatusReportPojo(manager.getManagerId(),manager.getManagerName(),
							manager.getProject().getCompany().getCompanyName(),manager.getProject().getProjectName(),
							manager.getProject().getProjectVendor(),userTimeSheetList.size()));
				}
			}
		}
		return managerStatusReportPojoList;
	}

	public List<Project> getProjectlist(Long userId) {
		List<Project> projectList = new ArrayList<>();
		List<ProjectAssignment> projectAssignmentList = projectAssignmentDAO.findByUserDetailsOrderByCompany(userDetailsDAO.findById(userId).get());
		for(ProjectAssignment projectAssignment : projectAssignmentList) {
			projectList.addAll(projectAssignment.getProjectList());
		}
		return projectList;
	}

	
}
