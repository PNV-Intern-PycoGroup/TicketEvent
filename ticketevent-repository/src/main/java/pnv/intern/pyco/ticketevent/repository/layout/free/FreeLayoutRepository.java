package pnv.intern.pyco.ticketevent.repository.layout.free;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.layout.free.FreeLayoutEntity;

public interface FreeLayoutRepository extends JpaRepository<FreeLayoutEntity, Long> {
	@Query("SELECT freeLayout FROM FreeLayoutEntity freeLayout WHERE freeLayout.eventId = ?1")
	FreeLayoutEntity findFreeLayoutByEventId(final Long eventId);
	
	@Query("SELECT freeLayout FROM FreeLayoutEntity freeLayout WHERE freeLayout.eventId = ?1 AND freeLayout.id = ?2")
	FreeLayoutEntity findFreeLayoutByEventIdAndFreeLayoutId(final Long eventId, final Long freeLayoutId);
}
