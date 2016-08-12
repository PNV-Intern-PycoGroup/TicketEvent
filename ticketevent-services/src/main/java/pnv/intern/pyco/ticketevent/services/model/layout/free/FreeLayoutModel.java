package pnv.intern.pyco.ticketevent.services.model.layout.free;

import java.util.Set;

public class FreeLayoutModel {
	
	private Long id;
	
	private Long eventId;
	
	private String content;
	
	private Set<FreeLayoutImageLibraryModel> listFreeLayoutImageLibrary;
	
	public FreeLayoutModel() {
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Set<FreeLayoutImageLibraryModel> getListFreeLayoutImageLibrary() {
		return listFreeLayoutImageLibrary;
	}

	public void setListFreeLayoutImageLibrary(
			Set<FreeLayoutImageLibraryModel> listFreeLayoutImageLibrary) {
		this.listFreeLayoutImageLibrary = listFreeLayoutImageLibrary;
	}
	
}
