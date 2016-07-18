package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;
import java.util.Set;

public class AccountModel{
	
	private Long id;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private UserRoleModel userRole;
	
	private int isActive;
	
	private Date activeDate;

	private UserInformationModel userInfor;
	
	private Set<EventModel> listEvent;

	public AccountModel() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserRoleModel getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleModel userRole) {
		this.userRole = userRole;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public UserInformationModel getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(UserInformationModel userInfor) {
		this.userInfor = userInfor;
	}

	public Set<EventModel> getListEvent() {
		return listEvent;
	}

	public void setListEvent(Set<EventModel> listEvent) {
		this.listEvent = listEvent;
	}

}
