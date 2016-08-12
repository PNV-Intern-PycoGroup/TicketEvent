package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import pnv.intern.pyco.ticketevent.services.model.EventModel;

public interface EventService {

	public EventModel getEventById(Long id);
	public EventModel getEventByPath(String path);
	public EventModel saveEvent(EventModel event);
	public EventModel updateEvent(EventModel event);
	public void deleteEvent(EventModel event);
	public boolean isExitEvent(Long eventId, Long accountId);
	public List<EventModel> getAllEvent();
	public List<EventModel> getLastestEvent();
	public void deleteEventNotAccept(EventModel eventModel);
	public void acceptEvent(EventModel eventModel);
	public List<EventModel> getTotalEventOfYear(int year);
	public Object[] getTotal(int year);
	public Object[] getYears();
	public Object[] getTotalByDateOfEvent(int eventId);
	public Integer counterEventByYear(int year);
	
	public List<EventModel> getEventsByUser();
	public List<EventModel> getEventPassedByUser();
	public List<EventModel> getEventNotAcceptByUser();

	public List<EventModel> getEventSlide(int eventNumbers);
	public List<EventModel> getAllEventIsAccept();
}
