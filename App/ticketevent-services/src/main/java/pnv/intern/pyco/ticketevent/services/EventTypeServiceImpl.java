package pnv.intern.pyco.ticketevent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.EventTypeRepository;
import pnv.intern.pyco.ticketevent.repository.entity.EventTypeEntity;
import pnv.intern.pyco.ticketevent.services.converter.EventTypeConverter;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;

@Service
public class EventTypeServiceImpl implements EventTypeService {
	
	@Autowired
	private EventTypeRepository eventTypeRepository;

	@Override
	public EventTypeModel getEventTypeById(Long id) {
		EventTypeEntity eventTypeEntity = eventTypeRepository.findOne(id);
		EventTypeModel eventTypeModel = null;
		
		if (eventTypeEntity != null) {
			eventTypeModel = EventTypeConverter.convertEventTypeEntityToEventTypeModel(eventTypeEntity);
		}
		
		return eventTypeModel;
	}

	@Override
	public void saveEventType() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<EventTypeModel> getAllEventType() {
		List<EventTypeEntity> listEventTypeEntity = eventTypeRepository.findAll();
		ArrayList<EventTypeModel> listEventTypeModel = new ArrayList<EventTypeModel>();
		
		for (EventTypeEntity eventTypeEntity : listEventTypeEntity) {
			listEventTypeModel.add(EventTypeConverter.convertEventTypeEntityToEventTypeModel(eventTypeEntity));
		}
		
		return listEventTypeModel;
	}

}
