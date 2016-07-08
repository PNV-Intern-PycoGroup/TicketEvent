package pnv.intern.pyco.ticketevent.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;


public interface AccountReponsitoty extends JpaRepository<AccountEntity, Long>{
	 @Query("SELECT u FROM AccountEntity u WHERE u.user_name = ?1")
	 AccountEntity findAccountByUserName(final String user_name);
}
