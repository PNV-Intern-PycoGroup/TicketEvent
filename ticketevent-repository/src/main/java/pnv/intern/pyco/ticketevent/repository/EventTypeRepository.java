package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.repository.entity.EventTypeEntity;

public interface EventTypeRepository extends JpaRepository<EventTypeEntity, Long> {

}
