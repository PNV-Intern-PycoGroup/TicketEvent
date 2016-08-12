package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.repository.entity.CommentEntity;

public interface CommentReponsitory extends JpaRepository<CommentEntity, Long>{

}
