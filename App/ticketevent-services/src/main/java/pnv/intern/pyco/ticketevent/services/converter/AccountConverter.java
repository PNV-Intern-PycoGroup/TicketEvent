package pnv.intern.pyco.ticketevent.services.converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

@Component
public class AccountConverter {
	public static boolean IS_CONVERT;

	public AccountConverter() {
	}

	public static AccountUserInfoModel convertFromAccountEntity(AccountEntity account) {
		AccountUserInfoModel accountInfo = new AccountUserInfoModel();
		if (account.getUserInfor() != null) {
			if (account.getUserInfor().getDateOfBirth() != null) {
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				String birtday = df.format(account.getUserInfor()
						.getDateOfBirth());
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

	public static List<AccountUserInfoModel> convertAllAccountToAccountUserInfoModel(
			List<AccountEntity> listAccountEntity) {
		List<AccountUserInfoModel> listAccountUserInfor = new ArrayList<>();
		for (AccountEntity acEntity : listAccountEntity) {
			listAccountUserInfor.add(convertFromAccountEntity(acEntity));
		}
		return listAccountUserInfor;
	}

	public static AccountModel convertAccountEntityToAccountModel(AccountEntity accountEntity) {
		IS_CONVERT = true;
		AccountModel accountModel = null;
		if (accountEntity != null) {
			UserInformationEntity uInformationEntity = accountEntity.getUserInfor();
			accountModel = new AccountModel();
			accountModel.setId(accountEntity.getId());
			accountModel.setActiveDate(accountEntity.getActiveDate());
			accountModel.setEmail(accountEntity.getEmail());
			accountModel.setIsActive(accountEntity.getIsActive());
			// accountModel.setPassword(accountEntity.getPassword());
			accountModel.setUserName(accountEntity.getUserName());
			//accountModel.setUserRole(uConverter.convertFromUserRoleEntity(accountEntity.getUserRole()));
			if(!AccountUserInfoConverter.IS_CONVERT && uInformationEntity != null){
				accountModel.setUserInfor(AccountUserInfoConverter.convertFromUserInforEntity(uInformationEntity));
			}
			
			// accountModel.setListEvent(accountEntity.getListEvent());
		}
		IS_CONVERT = false;
		return accountModel;
	}
	
	public static List<AccountModel> convertAllAccountEntityToAccountModel(List<AccountEntity> accountEntities){
		List<AccountModel> accountModels = new ArrayList<>();
		for(AccountEntity accountEntity : accountEntities){
			accountModels.add(convertAccountEntityToAccountModel(accountEntity));
		}
		return accountModels;
	}
}
