package pnv.intern.pyco.ticketevent.services.model;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import pnv.intern.pyco.ticketevent.services.util.TimeUtil;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class EventModel {
	private Long id;
	private String name;
	private String introduction;
	private EventTypeModel eventType;
	private AccountModel account;
	private EventLayoutModel eventLayout;
	private Date createDate;
	private Date startDate;
	private Date endDate;
	private String place;
	private String organizeName;
	private String organizeLogo;
	private String email;
	private String phoneNumber;
	private String organizeInfo;
	private int isPublic;
	private int isAccept;
	private String imageThumbnail;
	private String path;
	private String confirmEmail;
	private List<TicketModel> listTicket;
	private List<CommentModel> listComment;
	public EventModel() {
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
	public String getOrganizeLogo() {
		return organizeLogo;
	}
	public void setOrganizeLogo(String organizeLogo) {
		this.organizeLogo = organizeLogo;
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getConfirmEmail() {
		return confirmEmail;
	}
	public void setConfirmEmail(String confirmEmail) {
		this.confirmEmail = confirmEmail;
	}
	public List<TicketModel> getListTicket() {
		return listTicket;
	}
	public void setListTicket(List<TicketModel> listTicket) {
		this.listTicket = listTicket;
	}
	public List<CommentModel> getListComment() {
		return listComment;
	}
	public void setListComment(List<CommentModel> listComment) {
		this.listComment = listComment;
	}
	public boolean isFullInfo() {
		boolean result = id != null && name != null && introduction != null && eventType != null && startDate != null
				&& endDate != null && place != null && organizeName != null && organizeInfo != null && email != null
				&& phoneNumber != null;
		return result;
	}
	@JsonIgnore
	public String getAddress() {
		String address = null;
		if (place != null) {
			address = place.substring(0, place.lastIndexOf(","));
		}
		return address;
	}
	@JsonIgnore
	public String getCity() {
		String city = null;
		if (place != null) {
			city = place.substring(place.lastIndexOf(",") + 2);
		}
		return city;
	}
	@JsonIgnore
	public String getDateStartDate() {
		String dateStartDate = null;
		if (startDate != null) {
			Calendar instantStartDate = TimeUtil.convertDateToCalendar(startDate);
			int date = instantStartDate.get(Calendar.DATE);
			int month = (instantStartDate.get(Calendar.MONTH) + 1);
			int year = instantStartDate.get(Calendar.YEAR);
			dateStartDate = date + "/" + month + "/" + year;
		}
		return dateStartDate;
	}
	@JsonIgnore
	public String getHoursStartDate() {
		String hoursStartDate = null;
		if (startDate != null) {
			Calendar instantStartDate = TimeUtil.convertDateToCalendar(startDate);
			int hour = instantStartDate.get(Calendar.HOUR_OF_DAY);
			int minute = instantStartDate.get(Calendar.MINUTE);
			hoursStartDate = (hour < 10 ? "0" : "") + hour + ":" + (minute < 10 ? "0" : "") + minute ;
		}
		return hoursStartDate;
	}
	
	@JsonIgnore
	public String getDateEndDate() {
		String dateEndDate = null;
		if (endDate != null) {
			Calendar instantEndDate = TimeUtil.convertDateToCalendar(endDate);
			int date = instantEndDate.get(Calendar.DATE);
			int month = (instantEndDate.get(Calendar.MONTH) + 1);
			int year = instantEndDate.get(Calendar.YEAR);
			dateEndDate = date + "/" + month + "/" + year;
		}
		return dateEndDate;
	}
	@JsonIgnore
	public String getHoursEndDate() {
		String hoursEndDate = null;
		if (endDate != null) {
			Calendar instantEndDate = TimeUtil.convertDateToCalendar(endDate);
			int hour = instantEndDate.get(Calendar.HOUR_OF_DAY);
			int minute = instantEndDate.get(Calendar.MINUTE);
			hoursEndDate = (hour < 10 ? "0" : "") + hour + ":" + (minute < 10 ? "0" : "") + minute ;
		}
		return hoursEndDate;
	}
}
