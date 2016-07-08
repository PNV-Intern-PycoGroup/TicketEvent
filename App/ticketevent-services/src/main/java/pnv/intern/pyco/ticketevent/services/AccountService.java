package pnv.intern.pyco.ticketevent.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.repository.AccountReponsitoty;
import pnv.intern.pyco.ticketevent.repository.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.entity.UserRoleEntity;

@Service
public class AccountService {
	
	@Autowired
	private AccountReponsitoty accountReponsitoty;
	
	@Autowired
	private EmailServices emailService;
	
	public AccountService(){}

	public AccountService(AccountReponsitoty accountReponsitoty) {
		this.accountReponsitoty = accountReponsitoty;
	}
	
	public AccountEntity getAccount(long id){
		return accountReponsitoty.findOne(id);
	}
	
	public AccountEntity getAccountbyUserName(String userName){
		return accountReponsitoty.findAccountByUserName(userName);
	}
	
	public List<AccountEntity> getAllAccount(){
		return accountReponsitoty.findAll();
	}
	
	public boolean findUser(String username){
		if(getAccountbyUserName(username) != null){
			return false; 
		}else
			return true;
	}
	
	public void Save(AccountEntity account){
		account.setActive_date(new Date());
		account.setIsActive(1);
		account.setUser_role(new UserRoleEntity(1, "ROLE_USER"));
		emailService.sentEmailRegister(account.getEmail());
		accountReponsitoty.save(account);
	}
	
}
