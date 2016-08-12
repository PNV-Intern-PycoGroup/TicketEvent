package pnv.intern.pyco.ticketevent.services.converter;

import java.util.ArrayList;
import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;

public class CommentConverter {

	public static boolean IS_CONVERT;

	public static CommentModel convertCommentToCommentDTO(
			CommentEntity commentEntity) {
		IS_CONVERT = true;
		CommentModel commentModel = new CommentModel();
		commentModel.setId(commentEntity.getId());
		commentModel.setContent(commentEntity.getContent());
		commentModel.setCommentDate(commentEntity.getCommentDate());

		EventEntity eventEntity = commentEntity.getEvent();
		if (!EventConverter.IS_CONVERT && eventEntity != null) {
			commentModel.setEvent(EventConverter
					.convertEventEntityToEventModel(eventEntity));
		}

		AccountEntity accountEntity = commentEntity.getAccount();
		if(!AccountConverter.IS_CONVERT && accountEntity != null){
			commentModel.setAccount(AccountConverter.convertAccountEntityToAccountModel(accountEntity));
		}

		IS_CONVERT = false;
		return commentModel;
	}

	public static List<CommentModel> convertAllCommentsToDTO(List<CommentEntity> commentEntities) {
		IS_CONVERT = true;
		List<CommentModel> commentModels = null;
		if (commentEntities != null) {
			commentModels = new ArrayList<>();
			for (CommentEntity commentEntity : commentEntities) {
				commentModels.add(convertCommentToCommentDTO(commentEntity));
			}
		}
		IS_CONVERT = false;
		return commentModels;
	}
	
	public static CommentEntity convertDTOToCommentEntity(CommentModel commentModel){
		IS_CONVERT = true;
		CommentEntity commentEntity = null;
		if(commentModel != null){
			commentEntity = new CommentEntity();
			commentEntity.setId(commentModel.getId());
			commentEntity.setContent(commentModel.getContent());
			commentEntity.setCommentDate(commentModel.getCommentDate());
			
			if(!AccountConverter.IS_CONVERT && commentModel.getAccount() != null){
				commentEntity.setAccount(AccountConverter.convertDTOToAccountEntity(commentModel.getAccount()));
			}
			if(!EventConverter.IS_CONVERT && commentModel.getEvent() != null){
				commentEntity.setEvent(EventConverter.convertEventModelToEventEntity(commentModel.getEvent()));
			}
		}
		IS_CONVERT = false;
		return commentEntity;
	}
}
