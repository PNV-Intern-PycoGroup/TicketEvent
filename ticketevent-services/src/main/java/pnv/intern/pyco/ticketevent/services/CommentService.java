package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;

public interface CommentService {
	List<CommentModel> getAllComment();
	CommentModel getCommentById(long id);
	List<CommentEntity> getCommentByAccount(AccountEntity account);
	List<CommentEntity> getCommentByEvent();
	//Page<CommentModel> getAllCommentPaging(Integer pageNumber);
	void deleteCommentByID(long id);
	void deleteComment(CommentModel commentModel);
	public CommentModel save(CommentModel comment);
}
