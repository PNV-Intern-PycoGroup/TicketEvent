package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.entity.AccountEntity;


public interface AccountReponsitoty extends JpaRepository<AccountEntity, Long>{

}
