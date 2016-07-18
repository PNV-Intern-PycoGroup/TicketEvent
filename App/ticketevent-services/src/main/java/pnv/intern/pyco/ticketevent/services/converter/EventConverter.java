package pnv.intern.pyco.ticketevent.services.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import pnv.intern.pyco.ticketevent.repository.EventRepository;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventTypeEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketEntity;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;
import pnv.intern.pyco.ticketevent.services.model.EventLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;

public class EventConverter {

	public static boolean IS_CONVERT;
	
	@Autowired
	private static EventRepository eventRespository;
	
	public EventConverter() {
		// TODO Auto-generated constructor stub
	}

	public static EventModel convertEventEntityToEventModel(EventEntity eventEntity) {
		IS_CONVERT = true;
		
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

		EventTypeEntity eventTypeEntity = eventEntity.getEventType();
		if (!EventTypeConverter.IS_CONVERT  && eventTypeEntity != null) {
			eventModel.setEventType(EventTypeConverter.convertEventTypeEntityToEventTypeModel(eventTypeEntity));
		}
		
		EventLayoutEntity eventLayoutEntity = eventEntity.getEventLayout();
		if (!EventLayoutConverter.IS_CONVERT  && eventLayoutEntity != null) {
			eventModel.setEventLayout(EventLayoutConverter.convertEventLayoutEntityToEventLayoutModel(eventLayoutEntity));
		}
		
//		eventModel.setAccount(eventEntity.getAccount());
		
		Set<TicketEntity> listTicketEntity = eventEntity.getListTicket();
		if (!TicketConverter.IS_CONVERT && listTicketEntity != null) {
			Set<TicketModel> listTicketModel = new HashSet<TicketModel>();
			
			for (TicketEntity ticketEntity : listTicketEntity) {
				listTicketModel.add(TicketConverter.convertTicketEntityToTicketModel(ticketEntity));
			}
			
			eventModel.setListTicket(listTicketModel);
		}

		Set<CommentEntity> listCommentEntity = eventEntity.getListComment();
		if (!CommentConverter.IS_CONVERT && listCommentEntity != null) {
			Set<CommentModel> listCommentModel = new HashSet<CommentModel>();
			
			for (CommentEntity commentEntity : listCommentEntity) {
				listCommentModel.add(CommentConverter.convertCommentEntityToCommentModel(commentEntity));
			}
			
			eventModel.setListComment(listCommentModel);
		}
		
		IS_CONVERT = false;
		return eventModel;
	}

	public static EventEntity convertEventModelToEventEntity(EventModel eventModel) {
		IS_CONVERT = true;
		
		EventEntity eventEntity = null;
		if (eventModel.getId() != null) {
			eventEntity = eventRespository.getOne(eventModel.getId());
		}
		
		if (eventEntity == null) {
			eventEntity = new EventEntity();
		}
		
		DateFormat dfDDMMYYYHHMM = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		eventEntity.setId(eventModel.getId());
		eventEntity.setName(eventModel.getName());
		eventEntity.setIntroduction(eventModel.getIntroduction());
		eventEntity.setPlace(eventModel.getPlace());
		eventEntity.setOrganizeName(eventModel.getOrganizeName());
		eventEntity.setOrganizeInfo(eventModel.getOrganizeInfo());
		eventEntity.setPhoneNumber(eventModel.getPhoneNumber());
		eventEntity.setEmail(eventModel.getEmail());
		eventEntity.setImageThumbnail(eventModel.getImageThumbnail());
		eventEntity.setIsPublic(eventModel.getIsPublic());
		eventEntity.setIsAccept(eventModel.getIsAccept());
		
		try {
			eventEntity.setCreateDate(dfDDMMYYYHHMM.parse(eventModel.getCreateDate()));
		} catch (ParseException e) {}
		try {
			eventEntity.setStartDate(dfDDMMYYYHHMM.parse(eventModel.getStartDate()));
		} catch (ParseException e) {}
		try {
			eventEntity.setEndDate(dfDDMMYYYHHMM.parse(eventModel.getEndDate()));
		} catch (ParseException e) {}
		
		EventTypeModel eventTypeModel = eventModel.getEventType();
		if (!EventTypeConverter.IS_CONVERT && eventTypeModel != null) {
			eventEntity.setEventType(EventTypeConverter.convertEventTypeModelToEventTypeEntity(eventTypeModel));
		}
		
		EventLayoutModel eventLayoutModel = eventModel.getEventLayout();
		if (!EventLayoutConverter.IS_CONVERT && eventLayoutModel != null) {
			eventEntity.setEventLayout(EventLayoutConverter.convertEventLayoutModelToEventLayoutEntity(eventLayoutModel));
		}
		
		// account
		
		IS_CONVERT = false;
		return eventEntity;
	}
}
