package pnv.intern.pyco.ticketevent.services.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

@Component
public class AccountConverter {

	public AccountConverter() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountUserInfoModel convertFromAccountEntity(AccountEntity account) {
		AccountUserInfoModel accountInfo = new AccountUserInfoModel();
		if(account.getUserInfor() != null){
		if(account.getUserInfor().getDateOfBirth() != null){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String birtday = df.format(account.getUserInfor().getDateOfBirth());
			accountInfo.setBirthday(birtday);
		}
		accountInfo.setName(account.getUserInfor().getName());
		accountInfo.setAddress(account.getUserInfor().getAddress());
		accountInfo.setPhone(account.getUserInfor().getPhone());
		accountInfo.setAvatar(account.getUserInfor().getAvatar());
		}
		
		accountInfo.setId(account.getId());
		accountInfo.setEmail(account.getEmail());
		accountInfo.setUsername(account.getUserName());
		accountInfo.setIsActive(account.getIsActive());
		accountInfo.setActiveDate(account.getActiveDate());
		return accountInfo;
	}
	
	public List<AccountUserInfoModel> convertAllAccount(List<AccountEntity> listAccountEntity){
		List<AccountUserInfoModel> listAccountUserInfor = new ArrayList<>();
		for(AccountEntity acEntity : listAccountEntity){
			listAccountUserInfor.add(convertFromAccountEntity(acEntity));
		}
		return listAccountUserInfor;
	}
	
	public AccountModel convertAccountEntityToAccountModel(AccountEntity accountEntity) {
		AccountModel accountModel = new AccountModel();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		accountModel.setId(accountEntity.getId());
		accountModel.setActiveDate(df.format(accountEntity.getActiveDate()));
		accountModel.setEmail(accountEntity.getEmail());
		accountModel.setIsActive(accountEntity.getIsActive());
		accountModel.setPassword(accountEntity.getPassword());
		accountModel.setUserName(accountEntity.getUserName());
//		accountModel.setUserRole(accountEntity.getUserRole());
//		accountModel.setUserInfor(accountEntity.getUserInfor());
//		accountModel.setListEvent(accountEntity.getListEvent());
		
		return accountModel;
	}
}
