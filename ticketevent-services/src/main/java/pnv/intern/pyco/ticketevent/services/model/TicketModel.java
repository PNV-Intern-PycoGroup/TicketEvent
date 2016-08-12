package pnv.intern.pyco.ticketevent.services.model;

import java.util.List;

public class TicketModel {
	
	private Long id;
	
	private EventModel event;
	
	private float price;
	
	private String name;
	
	private String description;
	
	private int isFree;
	
	private List<TicketOrderModel> listTicketOrder;
	
	private List<TicketBuyerModel> listTicketBuyer;

	public TicketModel() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventModel getEvent() {
		return event;
	}

	public void setEvent(EventModel event) {
		this.event = event;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getIsFree() {
		return isFree;
	}

	public void setIsFree(int isFree) {
		this.isFree = isFree;
	}

	public List<TicketOrderModel> getListTicketOrder() {
		return listTicketOrder;
	}

	public void setListTicketOrder(List<TicketOrderModel> listTicketOrder) {
		this.listTicketOrder = listTicketOrder;
	}

	public List<TicketBuyerModel> getListTicketBuyer() {
		return listTicketBuyer;
	}

	public void setListTicketBuyer(List<TicketBuyerModel> listTicketBuyer) {
		this.listTicketBuyer = listTicketBuyer;
	}

}
