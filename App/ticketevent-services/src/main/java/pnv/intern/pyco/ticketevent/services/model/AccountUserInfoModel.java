package pnv.intern.pyco.ticketevent.services.model;

public class AccountUserInfoModel {
	private Long id;
	private String username;
	private String name;
	private String email;
	private String address;
	private String phone;
	//private Gender gender;
	private String birthday;
	private String avatar;
	
	public AccountUserInfoModel(Long id, String username, String name, String email, String address,
			String phone, String birthday, String avatar) {
		this.id = id;
		this.username = username;
		this.name = name;
		this.email = email;
		this.address = address;
		this.phone = phone;
		//this.gender = gender;
		this.birthday = birthday;
		this.avatar = avatar;
	}
	public AccountUserInfoModel() {
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
//	public Gender getGender() {
//		return gender;
//	}
//	public void setGender(Gender gender) {
//		this.gender = gender;
//	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}	
	
	
	
}
