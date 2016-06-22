package pnv.intern.pyco.ticketevent.services.model;

import org.hibernate.validator.constraints.NotEmpty;

public class UserModel {
	private String name;
	private int age;
	@NotEmpty
	private String address;
	
	public UserModel() {
		
	}
	
	public UserModel(String name, int age, String address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
