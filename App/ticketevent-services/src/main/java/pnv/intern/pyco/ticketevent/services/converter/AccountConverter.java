package pnv.intern.pyco.ticketevent.services.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

public class AccountConverter {

	public AccountUserInfoModel convertFromAccountEntity(AccountEntity account) {
		AccountUserInfoModel accountInfo = new AccountUserInfoModel();
		if(account.getUserInfor().getDateOfBirth() != null){
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			String birtday = df.format(account.getUserInfor().getDateOfBirth());
			accountInfo.setBirthday(birtday);
		}
		
		
		accountInfo.setId(account.getId());
		accountInfo.setEmail(account.getEmail());
		accountInfo.setUsername(account.getUserName());
		accountInfo.setName(account.getUserInfor().getName());
		accountInfo.setAddress(account.getUserInfor().getAddress());
		accountInfo.setPhone(account.getUserInfor().getPhone());
		
		accountInfo.setAvatar(account.getUserInfor().getAvatar());
		return accountInfo;
	}
}
