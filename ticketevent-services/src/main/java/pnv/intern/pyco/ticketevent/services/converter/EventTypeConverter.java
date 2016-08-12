package pnv.intern.pyco.ticketevent.services.converter;

import java.util.ArrayList;
import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventTypeEntity;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;

public class EventTypeConverter {
	
	public static boolean IS_CONVERT;

	public EventTypeConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public static EventTypeModel convertEventTypeEntityToEventTypeModel(EventTypeEntity eventTypeEntity) {
		IS_CONVERT = true;
		
		EventTypeModel eventTypeModel = new EventTypeModel();
		
		eventTypeModel.setId(eventTypeEntity.getId());
		eventTypeModel.setName(eventTypeEntity.getName());
		
		List<EventEntity> listEventEntity = eventTypeEntity.getListEvent();
		if (!EventConverter.IS_CONVERT && listEventEntity != null) {
			List<EventModel> listEvent = new ArrayList<>();
			
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
		
		EventTypeEntity eventTypeEntity =  new EventTypeEntity();
		
		eventTypeEntity.setId(eventTypeModel.getId());
		eventTypeEntity.setName(eventTypeModel.getName());
		
		List<EventModel> listEventModel = eventTypeModel.getListEvent();
		if (!EventConverter.IS_CONVERT && listEventModel != null) {
			List<EventEntity> listEvent = new ArrayList<>();
			
			for (EventModel eventModel : listEventModel) {
				listEvent.add(EventConverter.convertEventModelToEventEntity(eventModel));
			}
			
			eventTypeEntity.setListEvent(listEvent);
		}
		
		IS_CONVERT = false;
		return eventTypeEntity;
	}
}
