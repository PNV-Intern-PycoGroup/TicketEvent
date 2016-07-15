package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import org.springframework.data.domain.Page;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;

public interface CommentService {
	public List<CommentEntity> getAllComment();
	public CommentEntity getCommentById(long id);
	public List<CommentEntity> getCommentByAccount(AccountEntity account);
	public List<CommentEntity> getCommentByEvent();
	public Page<CommentEntity> getAllCommentPaging(Integer pageNumber);
}
