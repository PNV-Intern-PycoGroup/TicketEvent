package pnv.intern.pyco.ticketevent.services.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.services.model.EventModel;

public class EventConverter {

	public EventConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public EventModel convertEventEntityToEventMode(EventEntity eventEntity) {
		EventModel eventModel = new EventModel();
		//19
		DateFormat dfDDMMYYYHHMM = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		eventModel.setId(eventEntity.getId());
		eventModel.setName(eventEntity.getName());
		eventModel.setIntroduction(eventEntity.getIntroduction());
		eventModel.setCreateDate(dfDDMMYYYHHMM.format(eventEntity.getCreateDate()));
		eventModel.setStartDate(dfDDMMYYYHHMM.format(eventEntity.getStartDate()));
		eventModel.setEndDate(dfDDMMYYYHHMM.format(eventEntity.getEndDate()));
		eventModel.setPlace(eventEntity.getPlace());
		eventModel.setOrganizeName(eventEntity.getOrganizeName());
		eventModel.setOrganizeInfo(eventEntity.getOrganizeInfo());
		eventModel.setPhoneNumber(eventEntity.getPhoneNumber());
		eventModel.setEmail(eventEntity.getEmail());
		eventModel.setImageThumbnail(eventEntity.getImageThumbnail());
		eventModel.setIsPublic(eventEntity.getIsPublic());
		eventModel.setIsAccept(eventEntity.getIsAccept());
//		eventModel.setEventType(eventEntity.getEventType());
//		eventModel.setEventLayout(eventEntity.getEventLayout());
//		eventModel.setAccount(eventEntity.getAccount());
//		eventModel.setListTicket(eventEntity.getListTicket());
//		eventModel.setListComment(eventEntity.getListComment());
		
		return eventModel;
	}
}
