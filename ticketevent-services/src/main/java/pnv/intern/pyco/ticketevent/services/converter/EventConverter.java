package pnv.intern.pyco.ticketevent.services.converter;

import java.util.ArrayList;
import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventLayoutEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventTypeEntity;
import pnv.intern.pyco.ticketevent.repository.entity.TicketEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;
import pnv.intern.pyco.ticketevent.services.model.EventLayoutModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;
import pnv.intern.pyco.ticketevent.services.model.EventTypeModel;
import pnv.intern.pyco.ticketevent.services.model.TicketModel;

public class EventConverter {
	public static boolean IS_CONVERT;

	public EventConverter() {
	}

	public static EventModel convertEventEntityToEventModel(EventEntity eventEntity) {
		IS_CONVERT = true;
		
		EventModel eventModel = new EventModel();

		eventModel.setId(eventEntity.getId());
		eventModel.setName(eventEntity.getName());
		eventModel.setIntroduction(eventEntity.getIntroduction());
		eventModel.setCreateDate(eventEntity.getCreateDate());
		eventModel.setStartDate(eventEntity.getStartDate());
		eventModel.setEndDate(eventEntity.getEndDate());
		eventModel.setPlace(eventEntity.getPlace());
		eventModel.setOrganizeName(eventEntity.getOrganizeName());
		eventModel.setOrganizeInfo(eventEntity.getOrganizeInfo());
		eventModel.setOrganizeLogo(eventEntity.getOrganizeLogo());
		eventModel.setPhoneNumber(eventEntity.getPhoneNumber());
		eventModel.setEmail(eventEntity.getEmail());
		eventModel.setImageThumbnail(eventEntity.getImageThumbnail());
		eventModel.setPath(eventEntity.getPath());
		eventModel.setIsPublic(eventEntity.getIsPublic());
		eventModel.setIsAccept(eventEntity.getIsAccept());
		eventModel.setConfirmEmail(eventEntity.getConfirmEmail());

		EventTypeEntity eventTypeEntity = eventEntity.getEventType();
		if (!EventTypeConverter.IS_CONVERT  && eventTypeEntity != null) {
			eventModel.setEventType(EventTypeConverter.convertEventTypeEntityToEventTypeModel(eventTypeEntity));
		}
		
		EventLayoutEntity eventLayoutEntity = eventEntity.getEventLayout();
		if (!EventLayoutConverter.IS_CONVERT  && eventLayoutEntity != null) {
			eventModel.setEventLayout(EventLayoutConverter.convertEventLayoutEntityToEventLayoutModel(eventLayoutEntity));
		}

		AccountEntity accountEntity = eventEntity.getAccount();
		if (!EventLayoutConverter.IS_CONVERT  && accountEntity != null) {
			eventModel.setAccount(AccountConverter.convertAccountEntityToAccountModel(accountEntity));
		}
		
		List<TicketEntity> listTicketEntity = eventEntity.getListTicket();
		if (!TicketConverter.IS_CONVERT && listTicketEntity != null) {
			List<TicketModel> listTicketModel = new ArrayList<>();
			
			for (TicketEntity ticketEntity : listTicketEntity) {
				listTicketModel.add(TicketConverter.convertTicketEntityToTicketModel(ticketEntity));
			}
			
			eventModel.setListTicket(listTicketModel);
		}

		List<CommentEntity> listCommentEntity = eventEntity.getListComment();
		if (!CommentConverter.IS_CONVERT && listCommentEntity != null) {
			List<CommentModel> listCommentModel = new ArrayList<>();
			
			for (CommentEntity commentEntity : listCommentEntity) {
				listCommentModel.add(CommentConverter.convertCommentToCommentDTO(commentEntity));
			}
			
			eventModel.setListComment(listCommentModel);
		}
		
		IS_CONVERT = false;
		return eventModel;
	}

	public static EventEntity convertEventModelToEventEntity(EventModel eventModel) {
		IS_CONVERT = true;
		
		EventEntity eventEntity = new EventEntity();
		
		eventEntity.setId(eventModel.getId());
		eventEntity.setName(eventModel.getName());
		eventEntity.setIntroduction(eventModel.getIntroduction());
		eventEntity.setPlace(eventModel.getPlace());
		eventEntity.setOrganizeName(eventModel.getOrganizeName());
		eventEntity.setOrganizeLogo(eventModel.getOrganizeLogo());
		eventEntity.setOrganizeInfo(eventModel.getOrganizeInfo());
		eventEntity.setPhoneNumber(eventModel.getPhoneNumber());
		eventEntity.setEmail(eventModel.getEmail());
		eventEntity.setImageThumbnail(eventModel.getImageThumbnail());
		eventEntity.setIsPublic(eventModel.getIsPublic());
		eventEntity.setIsAccept(eventModel.getIsAccept());
		eventEntity.setCreateDate(eventModel.getCreateDate());
		eventEntity.setStartDate(eventModel.getStartDate());
		eventEntity.setEndDate(eventModel.getEndDate());
		eventEntity.setPath(eventModel.getPath());
		eventEntity.setConfirmEmail(eventModel.getConfirmEmail());
		
		EventTypeModel eventTypeModel = eventModel.getEventType();
		if (!EventTypeConverter.IS_CONVERT && eventTypeModel != null) {
			eventEntity.setEventType(EventTypeConverter.convertEventTypeModelToEventTypeEntity(eventTypeModel));
		}
		
		EventLayoutModel eventLayoutModel = eventModel.getEventLayout();
		if (!EventLayoutConverter.IS_CONVERT && eventLayoutModel != null) {
			eventEntity.setEventLayout(EventLayoutConverter.convertEventLayoutModelToEventLayoutEntity(eventLayoutModel));
		}

		AccountModel accountModel = eventModel.getAccount();
		if (!AccountConverter.IS_CONVERT && accountModel != null) {
			eventEntity.setAccount(AccountConverter.convertDTOToAccountEntity(accountModel));
		}
		
		IS_CONVERT = false;
		return eventEntity;
	}
}
