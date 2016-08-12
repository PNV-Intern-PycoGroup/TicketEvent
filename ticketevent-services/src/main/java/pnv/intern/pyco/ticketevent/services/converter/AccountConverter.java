package pnv.intern.pyco.ticketevent.services.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.EventEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserInformationEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserRoleEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;
import pnv.intern.pyco.ticketevent.services.model.EventModel;

@Component
public class AccountConverter {
	public static boolean IS_CONVERT;

	public AccountConverter() {
	}

	public static AccountUserInfoModel convertFromAccountEntity(AccountEntity account) {
		AccountUserInfoModel accountInfo = new AccountUserInfoModel();
		if (account.getUserInfor() != null) {
			if (account.getUserInfor().getDateOfBirth() != null) {
				accountInfo.setBirthday(account.getUserInfor().getDateOfBirth());
			}
			accountInfo.setName(account.getUserInfor().getName());
			accountInfo.setAddress(account.getUserInfor().getAddress());
			accountInfo.setPhone(account.getUserInfor().getPhone());
			accountInfo.setAvatar(account.getUserInfor().getAvatar());
		}

		accountInfo.setId(account.getId());
		accountInfo.setEmail(account.getEmail());
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
			UserRoleEntity userRoleEntity = accountEntity.getUserRole();
			accountModel = new AccountModel();
			accountModel.setId(accountEntity.getId());
			accountModel.setActiveDate(accountEntity.getActiveDate());
			accountModel.setEmail(accountEntity.getEmail());
			accountModel.setIsActive(accountEntity.getIsActive());
			accountModel.setUserName(accountEntity.getUserName());
			accountModel.setPassword(accountEntity.getPassword());
			
			if(!AccountUserInfoConverter.IS_CONVERT && uInformationEntity != null){
				accountModel.setUserInfor(AccountUserInfoConverter.convertFromUserInforEntity(uInformationEntity));
			}
			if(!UserRoleConverter.IS_CONVERT && userRoleEntity != null){
				accountModel.setUserRole(UserRoleConverter.convertFromUserRoleEntity(userRoleEntity));
			}
			
			List<EventEntity> listEventEntity = accountEntity.getListEvent();
			if (!EventConverter.IS_CONVERT && listEventEntity != null) {
				List<EventModel> listEventModel = new ArrayList<>();
				for (EventEntity eventEntity : listEventEntity) {
					listEventModel.add(EventConverter.convertEventEntityToEventModel(eventEntity));
				}
				accountModel.setListEvent(listEventModel);
			}
			
		}
		IS_CONVERT = false;
		return accountModel;
	}

	public static AccountEntity convertDTOToAccountEntity(AccountModel accountModel) {
		IS_CONVERT = true;
		AccountEntity accountEntity = null;
		if (accountModel != null) {
			accountEntity = new AccountEntity();
			accountEntity.setId(accountModel.getId());
			accountEntity.setActiveDate(accountModel.getActiveDate());
			accountEntity.setEmail(accountModel.getEmail());
			accountEntity.setIsActive(accountModel.getIsActive());
			accountModel.setPassword(accountModel.getPassword());
			accountEntity.setUserName(accountModel.getUserName());
		}
		IS_CONVERT = false;
		return accountEntity;
	}
	
	public static List<AccountModel> convertAllAccountEntityToAccountModel(List<AccountEntity> accountEntities){
		List<AccountModel> accountModels = new ArrayList<>();
		for(AccountEntity accountEntity : accountEntities){
			accountModels.add(convertAccountEntityToAccountModel(accountEntity));
		}
		return accountModels;
	}
}
