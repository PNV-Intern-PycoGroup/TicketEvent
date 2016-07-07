package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;


public class AccountModel {
	private Integer id;
	private String username;
	private String password;
	private String email;
	private Integer roleId;
	private Integer isActive;
	private Date dateActive;
	private String avatar;
	
	public AccountModel(){}

	public AccountModel(Integer id, String username, String password,
			String email, Integer roleId, Integer isActive, Date dateActive,
			String avatar) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.roleId = roleId;
		this.isActive = isActive;
		this.dateActive = dateActive;
		this.avatar = avatar;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getIsActive() {
		return isActive;
	}

	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	public Date getDateActive() {
		return dateActive;
	}

	public void setDateActive(Date dateActive) {
		this.dateActive = dateActive;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
