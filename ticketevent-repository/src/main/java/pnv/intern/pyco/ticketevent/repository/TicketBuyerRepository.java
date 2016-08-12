package pnv.intern.pyco.ticketevent.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.TicketBuyerEntity;

public interface TicketBuyerRepository extends JpaRepository<TicketBuyerEntity, Long>{
	@Query("SELECT ticketBuyer FROM TicketBuyerEntity ticketBuyer WHERE ticketBuyer.account.id = ?1")
	List<TicketBuyerEntity> getListTicketBuyerByAccount(final Long accountId);
}
