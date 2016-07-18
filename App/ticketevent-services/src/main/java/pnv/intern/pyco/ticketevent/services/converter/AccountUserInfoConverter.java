package pnv.intern.pyco.ticketevent.services.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.stereotype.Component;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;
import pnv.intern.pyco.ticketevent.services.model.UserInformationModel;

@Component
public class AccountUserInfoConverter {
	public static boolean IS_CONVERT;
	
	public AccountUserInfoConverter(){
	};
	
	public static UserInformationModel convertFromUserInforEntity(UserInformationEntity userInformationEntity){
		IS_CONVERT = true;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		UserInformationModel uInformationModel = new UserInformationModel();
		AccountEntity accountEntity = userInformationEntity.getAccount();
		uInformationModel.setId(userInformationEntity.getId());
		uInformationModel.setName(userInformationEntity.getName());
		uInformationModel.setAddress(userInformationEntity.getAddress());
		uInformationModel.setPhone(userInformationEntity.getPhone());
		uInformationModel.setGender(userInformationEntity.getGender());
		uInformationModel.setDateOfBirth(df.format(userInformationEntity.getDateOfBirth()));
		uInformationModel.setAvatar(userInformationEntity.getAvatar());
		if(!AccountConverter.IS_CONVERT && accountEntity != null){
			uInformationModel.setAccount(AccountConverter.convertAccountEntityToAccountModel(accountEntity));
		}
		IS_CONVERT = false;
		return uInformationModel;
	}
}
