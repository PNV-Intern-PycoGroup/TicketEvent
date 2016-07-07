package pnv.intern.pyco.ticketevent.services.model;

import java.util.Date;

public class EventModel {

	private Integer id;
	private Integer typeId;
	private Integer accountId;
	private Integer layoutId;
	private Date createDate;
	private Date startDate;
	private Date endDate;
	private String address;
	private String organizeName;
	private String email;
	private String phone;
	private String organizeInfor;
	private Integer isPublic;
	private Integer isAccept;
	private String image;
	
	public EventModel() {}

	public EventModel(Integer id, Integer typeId, Integer accountId,
			Integer layoutId, Date createDate, Date startDate, Date endDate,
			String address, String organizeName, String email, String phone,
			String organizeInfor, Integer isPublic, Integer isAccept,
			String image) {
		this.id = id;
		this.typeId = typeId;
		this.accountId = accountId;
		this.layoutId = layoutId;
		this.createDate = createDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.address = address;
		this.organizeName = organizeName;
		this.email = email;
		this.phone = phone;
		this.organizeInfor = organizeInfor;
		this.isPublic = isPublic;
		this.isAccept = isAccept;
		this.image = image;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Integer getLayoutId() {
		return layoutId;
	}

	public void setLayoutId(Integer layoutId) {
		this.layoutId = layoutId;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrganizeName() {
		return organizeName;
	}

	public void setOrganizeName(String organizeName) {
		this.organizeName = organizeName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrganizeInfor() {
		return organizeInfor;
	}

	public void setOrganizeInfor(String organizeInfor) {
		this.organizeInfor = organizeInfor;
	}

	public Integer getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Integer isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(Integer isAccept) {
		this.isAccept = isAccept;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
}
