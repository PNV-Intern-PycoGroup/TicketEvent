package pnv.intern.pyco.ticketevent.repository.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.TICKET_BUYER_TABLE)
public class TicketBuyerEntity {
	@Id
	@Column(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_TICKET_ID)
	private TicketEntity ticket;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_ACCOUNT_ID)
	private AccountEntity account;
	
	@Column(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_NAME)
	private String name;

	@Column(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_ADDRESS)
	private String address;

	@Column(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_PHONE)
	private String phone;

	@Column(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_GENDER)
	private String gender;

	@Column(name = DatabaseConstantUtil.TICKET_BUYER_FIELD_DATE_OF_BIRTH)
	private Date dateOfBirth;

	public TicketBuyerEntity(Long id, TicketEntity ticket,
			AccountEntity account, String name, String address, String phone,
			String gender, Date dateOfBirth) {
		super();
		this.id = id;
		this.ticket = ticket;
		this.account = account;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public TicketBuyerEntity(TicketEntity ticket, AccountEntity account,
			String name, String address, String phone, String gender,
			Date dateOfBirth) {
		super();
		this.ticket = ticket;
		this.account = account;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
	}

	public TicketBuyerEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TicketEntity getTicket() {
		return ticket;
	}

	public void setTicket(TicketEntity ticket) {
		this.ticket = ticket;
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
	
}
