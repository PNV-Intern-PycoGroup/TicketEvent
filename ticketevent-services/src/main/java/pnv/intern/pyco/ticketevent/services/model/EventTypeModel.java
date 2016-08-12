package pnv.intern.pyco.ticketevent.services.model;

import java.util.List;

public class EventTypeModel {
	
	private Long id;

	private String name;
	
	private List<EventModel> listEvent;
	
	public EventTypeModel() {
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

	public List<EventModel> getListEvent() {
		return listEvent;
	}

	public void setListEvent(List<EventModel> listEvent) {
		this.listEvent = listEvent;
	}

}
