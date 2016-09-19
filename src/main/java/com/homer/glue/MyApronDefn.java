/**
 * 
 */
package com.homer.glue;

import com.homer.dao.DataClass;
import com.homer.dao.Given;
import com.homer.po.MyApronHomePage;

/**
 * @author MXN8002
 *
 */
public class MyApronDefn extends BaseStepDefn {
	
	public MyApronDefn(DataClass data) {
		super(data);
	}

	
	@Given("^launch my apron application$")
	public void launchMyApronApp() throws Throwable {
		MyApronHomePage myApronHome = new MyApronHomePage(ic);
		myApronHome.launchMyApron();
		myApronHome.clickLogin();
	}
}
