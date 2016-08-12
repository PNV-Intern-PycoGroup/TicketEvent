package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;
import java.util.List;

public class AccountModel{
	
	private Long id;
	
	private String userName;
	
	private String password;
	
	private String email;
	
	private UserRoleModel userRole;
	
	private int isActive;
	
	private Date activeDate;

	private UserInformationModel userInfor;
	
	private List<EventModel> listEvent;

	public AccountModel() {
	}
	
	
	
	public AccountModel(Long id, String userName, String password,
			String email, UserRoleModel userRole, int isActive,
			Date activeDate, UserInformationModel userInfor,
			List<EventModel> listEvent) {
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
		this.isActive = isActive;
		this.activeDate = activeDate;
		this.userInfor = userInfor;
		this.listEvent = listEvent;
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

	public List<EventModel> getListEvent() {
		return listEvent;
	}

	public void setListEvent(List<EventModel> listEvent) {
		this.listEvent = listEvent;
	}

}
