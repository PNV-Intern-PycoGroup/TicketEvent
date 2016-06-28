package pnv.intern.pyco.ticketevent.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pnv.intern.pyco.ticketevent.entity.AccountEntity;
import pnv.intern.pyco.ticketevent.repository.AccountReponsitoty;

@Service
public class AccountService {
	
	@Autowired
	private AccountReponsitoty accountReponsitoty;
	
	public AccountService(){}

	public AccountService(AccountReponsitoty accountReponsitoty) {
		this.accountReponsitoty = accountReponsitoty;
	}
	
	public AccountEntity getAccount(long id){
		return accountReponsitoty.findOne(id);
	}
	
	public List<AccountEntity> getAllAccount(){
		return accountReponsitoty.findAll();
	}
	
}
