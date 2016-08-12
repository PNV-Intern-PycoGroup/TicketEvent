package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;

public class TicketOrderModel {
	private Long id;

	private TicketModel ticket;

	private TicketBuyerModel ticketBuyer;

	private int quantity;

	private Date buyDate;

	private int status;

	public TicketOrderModel() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TicketModel getTicket() {
		return ticket;
	}

	public void setTicket(TicketModel ticket) {
		this.ticket = ticket;
	}

	public TicketBuyerModel getTicketBuyer() {
		return ticketBuyer;
	}

	public void setTicketBuyer(TicketBuyerModel ticketBuyer) {
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
