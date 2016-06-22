package pnv.intern.pyco.ticketevent.services;

import pnv.intern.pyco.ticketevent.services.model.UserModel;

/**
 * Hello world!
 *
 */
public class DemoService 
{
    public DemoService() {
		
	}
    
    public UserModel getUser() {
		UserModel user = new UserModel("Son Huynh", 20, "Quang Nam");
		return user;
	}
}
