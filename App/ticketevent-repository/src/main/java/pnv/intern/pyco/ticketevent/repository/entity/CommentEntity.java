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
@Table(name = DatabaseConstantUtil.COMMENT_TABLE)
public class CommentEntity {
	@Id
	@Column(name = DatabaseConstantUtil.COMMENT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.COMMENT_FIELD_EVENT_ID)
	private EventEntity event;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.COMMENT_FIELD_ACCOUNT_ID)
	private AccountEntity account;
	
	@Column(name = DatabaseConstantUtil.COMMENT_FIELD_CONTENT)
	private String content;
	
	@Column(name = DatabaseConstantUtil.COMMENT_FIELD_COMMENT_DATE)
	private Date commentDate;

	public CommentEntity() {
		super();
	}

	public CommentEntity(EventEntity event, AccountEntity account,
			String content, Date commentDate) {
		super();
		this.event = event;
		this.account = account;
		this.content = content;
		this.commentDate = commentDate;
	}

	public CommentEntity(Long id, EventEntity event, AccountEntity account,
			String content, Date commentDate) {
		super();
		this.id = id;
		this.event = event;
		this.account = account;
		this.content = content;
		this.commentDate = commentDate;
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

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
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

}
