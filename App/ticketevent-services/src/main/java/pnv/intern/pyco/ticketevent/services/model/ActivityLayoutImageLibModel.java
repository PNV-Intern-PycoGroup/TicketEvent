package pnv.intern.pyco.ticketevent.services.model;

public class ActivityLayoutImageLibModel {

	private Integer id;
	private Integer accountId;
	private String image;
	public ActivityLayoutImageLibModel(Integer id, Integer accountId,
			String image) {
		this.id = id;
		this.accountId = accountId;
		this.image = image;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
}
