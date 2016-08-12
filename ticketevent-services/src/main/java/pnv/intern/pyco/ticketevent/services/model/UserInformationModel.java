package pnv.intern.pyco.ticketevent.services.model;

import java.util.Calendar;
import java.util.Date;

import pnv.intern.pyco.ticketevent.services.util.TimeUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserInformationModel {

	private Long id;

	private AccountModel account;

	private String name;

	private String address;

	private String phone;

	private String gender;

	private Date dateOfBirth;
	
	private String avatar;

	public UserInformationModel() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AccountModel getAccount() {
		return account;
	}

	public void setAccount(AccountModel account) {
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
	
	@JsonIgnore
	public String getDateOfBirthString() {
		String dateOfBirth = null;
		if (this.dateOfBirth != null) {
			Calendar instantEndDate = TimeUtil.convertDateToCalendar(this.dateOfBirth);
			int date = instantEndDate.get(Calendar.DATE);
			int month = (instantEndDate.get(Calendar.MONTH) + 1);
			int year = instantEndDate.get(Calendar.YEAR);
			dateOfBirth = date + "/" + month + "/" + year;
		}
		return dateOfBirth;
	}
}
