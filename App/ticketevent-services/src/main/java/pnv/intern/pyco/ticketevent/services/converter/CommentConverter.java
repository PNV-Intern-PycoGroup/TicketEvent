package pnv.intern.pyco.ticketevent.services.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;

public class CommentConverter {
	
	public static boolean IS_CONVERT;

	public CommentConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public static CommentModel convertCommentEntityToCommentModel(CommentEntity commentEntity) {
		IS_CONVERT = true;
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		CommentModel commentModel = new CommentModel();
		commentModel.setId(commentEntity.getId());
		commentModel.setContent(commentEntity.getContent());
		commentModel.setCommentDate(df.format(commentEntity.getCommentDate()));
		
		EventEntity eventEntity = commentEntity.getEvent();
		if (!EventConverter.IS_CONVERT && eventEntity != null) {
			commentModel.setEvent(EventConverter.convertEventEntityToEventModel(eventEntity));
		}
		
//		commentModel.setAccount(commentEntity.getAccount());
		
		IS_CONVERT = false;
		return commentModel;
	}
}
