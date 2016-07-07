package pnv.intern.pyco.ticketevent.services.model;

public class FreeLayoutModel {

	private Integer id;
	private Integer eventId;
	private String content;
	
	public FreeLayoutModel() {}

	public FreeLayoutModel(Integer id, Integer eventId, String content) {
		this.id = id;
		this.eventId = eventId;
		this.content = content;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
