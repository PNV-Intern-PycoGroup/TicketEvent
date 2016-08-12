package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;


public interface AccountService {
	List<AccountModel> getAllAccountByType(Long accountType);
	AccountModel getAccountModelByID(long id);
	AccountModel getAccountModelByUserName(String userName);
	AccountModel getAccountModelByAuthencated();
	List<AccountModel> getAllAccountModel();
	List<AccountModel> getAllAccountModelUser();
	boolean checkExitsUser(String username);
	void saveAdminAccount(AccountModel account);
	void saveAccount(AccountModel account);
	void setActive(long accountId, int typeActive);
	void updateAccount(AccountEntity accountEntity);
	AccountUserInfoModel getAccInfor(Long id);
	List<AccountModel> getAccountModelFromListEntity(List<AccountEntity> listAccountEntity);
	AccountEntity getAccountEntityByID(long id);
	Long checkExistUserReturnID(String username);
	String getPrincipal();
	List<AccountModel> getLastestMember();
	AccountModel checkLoginForm(AccountModel account);
}
