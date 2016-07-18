package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

	@Query("SELECT event FROM EventEntity event WHERE event.id = ?1 and event.account.id = ?2")
	EventEntity checkExistEventByAccount(final Long eventId, final Long accountId);
}
