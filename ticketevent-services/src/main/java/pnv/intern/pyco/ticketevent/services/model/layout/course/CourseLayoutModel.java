package pnv.intern.pyco.ticketevent.services.model.layout.course;

import java.util.List;

import pnv.intern.pyco.ticketevent.services.model.EventModel;

public class CourseLayoutModel {
	
	private Long id;
	
	private Long eventId;
	
	private String bannerImage;
	
	private String placeImage;
	
	private List<CourseLayoutContentModel> listCourseLayoutContent;
	
	private List<CourseLayoutSpeakerModel> listCourseLayoutSpeaker;
	
	//TODO
	// - Need change this function to get exactly Event
	public EventModel getEvent() {
		return new EventModel();
	}

	public CourseLayoutModel() {
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getBannerImage() {
		return bannerImage;
	}

	public void setBannerImage(String bannerImage) {
		this.bannerImage = bannerImage;
	}

	public String getPlaceImage() {
		return placeImage;
	}

	public void setPlaceImage(String placeImage) {
		this.placeImage = placeImage;
	}

	public List<CourseLayoutContentModel> getListCourseLayoutContent() {
		return listCourseLayoutContent;
	}

	public void setListCourseLayoutContent(
			List<CourseLayoutContentModel> listCourseLayoutContent) {
		this.listCourseLayoutContent = listCourseLayoutContent;
	}

	public List<CourseLayoutSpeakerModel> getListCourseLayoutSpeaker() {
		return listCourseLayoutSpeaker;
	}

	public void setListCourseLayoutSpeaker(
			List<CourseLayoutSpeakerModel> listCourseLayoutSpeaker) {
		this.listCourseLayoutSpeaker = listCourseLayoutSpeaker;
	}

}
