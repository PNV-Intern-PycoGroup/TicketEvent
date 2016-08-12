package pnv.intern.pyco.ticketevent.services.converter;

import org.springframework.stereotype.Component;

import pnv.intern.pyco.ticketevent.repository.entity.UserRoleEntity;
import pnv.intern.pyco.ticketevent.services.model.UserRoleModel;

@Component
public class UserRoleConverter {

	static boolean IS_CONVERT;
	
	public static UserRoleModel convertFromUserRoleEntity(UserRoleEntity userRoleEntity){
		IS_CONVERT = true;
		UserRoleModel uModel = new UserRoleModel();
		uModel.setId(userRoleEntity.getId());
		uModel.setRole(userRoleEntity.getRole());
		
		IS_CONVERT = false;
		return uModel;
	}
}
