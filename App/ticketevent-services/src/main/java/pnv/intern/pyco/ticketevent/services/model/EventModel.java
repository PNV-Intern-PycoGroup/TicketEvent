package pnv.intern.pyco.ticketevent.services.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EventModel {
	
	private Long id;
	
	private String name;
	
	private String introduction;
	
	private EventTypeModel eventType;
	
	private AccountModel account;
	
	private EventLayoutModel eventLayout;
	
	private String createDate;
	
	private String startDate;
	
	private String endDate;
	
	private String place;
	
	private String organizeName;
	
	private String email;
	
	private String phoneNumber;
	
	private String organizeInfo;
	
	private int isPublic;
	
	private int isAccept;
	
	private String imageThumbnail;
	
	private Set<TicketModel> listTicket;
	
	private Set<CommentModel> listComment;

	public EventModel() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public EventTypeModel getEventType() {
		return eventType;
	}

	public void setEventType(EventTypeModel eventType) {
		this.eventType = eventType;
	}

	public AccountModel getAccount() {
		return account;
	}

	public void setAccount(AccountModel account) {
		this.account = account;
	}

	public EventLayoutModel getEventLayout() {
		return eventLayout;
	}

	public void setEventLayout(EventLayoutModel eventLayout) {
		this.eventLayout = eventLayout;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getOrganizeInfo() {
		return organizeInfo;
	}

	public void setOrganizeInfo(String organizeInfo) {
		this.organizeInfo = organizeInfo;
	}

	public int getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(int isPublic) {
		this.isPublic = isPublic;
	}

	public int getIsAccept() {
		return isAccept;
	}

	public void setIsAccept(int isAccept) {
		this.isAccept = isAccept;
	}

	public String getImageThumbnail() {
		return imageThumbnail;
	}

	public void setImageThumbnail(String imageThumbnail) {
		this.imageThumbnail = imageThumbnail;
	}

	public Set<TicketModel> getListTicket() {
		return listTicket;
	}

	public void setListTicket(Set<TicketModel> listTicket) {
		this.listTicket = listTicket;
	}

	public Set<CommentModel> getListComment() {
		return listComment;
	}

	public void setListComment(Set<CommentModel> listComment) {
		this.listComment = listComment;
	}

	@JsonIgnore
	public String getAddress() {
		String address = place.substring(0, place.lastIndexOf(","));
		return address;
	}

	@JsonIgnore
	public String getCity() {
		String city = place.substring(place.lastIndexOf(",") + 2);
		return city;
	}

}
