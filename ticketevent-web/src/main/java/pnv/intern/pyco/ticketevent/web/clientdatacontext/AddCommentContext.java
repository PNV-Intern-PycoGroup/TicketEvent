package pnv.intern.pyco.ticketevent.web.clientdatacontext;

import java.util.Date;

public class AddCommentContext {
	private Long userId;
	private String avatar;
	private Date commentDate;
	private String userName;
	private String nameUserInfo;
	private String content;
	public AddCommentContext() {
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public Date getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getNameUserInfo() {
		return nameUserInfo;
	}
	public void setNameUserInfo(String nameUserInfo) {
		this.nameUserInfo = nameUserInfo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
