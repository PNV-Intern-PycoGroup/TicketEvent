package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;

public class CommentModel {

	private Integer id;
	private Integer eventId;
	private Integer accountId;
	private String content;
	private Date commentDate;
	
	public CommentModel() {	}

	public CommentModel(Integer id, Integer eventId, Integer accountId,
			String content, Date commentDate) {
		this.id = id;
		this.eventId = eventId;
		this.accountId = accountId;
		this.content = content;
		this.commentDate = commentDate;
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

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
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
}
