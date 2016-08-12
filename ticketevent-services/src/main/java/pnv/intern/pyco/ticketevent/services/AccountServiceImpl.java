package pnv.intern.pyco.ticketevent.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.AccountReponsitoty;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserRoleEntity;
import pnv.intern.pyco.ticketevent.services.converter.AccountConverter;
import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;
import pnv.intern.pyco.ticketevent.services.util.PasswordEncoderUtil;

@Service
public class AccountServiceImpl implements AccountService{
private static final int LASTEST_MEMBER_SIZE = 8;
	
	@Autowired
	private AccountReponsitoty accountReponsitoty;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public AccountServiceImpl(){}

	public AccountServiceImpl(AccountReponsitoty accountReponsitoty) {
		this.accountReponsitoty = accountReponsitoty;
	}
	
	@Override
	public List<AccountModel> getAllAccountByType(Long accountType){
		List<AccountEntity> accountEntities = accountReponsitoty.getAllAccountByType(accountType); 
		List<AccountModel> accountModels = AccountConverter.convertAllAccountEntityToAccountModel(accountEntities);
	    return accountModels;
	}
	
	@Override
	public List<AccountModel> getLastestMember() {
		PageRequest request =
	            new PageRequest(0, LASTEST_MEMBER_SIZE, Sort.Direction.DESC, "activeDate");
		Page<AccountEntity> accountEntities = accountReponsitoty.getLastestMember(request);
		List<AccountModel> accountModels = AccountConverter.convertAllAccountEntityToAccountModel(accountEntities.getContent());
		return accountModels;
	}

	@Override
	public AccountModel getAccountModelByID(long id){
		AccountEntity accountEntity = accountReponsitoty.findOne(id);
		return AccountConverter.convertAccountEntityToAccountModel(accountEntity);
	}
	
	@Override
	public AccountModel getAccountModelByAuthencated(){
		AccountEntity accountEntity = accountReponsitoty.findAccountByUserName(getPrincipal());
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
		AccountEntity accountEntity = accountReponsitoty.findAccountByUserName(username);
		if(accountEntity != null){
			return false; 
		} else {
			return true;
		}
	}
	@Override
	public void saveAccount(AccountModel accountModel){
		AccountEntity account = new AccountEntity();
		account.setUserName(accountModel.getUserName());
		account.setEmail(accountModel.getEmail());
		account.setActiveDate(new Date());
		account.setUserRole(new UserRoleEntity(2, "ROLE_USER"));
		account.setPassword(PasswordEncoderUtil.endCodePassword(accountModel.getPassword()));
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
	public List<AccountModel> getAccountModelFromListEntity(List<AccountEntity> listAccountEntity){
		return AccountConverter.convertAllAccountEntityToAccountModel(listAccountEntity);
	}

	@Override
	public final AccountEntity getAccountEntityByID(final long id) {
		return accountReponsitoty.findOne(id);
	}

	@Override
	public final Long checkExistUserReturnID(final String username) {
		AccountEntity accountEntity = accountReponsitoty.findAccountByUserName(username);
		if(accountEntity != null){
			return accountEntity.getId();
		}
		return null;
	}
	
	@Override
	public String getPrincipal(){
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return userName;
    }

	@Override
	public AccountModel checkLoginForm(final AccountModel account) {
		AccountModel accountGetFromData = null;
		if (account != null) {
			AccountEntity accountEntity = accountReponsitoty.findAccountByUserName(account.getUserName());
			if (accountEntity != null && encoder.matches(account.getPassword(), accountEntity.getPassword())) {
				accountGetFromData = AccountConverter.convertAccountEntityToAccountModel(accountEntity);
			}
		}
		return accountGetFromData;
	}

	@Override
	public AccountModel getAccountModelByUserName(String userName) {
		AccountEntity accountEntity = accountReponsitoty.getAccountByUserName(userName);
		return AccountConverter.convertAccountEntityToAccountModel(accountEntity);
	}

	@Override
	public void saveAdminAccount(AccountModel account) {
		AccountEntity accountEntity = new AccountEntity();
		accountEntity.setUserName(account.getUserName());
		accountEntity.setEmail(account.getEmail());
		accountEntity.setActiveDate(new Date());
		accountEntity.setUserRole(new UserRoleEntity(1, "ROLE_ADMIN"));
		accountEntity.setIsActive(1);
		accountEntity.setPassword(PasswordEncoderUtil.endCodePassword(account.getPassword()));
		accountReponsitoty.save(accountEntity);
	}
}
