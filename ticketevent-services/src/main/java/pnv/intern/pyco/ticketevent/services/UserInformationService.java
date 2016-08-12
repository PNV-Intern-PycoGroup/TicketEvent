package pnv.intern.pyco.ticketevent.services;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

public interface UserInformationService {
	public void saveUserInfor(UserInformationEntity accountEntity);
	public AccountEntity getAccount(UserInformationEntity userInformationEntity);
	public UserInformationEntity handleBeforeEditProfile(AccountUserInfoModel account);
}
