package pnv.intern.pyco.ticketevent.services.model;

public class CourseLayoutModel {

	private Integer id;
	private Integer eventId;
	private String bannerImage;
	private String imagePlace;
	
	public CourseLayoutModel() {}

	public CourseLayoutModel(Integer id, Integer eventId, String bannerImage,
			String imagePlace) {
		this.id = id;
		this.eventId = eventId;
		this.bannerImage = bannerImage;
		this.imagePlace = imagePlace;
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

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public String getImagePlace() {
		return imagePlace;
	}

	public void setImagePlace(String imagePlace) {
		this.imagePlace = imagePlace;
	}
	
}
