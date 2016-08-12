package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.CommentReponsitory;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;
import pnv.intern.pyco.ticketevent.services.converter.CommentConverter;
import pnv.intern.pyco.ticketevent.services.model.CommentModel;

@Service
public class CommentServiceImpl implements CommentService{
	
	//private static final int MAX_PAGE_SIZE = 15;
	
	@Autowired
	private CommentReponsitory commentRepository;

	public CommentServiceImpl() {
	}

	public CommentServiceImpl(CommentReponsitory commentRepository) {
		this.commentRepository = commentRepository;
	}

	@Override
	public List<CommentModel> getAllComment() {
		List<CommentEntity> allComment = commentRepository.findAll();
		List<CommentModel> commentModels = null;
		if(allComment != null){
			commentModels = CommentConverter.convertAllCommentsToDTO(allComment);
		}
		return commentModels;
	}

	@Override
	public CommentModel getCommentById(long id) {
		CommentEntity commentEntity = commentRepository.findOne(id);
		CommentModel commentModel = null;
		if(commentEntity != null){
			commentModel = CommentConverter.convertCommentToCommentDTO(commentEntity);
		}
		return commentModel;
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

//	@Override
//	public Page<CommentModel> getAllCommentPaging(Integer pageNumber) {
//		PageRequest request = new PageRequest(pageNumber - 1, MAX_PAGE_SIZE, Sort.Direction.DESC, "commentDate");
//		Page<CommentEntity> commentEntities = commentRepository.findAll(request);
//		List<CommentModel> commentModels = CommentConverter.convertAllCommentsToDTO(commentEntities.getContent());
//		return new PageImpl<>(commentModels, request, commentEntities.getTotalElements());
//	}

	@Override
	public void deleteCommentByID(long id) {
		commentRepository.delete(id);		
	}
	
	@Override
	public void deleteComment(CommentModel commentModel) {
		commentRepository.delete(CommentConverter.convertDTOToCommentEntity(commentModel));		
	}

	@Override
	public CommentModel save(CommentModel comment) {
		CommentModel result = null;
		if (comment != null) {
			CommentEntity commentEntity = commentRepository.save(CommentConverter.convertDTOToCommentEntity(comment));
			result = CommentConverter.convertCommentToCommentDTO(commentEntity);
		}
		return result;
	}

}
