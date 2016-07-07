package pnv.intern.pyco.ticketevent.services.model;

public class MusicLayoutModel {

	private Integer id;
	private Integer eventId;
	private String linkHighlight;
	private String imagePlace;
	
	public MusicLayoutModel() {}

	public MusicLayoutModel(Integer id, Integer eventId, String linkHighlight,
			String imagePlace) {
		this.id = id;
		this.eventId = eventId;
		this.linkHighlight = linkHighlight;
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

	public String getLinkHighlight() {
		return linkHighlight;
	}

	public void setLinkHighlight(String linkHighlight) {
		this.linkHighlight = linkHighlight;
	}

	public String getImagePlace() {
		return imagePlace;
	}

	public void setImagePlace(String imagePlace) {
		this.imagePlace = imagePlace;
	}
	
	
	
}
