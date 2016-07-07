package pnv.intern.pyco.ticketevent.services.model;

public class TicketModel {

	private Integer id;
	private Integer eventId;
	private double price;
	private String name;
	private String description;
	
	public TicketModel() {}

	public TicketModel(Integer id, Integer eventId, double price, String name,
			String description) {
		this.id = id;
		this.eventId = eventId;
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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
	
	
	
}
