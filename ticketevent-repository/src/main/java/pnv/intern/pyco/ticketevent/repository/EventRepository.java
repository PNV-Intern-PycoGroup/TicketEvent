package pnv.intern.pyco.ticketevent.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;

public interface EventRepository extends JpaRepository<EventEntity, Long> {

	@Query("SELECT event FROM EventEntity event WHERE event.id = ?1 and event.account.id = ?2")
	EventEntity checkExistEventByAccount(final Long eventId, final Long accountId);

	@Query("SELECT event FROM EventEntity event WHERE event.path = ?1")
	EventEntity getEventByPath(final String path);
	
	@Query("SELECT event FROM EventEntity event")
	Page<EventEntity> getLastestEvent(Pageable pageable);
	
	@Query("SELECT event FROM EventEntity event WHERE YEAR(event.createDate) = ?1")
	List<EventEntity> getTotalEventOfYear(int year);
	
	@Query(value ="SELECT month(e.create_date), SUM(((10/100*t.price)*tod.quantity)) as total FROM event as e, "
			+ "ticket as t, ticket_order as tod "
			+ "WHERE e.id = t.event_id AND t.id = tod.ticket_id "
			+ "AND YEAR(e.create_date) = ?1 "
			+ "GROUP BY month(e.create_date)", nativeQuery = true)
	Object[] getTotal(int year);
	
	@Query(value="SELECT YEAR(create_date) as Years FROM event GROUP BY YEAR(create_date) ORDER BY YEAR(create_date) DESC", nativeQuery = true)
	Object[] getYearActive();
	
	@Query(value = "SELECT * FROM event AS e WHERE e.account_id = ?1 AND e.is_accept = 1", nativeQuery = true)
	List<EventEntity> getEventPassedByUser(final long id);
	
	@Query(value = "SELECT * FROM event AS e WHERE e.account_id = ?1 AND e.is_accept = 0", nativeQuery = true)
	List<EventEntity> getEventNotAcceptByUser(final long id);
	
	@Query(value="SELECT buy_date, SUM((SELECT (90/100*t.price)*tod.quantity)) as total "
			+ "FROM ticket_order as tod, ticket as t, event as e "
			+ "WHERE e.id = t.event_id "
			+ "AND t.id = tod.ticket_id "
			+ "AND e.id = ?1 "
			+ "GROUP BY buy_date", nativeQuery = true)
	Object[] getTotalByDateOfEvent(int eventId);
	
	@Query(value = "SELECT * FROM event AS e WHERE e.is_accept = 1 ORDER BY e.start_date ASC", nativeQuery = true)
	List<EventEntity> getListEventisAccept();
	
	@Query(value = "SELECT * FROM event AS e WHERE e.is_accept = 1 ORDER BY e.start_date ASC LIMIT ?1 ", nativeQuery = true)
	List<EventEntity> getListEventSlide(int eventNumbers);
	
	@Query(value = "SELECT * FROM event as e, account as a WHERE e.account_id = a.id AND a.is_active = 1", nativeQuery = true)
	List<EventEntity> getAllEvent();
	
	@Modifying  
	@Transactional
	@Query("DELETE FROM EventEntity event WHERE event.id = ?1")
	void deleteEventNotAcceptById(long id);
}

