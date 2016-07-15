package pnv.intern.pyco.ticketevent.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;


public interface AccountReponsitoty extends JpaRepository<AccountEntity, Long>{
	 @Query("SELECT u FROM AccountEntity u WHERE u.isActive = 1 and u.userName = ?1")
	 AccountEntity findAccountByUserName(final String user_name);
	 
	 @Query("SELECT u FROM AccountEntity u WHERE u.userRole.id = 2")
	 List<AccountEntity> getAllUser();
	 
	 @Query("SELECT u FROM AccountEntity u WHERE u.userRole.id = 2 order by u.activeDate DESC")
	 Page<AccountEntity> getAllUserNotAdmin(Pageable pageable);
}
