package pnv.intern.pyco.ticketevent.services;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;

public interface UserInformationService {
	public void saveUserInfor(AccountEntity accountEntity);
	public AccountEntity getAccount(UserInformationEntity userInformationEntity);
}
