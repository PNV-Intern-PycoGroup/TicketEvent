package pnv.intern.pyco.ticketevent.services.converter;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import pnv.intern.pyco.ticketevent.repository.EventTypeRepository;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventTypeEntity;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;

public class EventTypeConverter {
	
	public static boolean IS_CONVERT;
	
	@Autowired
	private static EventTypeRepository eventTypeRepository;

	public EventTypeConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public static EventTypeModel convertEventTypeEntityToEventTypeModel(EventTypeEntity eventTypeEntity) {
		IS_CONVERT = true;
		
		EventTypeModel eventTypeModel = new EventTypeModel();
		
		eventTypeModel.setId(eventTypeEntity.getId());
		eventTypeModel.setName(eventTypeEntity.getName());
		
		Set<EventEntity> listEventEntity = eventTypeEntity.getListEvent();
		if (!EventConverter.IS_CONVERT && listEventEntity != null) {
			Set<EventModel> listEvent = new HashSet<EventModel>();
			
			for (EventEntity eventEntity : listEventEntity) {
				listEvent.add(EventConverter.convertEventEntityToEventModel(eventEntity));
			}
			
			eventTypeModel.setListEvent(listEvent);
		}
		
		IS_CONVERT = false;
		return eventTypeModel;
	}
	
	public static EventTypeEntity convertEventTypeModelToEventTypeEntity(EventTypeModel eventTypeModel) {
		IS_CONVERT = true;
		
		EventTypeEntity eventTypeEntity = null;
		if (eventTypeModel.getId() != null) {
			eventTypeEntity = eventTypeRepository.findOne(eventTypeModel.getId());
		}
		
		if (eventTypeEntity == null) {
			eventTypeEntity = new EventTypeEntity();
		}
		
		eventTypeEntity.setId(eventTypeModel.getId());
		eventTypeEntity.setName(eventTypeModel.getName());
		
		Set<EventModel> listEventModel = eventTypeModel.getListEvent();
		if (!EventConverter.IS_CONVERT && listEventModel != null) {
			Set<EventEntity> listEvent = new HashSet<EventEntity>();
			
			for (EventModel eventModel : listEventModel) {
				listEvent.add(EventConverter.convertEventModelToEventEntity(eventModel));
			}
			
			eventTypeEntity.setListEvent(listEvent);
		}
		
		IS_CONVERT = false;
		return eventTypeEntity;
	}
}
