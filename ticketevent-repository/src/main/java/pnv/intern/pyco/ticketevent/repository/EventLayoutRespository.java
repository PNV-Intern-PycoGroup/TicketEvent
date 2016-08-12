package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.repository.entity.EventLayoutEntity;

public interface EventLayoutRespository extends JpaRepository<EventLayoutEntity, Long> {

}
