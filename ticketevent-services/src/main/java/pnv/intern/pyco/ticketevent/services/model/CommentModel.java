package pnv.intern.pyco.ticketevent.services.model;

import java.util.Calendar;
import java.util.Date;

import pnv.intern.pyco.ticketevent.services.util.TimeUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class CommentModel {
	private Long id;
	private EventModel event;
	private AccountModel account;
	private String content;
	private Date commentDate;
	public CommentModel() {
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
	public AccountModel getAccount() {
		return account;
	}
	public void setAccount(AccountModel account) {
		this.account = account;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	@JsonIgnore
	public String getCommentDateString() {
		String commentDateString = null;
		if (commentDate != null) {
			Calendar instantStartDate = TimeUtil.convertDateToCalendar(commentDate);
			int date = instantStartDate.get(Calendar.DATE);
			int month = (instantStartDate.get(Calendar.MONTH) + 1);
			int year = instantStartDate.get(Calendar.YEAR);
			commentDateString = date + "/" + month + "/" + year;
		}
		return commentDateString;
	}
}
