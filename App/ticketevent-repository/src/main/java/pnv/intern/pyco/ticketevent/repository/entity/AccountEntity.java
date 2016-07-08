package pnv.intern.pyco.ticketevent.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ACCOUNTS")
public class AccountEntity{
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name ="USER_NAME")
	private String user_name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "EMAIL")
	private String email;
	
	@ManyToOne
	@JoinColumn(name = "ROLE_ID")
	private UserRoleEntity user_role;
	
	@Column(name = "ISACTIVE")
	private int isActive;
	
	@Column(name = "ACTIVE_DATE")
	private Date active_date;

	@OneToOne
	@PrimaryKeyJoinColumn
	private UserInformationEntity userInfor;

	public AccountEntity() {
	}

	public AccountEntity(Long id, String user_name, String password,
			String email, UserRoleEntity user_role, int isActive,
			Date active_date, UserInformationEntity userInfor) {
		this.id = id;
		this.user_name = user_name;
		this.password = password;
		this.email = email;
		this.user_role = user_role;
		this.isActive = isActive;
		this.active_date = active_date;
		this.userInfor = userInfor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public UserRoleEntity getUser_role() {
		return user_role;
	}

	public void setUser_role(UserRoleEntity user_role) {
		this.user_role = user_role;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getActive_date() {
		return active_date;
	}

	public void setActive_date(Date active_date) {
		this.active_date = active_date;
	}

	public UserInformationEntity getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(UserInformationEntity userInfor) {
		this.userInfor = userInfor;
	}


	
	
	
}
