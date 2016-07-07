package pnv.intern.pyco.ticketevent.services.model;

public class ActivityLayoutModel {

	private Integer id;
	private Integer eventId;
	private String backgroundImage;
	private String eventLogo;
	private String sologan;
	
	public ActivityLayoutModel() {}

	public ActivityLayoutModel(Integer id, Integer eventId,
			String backgroundImage, String eventLogo, String sologan) {
		this.id = id;
		this.eventId = eventId;
		this.backgroundImage = backgroundImage;
		this.eventLogo = eventLogo;
		this.sologan = sologan;
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

	public String getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}

	public String getEventLogo() {
		return eventLogo;
	}

	public void setEventLogo(String eventLogo) {
		this.eventLogo = eventLogo;
	}

	public String getSologan() {
		return sologan;
	}

	public void setSologan(String sologan) {
		this.sologan = sologan;
	}
	
}
