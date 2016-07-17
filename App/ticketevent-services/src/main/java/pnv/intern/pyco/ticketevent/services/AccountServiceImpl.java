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
import pnv.intern.pyco.ticketevent.services.model.AccountUserInfoModel;

@Service
public class AccountServiceImpl implements AccountService{
private static final int PAGE_SIZE = 1;
	
	@Autowired
	private AccountReponsitoty accountReponsitoty;
	
	@Autowired
	private AccountConverter accountConverter;
	
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
	public AccountEntity getAccount(long id){
		return accountReponsitoty.findOne(id);
	}
	
	@Override
	public AccountEntity getAccountbyUserName(String userName){
		return accountReponsitoty.findAccountByUserName(userName);
	}
	
	@Override
	public List<AccountEntity> getAllAccount(){
		return accountReponsitoty.findAll();
	}
	
	@Override
	public List<AccountEntity> getAllAccountNotAdmin(){
		return accountReponsitoty.getAllUser();
	}
	
	@Override
	public boolean findUser(String username){
		if(getAccountbyUserName(username) != null){
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
		AccountEntity acc = getAccount(accountId);
		if(typeActive == 0){
			acc.setIsActive(0);
		}else{
			acc.setIsActive(1);
		}
		updateAccount(acc);
	}
	
	@Override
	public void updateAccount(AccountEntity accountEntity){
		accountReponsitoty.saveAndFlush(accountEntity);
	}
	
	@Override
	public AccountUserInfoModel getAccInfor(Long id){
		AccountUserInfoModel acc = accountConverter.convertFromAccountEntity(getAccount(id));
		return acc;
	}
	
	@Override
	public List<AccountUserInfoModel> getAllAccountUserInfoModel(List<AccountEntity> listAccountEntity){
		return accountConverter.convertAllAccount(listAccountEntity);
	}
	
}
