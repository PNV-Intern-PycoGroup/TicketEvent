package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.repository.entity.MailConfigEntity;

public interface MailConfigRepository extends JpaRepository<MailConfigEntity, Long>{

}
