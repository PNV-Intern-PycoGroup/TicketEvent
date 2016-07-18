package pnv.intern.pyco.ticketevent.services.model;

import java.util.Set;

public class TicketModel {
	
	private Long id;
	
	private EventModel event;
	
	private float price;
	
	private String name;
	
	private String description;
	
	private Set<TicketBuyerModel> listTicketBuyer;

	public TicketModel() {
		// TODO Auto-generated constructor stub
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

	public Set<TicketBuyerModel> getListTicketBuyer() {
		return listTicketBuyer;
	}

	public void setListTicketBuyer(Set<TicketBuyerModel> listTicketBuyer) {
		this.listTicketBuyer = listTicketBuyer;
	}

}
