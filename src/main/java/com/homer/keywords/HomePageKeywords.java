package com.homer.keywords;

import com.homer.dao.DataClass;
import com.homer.dao.DataColumn;
import com.homer.po.HomePage;

public class HomePageKeywords extends BaseKeywords  {
	
	public HomePageKeywords(DataClass data) {
		super(data);
	}	

	public void openHomePage() throws Exception  {
		
		System.out.println("open home page method");
		
		
		homePage = new HomePage(ic);
		homePage.open();
	}
	
	public void searchKeyword() throws Exception {
		
		System.out.println(dataTable.getData(DataColumn.Keyword));
		
		homePage.searchKeyword(dataTable.getData(DataColumn.Keyword));
	}
}
