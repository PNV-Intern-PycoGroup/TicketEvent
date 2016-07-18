package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import org.springframework.data.domain.Page;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;


public interface AccountService {
	
	
	public Page<AccountEntity> getAllAccount(Long accountType, Integer pageNumber);
	
	
	
	public AccountModel getAccountModelByID(long id);
	
	public AccountModel getAccountModelbyUserName(String userName);
	
	public List<AccountModel> getAllAccountModel();
	
	public List<AccountModel> getAllAccountModelUser();
	
	public boolean checkExitsUser(String username);
	
	public void Save(AccountEntity account);
	
	public void setActive(long accountId, int typeActive);
	
	public void updateAccount(AccountEntity accountEntity);
	
	public AccountUserInfoModel getAccInfor(Long id);
	
	public List<AccountModel> getAllAccount(List<AccountEntity> listAccountEntity);
	
	public AccountEntity getAccountEntityByID(long id);
	
}
