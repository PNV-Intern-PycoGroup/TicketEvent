package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;

public class UserInforModel {
	
	private Integer id;
	private String name;
	private String address;
	private String phone;
	private String gender;
	private Date birthday;
	
	public UserInforModel () {}

	public UserInforModel(Integer id, String name, String address,
			String phone, String gender, Date birthday) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.birthday = birthday;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
