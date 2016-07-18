package pnv.intern.pyco.ticketevent.services.model;

import java.util.Set;

public class EventTypeModel {
	
	private Long id;

	private String name;
	
	private Set<EventModel> listEvent;
	
	public EventTypeModel() {
		// TODO Auto-generated constructor stub
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

	public Set<EventModel> getListEvent() {
		return listEvent;
	}

	public void setListEvent(Set<EventModel> listEvent) {
		this.listEvent = listEvent;
	}

}
