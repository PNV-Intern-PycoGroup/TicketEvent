package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.repository.entity.TicketOrderEntity;

public interface TicketOrderRepository extends JpaRepository<TicketOrderEntity, Long>{
	
}
