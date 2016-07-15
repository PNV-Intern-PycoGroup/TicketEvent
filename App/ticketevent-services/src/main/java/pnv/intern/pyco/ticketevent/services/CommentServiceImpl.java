package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.CommentReponsitory;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;

@Service
public class CommentServiceImpl implements CommentService{
	
	private static final int MAX_PAGE_SIZE = 15;
	
	@Autowired
	private CommentReponsitory commentRepository;

	public CommentServiceImpl() {
	}

	public CommentServiceImpl(CommentReponsitory commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public List<CommentEntity> getAllComment() {
		List<CommentEntity> allComment = commentRepository.findAll();
		return allComment;
	}

	@Override
	public CommentEntity getCommentById(long id) {
		CommentEntity commentEntity = commentRepository.findOne(id);
		return commentEntity;
	}

	@Override
	public List<CommentEntity> getCommentByAccount(AccountEntity account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentEntity> getCommentByEvent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<CommentEntity> getAllCommentPaging(Integer pageNumber) {
		 PageRequest request =
		            new PageRequest(pageNumber - 1, MAX_PAGE_SIZE, Sort.Direction.DESC, "commentDate");
		return commentRepository.findAll(request);
	}

}
