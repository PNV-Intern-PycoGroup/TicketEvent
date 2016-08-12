package pnv.intern.pyco.ticketevent.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = DatabaseConstantUtil.USER_INFORMATION_TABLE)
public class UserInformationEntity {

	@Id
	@Column(name = DatabaseConstantUtil.USER_INFORMATION_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@OneToOne(mappedBy = "userInfor")
	private AccountEntity account;

	@Column(name = DatabaseConstantUtil.USER_INFORMATION_FIELD_NAME)
	private String name;

	@Column(name = DatabaseConstantUtil.USER_INFORMATION_FIELD_ADDRESS)
	private String address;

	@Column(name = DatabaseConstantUtil.USER_INFORMATION_FIELD_PHONE)
	private String phone;

	@Column(name = DatabaseConstantUtil.USER_INFORMATION_FIELD_GENDER)
	private String gender;

	@Column(name = DatabaseConstantUtil.USER_INFORMATION_FIELD_DATE_OF_BIRTH)
	private Date dateOfBirth;
	
	@Column(name = DatabaseConstantUtil.USER_INFORMATION_FIELD_AVATAR)
	private String avatar;

	public UserInformationEntity() {
		super();
	}

	public UserInformationEntity(AccountEntity account, String name,
			String address, String phone, String gender, Date dateOfBirth,
			String avatar) {
		super();
		this.account = account;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.avatar = avatar;
	}

	public UserInformationEntity(Long id, AccountEntity account, String name,
			String address, String phone, String gender, Date dateOfBirth,
			String avatar) {
		super();
		this.id = id;
		this.account = account;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.avatar = avatar;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
