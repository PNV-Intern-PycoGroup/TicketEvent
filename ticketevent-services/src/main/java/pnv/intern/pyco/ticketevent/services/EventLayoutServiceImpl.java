package pnv.intern.pyco.ticketevent.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.EventLayoutRespository;
import pnv.intern.pyco.ticketevent.repository.entity.EventLayoutEntity;
import pnv.intern.pyco.ticketevent.services.converter.EventLayoutConverter;
import pnv.intern.pyco.ticketevent.services.model.EventLayoutModel;

@Service
public class EventLayoutServiceImpl implements EventLayoutService {

	@Autowired
	private EventLayoutRespository eventLayoutRespository;
	
	@Override
	public ArrayList<EventLayoutModel> getListEventLayout() {
		ArrayList<EventLayoutModel> listEventLayoutModel = new ArrayList<EventLayoutModel>();
		List<EventLayoutEntity> liEventLayoutEntity = eventLayoutRespository.findAll();
		
		for (EventLayoutEntity eventLayoutEntity : liEventLayoutEntity) {
			listEventLayoutModel.add(EventLayoutConverter.convertEventLayoutEntityToEventLayoutModel(eventLayoutEntity));
		}
		
		return listEventLayoutModel;
	}

}
