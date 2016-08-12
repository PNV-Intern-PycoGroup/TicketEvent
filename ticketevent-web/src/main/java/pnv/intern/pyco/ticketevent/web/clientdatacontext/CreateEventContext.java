package pnv.intern.pyco.ticketevent.web.clientdatacontext;

import pnv.intern.pyco.ticketevent.services.model.EventModel;

public class CreateEventContext {
	private EventModel eventModel;
	private String imageThumbnail;
	private String imageOrganization;
	public CreateEventContext() {
	}
	public EventModel getEventModel() {
		return eventModel;
	}
	public void setEventModel(EventModel eventModel) {
		this.eventModel = eventModel;
	}
	public String getImageThumbnail() {
		return imageThumbnail;
	}
	public void setImageThumbnail(String imageThumbnail) {
		this.imageThumbnail = imageThumbnail;
	}
	public String getImageOrganization() {
		return imageOrganization;
	}
	public void setImageOrganization(String imageOrganization) {
		this.imageOrganization = imageOrganization;
	}
}
