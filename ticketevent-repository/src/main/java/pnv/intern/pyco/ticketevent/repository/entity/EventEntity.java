package pnv.intern.pyco.ticketevent.repository.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pnv.intern.pyco.ticketevent.repository.util.DatabaseConstantUtil;

@Entity
@Table(name = DatabaseConstantUtil.EVENT_TABLE)
public class EventEntity {
	@Id
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_ID)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_NAME)
	private String name;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_INTRODUCTION)
	private String introduction;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.EVENT_FIELD_TYPE_ID)
	private EventTypeEntity eventType;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.EVENT_FIELD_ACCOUNT_ID)
	private AccountEntity account;
	
	@ManyToOne
	@JoinColumn(name = DatabaseConstantUtil.EVENT_FIELD_LAYOUT_ID)
	private EventLayoutEntity eventLayout;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_CREATE_DATE)
	private Date createDate;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_START_DATE)
	private Date startDate;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_END_DATE)
	private Date endDate;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_PLACE)
	private String place;

	@Column(name = DatabaseConstantUtil.EVENT_FIELD_ORGANIZE_NAME)
	private String organizeName;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_ORGANIZE_LOGO)
	private String organizeLogo;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_EMAIL)
	private String email;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_PHONE_NUMBER)
	private String phoneNumber;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_ORGANIZE_INFO)
	private String organizeInfo;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_IS_PUBLIC)
	private int isPublic;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_IS_ACCEPT)
	private int isAccept;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_IMAGE_THUMBNAIL)
	private String imageThumbnail;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_PATH)
	private String path;
	
	@Column(name = DatabaseConstantUtil.EVENT_FIELD_CONFIRM_EMAIL)
	private String confirmEmail;
	
	@OneToMany(mappedBy = "event")
	private List<TicketEntity> listTicket;
	
	@OneToMany(mappedBy = "event")
	private List<CommentEntity> listComment;

	public EventEntity() {
		super();
	}

	public EventEntity(String name, EventTypeEntity eventType,
			AccountEntity account, EventLayoutEntity eventLayout,
			Date createDate, Date startDate, Date endDate, String place,
			String organizeName, String email, String phoneNumber,
			String organizeInfo, int isPublic, int isAccept,
			String imageThumbnail) {
		super();
		this.name = name;
		this.eventType = eventType;
		this.account = account;
		this.eventLayout = eventLayout;
		this.createDate = createDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.organizeName = organizeName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.organizeInfo = organizeInfo;
		this.isPublic = isPublic;
		this.isAccept = isAccept;
		this.imageThumbnail = imageThumbnail;
	}

	public EventEntity(Long id, String name, EventTypeEntity eventType,
			AccountEntity account, EventLayoutEntity eventLayout,
			Date createDate, Date startDate, Date endDate, String place,
			String organizeName, String email, String phoneNumber,
			String organizeInfo, int isPublic, int isAccept,
			String imageThumbnail) {
		super();
		this.id = id;
		this.name = name;
		this.eventType = eventType;
		this.account = account;
		this.eventLayout = eventLayout;
		this.createDate = createDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.place = place;
		this.organizeName = organizeName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.organizeInfo = organizeInfo;
		this.isPublic = isPublic;
		this.isAccept = isAccept;
		this.imageThumbnail = imageThumbnail;
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

	public EventTypeEntity getEventType() {
		return eventType;
	}

	public void setEventType(EventTypeEntity eventType) {
		this.eventType = eventType;
	}

	public AccountEntity getAccount() {
		return account;
	}

	public void setAccount(AccountEntity account) {
		this.account = account;
	}

	public EventLayoutEntity getEventLayout() {
		return eventLayout;
	}

	public void setEventLayout(EventLayoutEntity eventLayout) {
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

	public List<TicketEntity> getListTicket() {
		return listTicket;
	}

	public void setListTicket(List<TicketEntity> listTicket) {
		this.listTicket = listTicket;
	}

	public List<CommentEntity> getListComment() {
		return listComment;
	}

	public void setListComment(List<CommentEntity> listComment) {
		this.listComment = listComment;
	}
	
}
