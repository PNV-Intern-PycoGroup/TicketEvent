package pnv.intern.pyco.ticketevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pnv.intern.pyco.ticketevent.repository.entity.UserRoleEntity;

public interface UserRoleReponsitory extends JpaRepository<UserRoleEntity, Long>{

}
