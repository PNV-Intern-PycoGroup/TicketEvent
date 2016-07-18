package pnv.intern.pyco.ticketevent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.EventRepository;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.services.converter.EventConverter;
import pnv.intern.pyco.ticketevent.services.model.EventModel;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventRepository eventRespository;
	
	@Override
	public EventModel getEventById(Long id) {
		EventEntity eventEntity = eventRespository.getOne(id);
		EventModel eventModel = null;
		
		if (eventEntity != null) {
			eventModel = EventConverter.convertEventEntityToEventModel(eventEntity);
		}
		
		return eventModel;
	}

	@Override
	public void saveEvent(EventModel event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateEvent(EventModel event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEvent(EventModel event) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isExitEvent(Long eventId, Long accountId) {
		return eventRespository.checkExistEventByAccount(eventId, accountId) != null;
	}

}
