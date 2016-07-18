package pnv.intern.pyco.ticketevent.repository.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.ACCOUNT_TABLE)
public class AccountEntity{
	
	@Id
	@Column(name = DatabaseConstantUtil.ACCOUNT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstantUtil.ACCOUNT_FIELD_USER_NAME)
	private String userName;
	
	@Column(name = DatabaseConstantUtil.ACCOUNT_FIELD_PASSWORD)
	private String password;
	
	@Column(name = DatabaseConstantUtil.ACCOUNT_FIELD_EMAIL)
	private String email;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.ACCOUNT_FIELD_ROLE_ID)
	private UserRoleEntity userRole;
	
	@Column(name = DatabaseConstantUtil.ACCOUNT_FIELD_IS_ACTIVE)
	private int isActive;
	
	@DateTimeFormat(pattern="dd.MM.yyyy hh:mm")
	@Column(name = DatabaseConstantUtil.ACCOUNT_FIELD_ACTIVE_DATE)
	private Date activeDate;

	@OneToOne
	@PrimaryKeyJoinColumn
	private UserInformationEntity userInfor;
	
	@OneToMany(mappedBy = "account")
	private Set<EventEntity> listEvent;

	public AccountEntity() {
		super();
	}

	public AccountEntity(String userName, String password, String email,
			UserRoleEntity userRole, int isActive, Date activeDate,
			UserInformationEntity userInfor) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
		this.isActive = isActive;
		this.activeDate = activeDate;
		this.userInfor = userInfor;
	}

	public AccountEntity(Long id, String userName, String password,
			String email, UserRoleEntity userRole, int isActive,
			Date activeDate, UserInformationEntity userInfor) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.userRole = userRole;
		this.isActive = isActive;
		this.activeDate = activeDate;
		this.userInfor = userInfor;
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

	public UserRoleEntity getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRoleEntity userRole) {
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

	public UserInformationEntity getUserInfor() {
		return userInfor;
	}

	public void setUserInfor(UserInformationEntity userInfor) {
		this.userInfor = userInfor;
	}

}
