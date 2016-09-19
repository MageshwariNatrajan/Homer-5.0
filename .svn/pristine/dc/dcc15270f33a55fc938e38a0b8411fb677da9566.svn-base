/**
 * 
 */
package com.homer.glue;

import com.homer.dao.DataClass;
import com.homer.dao.Given;
import com.homer.po.LoginPage;

/**
 * @author MXN8002
 *
 */
public class LoginDefn extends BaseStepDefn {

	public LoginDefn(DataClass data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	@Given("^User credentials$")
	public void loginMyApron(){
		
		LoginPage login = new LoginPage(ic);
		login.loginToMyApron();
	}

}
