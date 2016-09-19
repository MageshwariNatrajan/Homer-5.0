package com.homer.glue;

import com.homer.dao.DataClass;
import com.homer.dao.Given;
import com.homer.po.Login;

public class LoginPageDefn extends BaseStepDefn {
	public LoginPageDefn(DataClass data) {
		super(data);
		// TODO Auto-generated constructor stub
	}


	@Given("^Username and password$")
	public void Username_and_password() throws Throwable {

		Login loginPage = new Login(ic);
		loginPage.open();
		loginPage.loginToAppl();

	}

}
