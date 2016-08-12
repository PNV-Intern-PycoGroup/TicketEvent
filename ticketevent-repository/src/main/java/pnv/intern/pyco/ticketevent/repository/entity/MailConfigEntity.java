package pnv.intern.pyco.ticketevent.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMAIL_CONFIG")
public class MailConfigEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="MAIL_HOST")
	private String mailHost;
	
	@Column(name="USERNAME")
	private String userName;
	
	@Column(name="EMAIL_PASSWORD")
	private String emailPass;
	
	@Column(name="MAIL_PORT")
	private Integer mailPort;

	
	public MailConfigEntity() {
	}


	public MailConfigEntity(Long id, String mailHost, String userName,
			String emailPass, Integer mailPort) {
		this.id = id;
		this.mailHost = mailHost;
		this.userName = userName;
		this.emailPass = emailPass;
		this.mailPort = mailPort;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getMailHost() {
		return mailHost;
	}


	public void setMailHost(String mailHost) {
		this.mailHost = mailHost;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmailPass() {
		return emailPass;
	}


	public void setEmailPass(String emailPass) {
		this.emailPass = emailPass;
	}


	public Integer getMailPort() {
		return mailPort;
	}


	public void setMailPort(Integer mailPort) {
		this.mailPort = mailPort;
	}
	
	
}
