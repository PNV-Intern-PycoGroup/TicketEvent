package pnv.intern.pyco.ticketevent.services;

import pnv.intern.pyco.ticketevent.services.model.EventModel;

public interface EventService {
	
	public EventModel getEventById(Long id);
	public void saveEvent(EventModel event);
	public void updateEvent(EventModel event);
	public void deleteEvent(EventModel event);
	public boolean isExitEvent(Long eventId, Long accountId);
}
