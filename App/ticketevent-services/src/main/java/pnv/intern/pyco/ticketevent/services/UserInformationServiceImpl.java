package pnv.intern.pyco.ticketevent.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.UserInformationReponsitory;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;

@Service
public class UserInformationServiceImpl implements UserInformationService{

	@Autowired
	private UserInformationReponsitory userInformationReponsitory;
	
	@Override
	public void saveUserInfor(AccountEntity accountEntity) {
		userInformationReponsitory.saveAndFlush(accountEntity.getUserInfor());
	}

	@Override
	public AccountEntity getAccount(UserInformationEntity userInformationEntity) {
		return userInformationEntity.getAccount();
	}
	
}
