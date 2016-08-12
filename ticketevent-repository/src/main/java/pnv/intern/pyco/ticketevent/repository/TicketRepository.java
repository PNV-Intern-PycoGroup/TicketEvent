package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import pnv.intern.pyco.ticketevent.repository.entity.TicketEntity;

public interface TicketRepository extends JpaRepository<TicketEntity, Long>{
	@Modifying  
	@Transactional
	@Query("DELETE FROM TicketEntity e WHERE e.event.id = ?1")
	void deleteTickets(long eventId);
}
