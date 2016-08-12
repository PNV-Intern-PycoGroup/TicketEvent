package pnv.intern.pyco.ticketevent.repository.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.TICKET_TABLE)
public class TicketEntity {
	@Id
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = DatabaseConstantUtil.TICKET_FIELD_EVENT_ID)
	private EventEntity event;
	
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_PRICE)
	private float price;
	
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_NAME)
	private String name;
	
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_DESCRIPTION)
	private String description;
	
	@Column(name = DatabaseConstantUtil.TICKET_FIELD_IS_FREE)
	private int isFree;
	
	@OneToMany(mappedBy = "ticket")
	private List<TicketOrderEntity> listTicketOrder;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = DatabaseConstantUtil.TICKET_ORDER_TABLE, joinColumns = {
			@JoinColumn(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_TICKET_ID) },
			inverseJoinColumns = { @JoinColumn(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_TICKET_BUYER_ID) })
	private List<TicketBuyerEntity> listTicketBuyer;

	public TicketEntity() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EventEntity getEvent() {
		return event;
	}

	public void setEvent(EventEntity event) {
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

	public List<TicketOrderEntity> getListTicketOrder() {
		return listTicketOrder;
	}

	public void setListTicketOrder(List<TicketOrderEntity> listTicketOrder) {
		this.listTicketOrder = listTicketOrder;
	}

	public List<TicketBuyerEntity> getListTicketBuyer() {
		return listTicketBuyer;
	}

	public void setListTicketBuyer(List<TicketBuyerEntity> listTicketBuyer) {
		this.listTicketBuyer = listTicketBuyer;
	}
	
}
