package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;

public interface UserInformationReponsitory extends JpaRepository<UserInformationEntity, Long>{

}
