package pnv.intern.pyco.ticketevent.services;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import pnv.intern.pyco.ticketevent.services.model.AccountModel;
import pnv.intern.pyco.ticketevent.services.model.UserRoleModel;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {
	@Mock
	private AccountServiceImpl serviceImpl;
	
    private Map<String, AccountModel> accountModelMap = new HashMap<String, AccountModel>();
    
    private Map<String, AccountModel> createAccountModelMap(long length) {
        Map<String, AccountModel> quesMap = new HashMap<String, AccountModel>();
        for (long i = 0; i < length; i++) {
        	AccountModel question = createAccount(i, i);
            quesMap.put("Account_" + i, question);
        }
        return quesMap;
    }
    private AccountModel createAccount(Long id, long i) {
    	AccountModel accountModel = new AccountModel(id, "Account_"+i, "pass_"+i, "email@_"+i, new UserRoleModel(), 1, new java.util.Date(), null, null);
        return accountModel;
    }
    
    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        accountModelMap = createAccountModelMap(10);
        when(serviceImpl.getAllAccountModel()).thenAnswer(new Answer<List<AccountModel>>() {

            public List<AccountModel> answer(InvocationOnMock invocation)
                    throws Throwable {
                List<AccountModel> newList = new ArrayList<AccountModel>();
                for (int i = 0; i < accountModelMap.size(); i++) {
                    newList.add(accountModelMap.get("Account_" + i));
                }
                return newList;
            }
        });
        
        when(serviceImpl.getAccountModelByID(1)).thenAnswer(new Answer<AccountModel>() {
			public AccountModel answer(InvocationOnMock invocation)
			throws Throwable {
			
				AccountModel item = new AccountModel((long)1, "Account_1", "pass_", "email@_", new UserRoleModel(), 1, new java.util.Date(), null, null);
				return item;
			}
		});
        
        when(serviceImpl.getAllAccountModelUser()).thenAnswer(new Answer<List<AccountModel>>() {
    		public List<AccountModel> answer(InvocationOnMock invocation) throws Throwable{
    			List<AccountModel> newList = new ArrayList<AccountModel>();
                for (int i = 0; i < accountModelMap.size(); i++) {
                    newList.add(accountModelMap.get("Account_" + i));
                }
                return newList;
			}
		});
    }
    
    @Test
    public void getAllAccountTest() {
        List<AccountModel> list = serviceImpl.getAllAccountModel();
        Assert.assertTrue(list.size() == 10);
    }

    @Test
    public void getAccountByIdTest() {
    	long idTest = 1;
        AccountModel account = serviceImpl.getAccountModelByID(idTest);
        Assert.assertTrue(account != null);
    }
    
    @Test
    public void getAccountByType() {
		List<AccountModel> account = serviceImpl.getAllAccountModelUser();
		Assert.assertTrue(account.size() == 10);
    }
    
    @Test
    public void getAccountByUserName(){
    	when(serviceImpl.getAccountModelByUserName(Mockito.anyString())).thenAnswer(new Answer<AccountModel>() {
    		public AccountModel answer(InvocationOnMock invocation) throws Throwable{
				AccountModel account = accountModelMap.get("Account_2");
				return account;
			}
		});
    	AccountModel accountModel = serviceImpl.getAccountModelByUserName("Account_2");
    	Assert.assertTrue(accountModel != null);
    }
    
    @Test
    public void checkExistUserReturnID(){
    	boolean id = serviceImpl.checkExitsUser("phamyqb");
    	Assert.assertTrue(id != true);
    }
}
