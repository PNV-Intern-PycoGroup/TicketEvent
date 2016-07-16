package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import org.springframework.data.domain.Page;

import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;


public interface AccountService {
	
	
	public Page<AccountEntity> getAllAccount(Long accountType, Integer pageNumber);
	
	
	
	public AccountEntity getAccount(long id);
	
	public AccountEntity getAccountbyUserName(String userName);
	
	public List<AccountEntity> getAllAccount();
	
	public List<AccountEntity> getAllAccountNotAdmin();
	
	public boolean findUser(String username);
	
	public void Save(AccountEntity account);
	
	public void setActive(long accountId, int typeActive);
	
	public void updateAccount(AccountEntity accountEntity);
	
	public AccountUserInfoModel getAccInfor(Long id);
	
	public List<AccountUserInfoModel> getAllAccountUserInfoModel(List<AccountEntity> listAccountEntity);
	
}
