package pnv.intern.pyco.ticketevent.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.AccountReponsitoty;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserRoleEntity;
import pnv.intern.pyco.ticketevent.services.converter.AccountConverter;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

@Service
public class AccountServiceImpl implements AccountService{
private static final int PAGE_SIZE = 1;
	
	@Autowired
	private AccountReponsitoty accountReponsitoty;
	
	@Autowired
	private EmailServices emailService;
	
	public AccountServiceImpl(){}

	public AccountServiceImpl(AccountReponsitoty accountReponsitoty) {
		this.accountReponsitoty = accountReponsitoty;
	}
	
	@Override
	public Page<AccountEntity> getAllAccount(Long accountType, Integer pageNumber) {
        PageRequest request =
            new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "id");
        return accountReponsitoty.getAllUserNotAdmin(accountType, request);
    }
	
	
	@Override
	public AccountModel getAccountModelByID(long id){
		AccountEntity accountEntity = accountReponsitoty.findOne(id);
		return AccountConverter.convertAccountEntityToAccountModel(accountEntity);
	}
	
	@Override
	public AccountModel getAccountModelbyUserName(String userName){
		AccountEntity accountEntity = accountReponsitoty.findAccountByUserName(userName);
		AccountModel accountModel = AccountConverter.convertAccountEntityToAccountModel(accountEntity);
		return accountModel;
	}
	
	@Override
	public List<AccountModel> getAllAccountModel(){
		List<AccountEntity> accountEntities = accountReponsitoty.findAll();
		return AccountConverter.convertAllAccountEntityToAccountModel(accountEntities);
	}
	
	@Override
	public List<AccountModel> getAllAccountModelUser(){
		List<AccountEntity> accountEntities = accountReponsitoty.getAllUser();
		return AccountConverter.convertAllAccountEntityToAccountModel(accountEntities);
	}
	
	@Override
	public boolean checkExitsUser(String username){
		if(getAccountModelbyUserName(username) != null){
			return false; 
		}else
			return true;
	}
	
	@Override
	public void Save(AccountEntity account){
		account.setActiveDate(new Date());
		account.setIsActive(1);
		account.setUserRole(new UserRoleEntity(2, "ROLE_USER"));
		emailService.sentEmailRegister(account.getEmail());
		accountReponsitoty.save(account);
	}
	
	@Override
	public void setActive(long accountId, int typeActive){
		AccountEntity accountEntity = accountReponsitoty.findOne(accountId);
		if(typeActive == 0){
			accountEntity.setIsActive(0);
		}else{
			accountEntity.setIsActive(1);
		}
		updateAccount(accountEntity);
	}
	
	@Override
	public void updateAccount(AccountEntity accountEntity){
		accountReponsitoty.saveAndFlush(accountEntity);
	}
	
	@Override
	public AccountUserInfoModel getAccInfor(Long id){
		AccountUserInfoModel acc = AccountConverter.convertFromAccountEntity(accountReponsitoty.findOne(id));
		return acc;
	}
	
	@Override
	public List<AccountModel> getAllAccount(List<AccountEntity> listAccountEntity){
		return AccountConverter.convertAllAccountEntityToAccountModel(listAccountEntity);
	}

	@Override
	public AccountEntity getAccountEntityByID(long id) {
		return accountReponsitoty.findOne(id);
	}
	
}
