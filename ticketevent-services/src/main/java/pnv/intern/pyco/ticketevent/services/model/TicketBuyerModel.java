package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class TicketBuyerModel {
	
	private Long id;
	
	private AccountModel account;
	
	private String name;

	private String address;

	private String phone;

	private String gender;

	private Date dateOfBirth;
	
	private List<TicketOrderModel> listTicketOrder;

	public TicketBuyerModel() {
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

	public List<TicketOrderModel> getListTicketOrder() {
		return listTicketOrder;
	}

	public void setListTicketOrder(List<TicketOrderModel> listTicketOrder) {
		this.listTicketOrder = listTicketOrder;
	}

	@JsonIgnore
	public EventModel getOrderEvent(){
		EventModel result = null;
		if (listTicketOrder != null && listTicketOrder.size() > 0) {
			result = listTicketOrder.get(0).getTicket().getEvent();
		}
		return result;
	}

	@JsonIgnore
	public int getCountOrder(){
		int result = 0;
		for (TicketOrderModel ticketOrder : listTicketOrder) {
			result += ticketOrder.getQuantity();
		}
		return result;
	}

	@JsonIgnore
	public int getTotalPriceOrder(){
		int result = 0;
		for (TicketOrderModel ticketOrder : listTicketOrder) {
			result += ticketOrder.getQuantity() * ticketOrder.getTicket().getPrice();
		}
		return result;
	}
}
