package pnv.intern.pyco.ticketevent.services.model;


public class MailConfigModel {

	private Long id;
	
	private String mailHost;
	
	private String userName;
	
	private String emailPass;
	
	private Integer mailPort;

	
	public MailConfigModel() {
	}


	public MailConfigModel(Long id, String mailHost, String userName,
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
