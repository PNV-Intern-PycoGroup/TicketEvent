package pnv.intern.pyco.ticketevent.services.converter;

import org.springframework.stereotype.Component;

import pnv.intern.pyco.ticketevent.repository.entity.UserRoleEntity;
import pnv.intern.pyco.ticketevent.services.model.UserRoleModel;

@Component
public class UserRoleConverter {
	public UserRoleConverter(){};
	
	public UserRoleModel convertFromUserRoleEntity(UserRoleEntity userRoleEntity){
		UserRoleModel uModel = new UserRoleModel();
		uModel.setId(userRoleEntity.getId());
		uModel.setRole(userRoleEntity.getRole());
		return uModel;
	}
}
