package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;

public class TicketBuyerModel {

	private Integer id;
	private Integer ticketId;
	private Integer accountId;
	private String name;
	private String address;
	private String phone;
	private String gender;
	private Date dateOfBirth;
	
	public TicketBuyerModel () {}

	public TicketBuyerModel(Integer id, Integer ticketId, Integer accountId,
			String name, String address, String phone, String gender,
			Date dateOfBirth) {
		this.id = id;
		this.ticketId = ticketId;
		this.accountId = accountId;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicketId() {
		return ticketId;
	}

	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
}
