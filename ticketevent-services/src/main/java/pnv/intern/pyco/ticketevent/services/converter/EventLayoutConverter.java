package pnv.intern.pyco.ticketevent.services.converter;

import pnv.intern.pyco.ticketevent.repository.entity.EventLayoutEntity;
import pnv.intern.pyco.ticketevent.services.model.EventLayoutModel;

public class EventLayoutConverter {

	public static boolean IS_CONVERT;
	
	public EventLayoutConverter() {
		// TODO Auto-generated constructor stub
	}

	public static EventLayoutModel convertEventLayoutEntityToEventLayoutModel(EventLayoutEntity eventLayoutEntity) {
		IS_CONVERT = true;
		
		EventLayoutModel eventLayoutModel = new EventLayoutModel();
		
		eventLayoutModel.setId(eventLayoutEntity.getId());
		eventLayoutModel.setName(eventLayoutEntity.getName());
		
		IS_CONVERT = false;
		return eventLayoutModel;
	}

	public static EventLayoutEntity convertEventLayoutModelToEventLayoutEntity(EventLayoutModel eventLayoutModel) {
		IS_CONVERT = true;
		
		EventLayoutEntity eventLayoutEntity =  new EventLayoutEntity();
		
		eventLayoutEntity.setId(eventLayoutModel.getId());
		eventLayoutEntity.setName(eventLayoutModel.getName());
		
		IS_CONVERT = false;
		return eventLayoutEntity;
	}
}
