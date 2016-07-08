package pnv.intern.pyco.ticketevent.repository.entity;

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
@Table(name = DatabaseConstantUtil.TICKET_TABLE)
public class TicketsEntity {
	@Id
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.TICKET_FIELD_EVENT_ID)
	private EventsEntity event;
	
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_PRICE)
	private float price;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_DESCRIPTION)
	private String description;

	public TicketsEntity() {
		super();
	}

	public TicketsEntity(EventsEntity event, float price, String name,
			String description) {
		super();
		this.event = event;
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public TicketsEntity(Long id, EventsEntity event, float price, String name,
			String description) {
		super();
		this.id = id;
		this.event = event;
		this.price = price;
		this.name = name;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventsEntity getEvent() {
		return event;
	}

	public void setEvent(EventsEntity event) {
		this.event = event;
	}

	public float getPrice() {
		return price;
	}

	public void setPrices(float price) {
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
