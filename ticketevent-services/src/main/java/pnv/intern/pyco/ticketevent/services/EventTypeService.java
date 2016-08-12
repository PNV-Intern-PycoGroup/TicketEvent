package pnv.intern.pyco.ticketevent.services;

import java.util.ArrayList;

import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;

public interface EventTypeService {
	
	public EventTypeModel getEventTypeById(Long id);
	public ArrayList<EventTypeModel> getAllEventType();
	public void saveEventType();
}
