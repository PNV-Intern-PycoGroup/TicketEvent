package pnv.intern.pyco.ticketevent.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.UserInformationReponsitory;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

@Service
public class UserInformationServiceImpl implements UserInformationService{

	@Autowired
	private UserInformationReponsitory userInformationReponsitory;
	
	@Autowired
	private AccountService accountService;
	
	@Override
	public void saveUserInfor(UserInformationEntity userInforEntity) {
		userInformationReponsitory.saveAndFlush(userInforEntity);
	}

	@Override
	public AccountEntity getAccount(UserInformationEntity userInformationEntity) {
		return userInformationEntity.getAccount();
	}

	@Override
	public UserInformationEntity handleBeforeEditProfile(AccountUserInfoModel account) {
		AccountEntity accountEntity = accountService.getAccountEntityByID(account.getId());
		UserInformationEntity userInfo = null;
		if(accountEntity != null){
			accountEntity.setEmail(account.getEmail());
			userInfo = accountEntity.getUserInfor();
			if(userInfo != null){
				userInfo.setAddress(account.getAddress());
				userInfo.setName(account.getName());
				userInfo.setPhone(account.getPhone());
				userInfo.setDateOfBirth(convertStringToDate(account.getBirthday()));
			}else{
				userInfo = new UserInformationEntity();
				userInfo.setId(accountEntity.getId());
				userInfo.setAccount(accountEntity);
				userInfo.setAddress(account.getAddress());
				userInfo.setDateOfBirth(convertStringToDate(account.getBirthday()));
				userInfo.setName(account.getName());
				userInfo.setPhone(account.getPhone());
				accountEntity.setUserInfor(userInfo);
				
			}
			accountService.updateAccount(accountEntity);
		}
		
		return userInfo;
	}
	
	public Date convertStringToDate(String dataToConvert){
		
		try {
			Date dateInput = new SimpleDateFormat("dd/MM/yyyy").parse(dataToConvert);
			String dateString = new SimpleDateFormat("yyyy-MM-dd").format(dateInput);
			return new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		} 
		
	   
	}

	
	
}
