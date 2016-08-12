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
@Table(name = DatabaseConstantUtil.TICKET_ORDER_TABLE)
public class TicketOrderEntity {
	@Id
	@Column(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_TICKET_ID)
	private TicketEntity ticket;

	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_TICKET_BUYER_ID)
	private TicketBuyerEntity ticketBuyer;

	@Column(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_QUATITY)
	private int quantity;

	@Column(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_BUY_DATE)
	private Date buyDate;

	@Column(name = DatabaseConstantUtil.TICKET_ORDER_FIELD_STATUS)
	private int status;

	public TicketOrderEntity() {
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

	public TicketBuyerEntity getTicketBuyer() {
		return ticketBuyer;
	}

	public void setTicketBuyer(TicketBuyerEntity ticketBuyer) {
		this.ticketBuyer = ticketBuyer;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
