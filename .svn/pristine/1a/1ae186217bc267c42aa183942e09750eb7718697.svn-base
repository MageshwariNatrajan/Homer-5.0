package com.homer.glue;

import java.util.HashMap;

import com.homer.dao.And;
import com.homer.dao.CommonDataColumn;
import com.homer.dao.DataClass;
import com.homer.dao.Given;
import com.homer.dao.Then;
import com.homer.dao.When;
import com.homer.resuablecomponents.APITesting;
import com.homer.enums.EnumClass.StepResult;
import com.homer.helper.HelperClass;


public class APIStepDef extends BaseStepDefn{

	public APIStepDef(DataClass data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	//APITesting rest;
	public String sAuthorizationKey;
	public String sAuthListID;
	public HashMap<String,String> mapSetReqProp= new HashMap<String, String>();
	
	
	 
	@Given("^I am a authorized user and get activity token$")
	public void i_am_a_authorized_user_and_get_activity_token() throws Throwable { 
		
		
		int stepNum=data.stepNo;
		
		String sEnvUrl=dataTable.getCommonData(CommonDataColumn.EnvironmentUrl);
		String sEndPoint=dataTable.getData(stepNum,"EndPoint");
		String sReqXMLPath=dataTable.getData(stepNum,"RequestXMLPath");	
		String sRequestPropToSet=dataTable.getData(stepNum,"SetRequestProperty");
		String sXPathQuery=dataTable.getData(stepNum,"XpathExpression");		
		String sAttribute=dataTable.getData(stepNum,"Attribute");
			
		
		mapSetReqProp=APITesting.setRequestPropToMap(sRequestPropToSet);	
						
		String strURL=sEnvUrl+sEndPoint;
		
		String autCode=apiDemo.getAuthorization(strURL,sReqXMLPath,mapSetReqProp,sXPathQuery,sAttribute);
		sAuthorizationKey=autCode;		
		
		String aHrf="<a href="+apiDemo.sXMLResponsePath+" "+"target=_self"+">Click To Check XML Response</a>";
		if(!autCode.isEmpty()){
			//System.out.println(autCode);	
			rptUtil.addReportStep("Verify user is authorised", "User authorised successfully <b>       "+aHrf, StepResult.PASS);			
		}else{
			rptUtil.addReportStep("Verify user is authorised", "User authorization failed", StepResult.FAIL);			
		}	
	  
		
	}

	@And("^I Create a List using api end point and input xml$")
	public void i_Create_a_List_using_api_end_point_and_input_xml() throws Throwable {   
				
		int stepNum=data.stepNo;
		String sEnvUrl=dataTable.getCommonData(CommonDataColumn.EnvironmentUrl);
		String sEndPoint=dataTable.getData(stepNum,"EndPoint");
		String sReqXMLPath=dataTable.getData(stepNum,"RequestXMLPath");	
		String sRequestPropToSet=dataTable.getData(stepNum,"SetRequestProperty");
		String sXPathQuery=dataTable.getData(stepNum,"XpathExpression");		
		String sAttribute=dataTable.getData(stepNum,"Attribute");
		
		sRequestPropToSet=sRequestPropToSet+",Authorization:"+sAuthorizationKey;		
		
		String strURL=sEnvUrl+sEndPoint;		
		mapSetReqProp=APITesting.setRequestPropToMap(sRequestPropToSet);
		
		String sResponse=apiDemo.createListUsingRest(strURL,sReqXMLPath,mapSetReqProp,sXPathQuery,sAttribute);
		
		if(sResponse.equalsIgnoreCase("success")){
			String aHrf="<a href="+apiDemo.sXMLResponsePath+" "+"target=_self"+">Click To Check XML Response</a>";
			rptUtil.addReportStep("Create List using api", "List created successfully                     <b>"+aHrf, StepResult.PASS);
			
		}else{
			rptUtil.addReportStep("Create List using api", "List not created", StepResult.FAIL);			
		}	
		
	  
	  
	}

	@And("^I Get List details using api end point$")
	public void i_Get_List_details_using_api_end_point() throws Throwable { 
		int stepNum=data.stepNo;
		String sEnvUrl=dataTable.getCommonData(CommonDataColumn.EnvironmentUrl);
		String sEndPoint=dataTable.getData(stepNum,"EndPoint");
		String sReqXMLPath=dataTable.getData(stepNum,"RequestXMLPath");	
		String sRequestPropToSet=dataTable.getData(stepNum,"SetRequestProperty");
		String sXPathQuery=dataTable.getData(stepNum,"XpathExpression");		
		String sAttribute=dataTable.getData(stepNum,"Attribute");
		
		sRequestPropToSet=sRequestPropToSet+",Authorization:"+sAuthorizationKey;		
				
		String strURL=sEnvUrl+sEndPoint;
		mapSetReqProp=APITesting.setRequestPropToMap(sRequestPropToSet);
		
		String sListID=apiDemo.getListDetailsUsingRest(strURL,sReqXMLPath,mapSetReqProp,sXPathQuery,sAttribute);
		sAuthListID=sListID;
		
		if(!sListID.isEmpty()){
			System.out.println(sListID);
			String aHrf="<a href="+apiDemo.sXMLResponsePath+" "+"target=_self"+">Click To Check XML Response</a>";
			rptUtil.addReportStep("Get List ID from response xml", "List Id retrived successfully                   <b>"+aHrf, StepResult.PASS);			
		}else{
			rptUtil.addReportStep("Get List ID from response xml", "Failed to get list id from response xml", StepResult.FAIL);
			
		}	
	  
	  
	}

	@And("^I Delete List using api end point and input xml$")
	public void i_Delete_List_using_api_end_point_and_input_xml() throws Throwable { 
		int stepNum=data.stepNo;
		String sEnvUrl=dataTable.getCommonData(CommonDataColumn.EnvironmentUrl);
		String sEndPoint=dataTable.getData(stepNum,"EndPoint");
		String sReqXMLPath=dataTable.getData(stepNum,"RequestXMLPath");	
		String sRequestPropToSet=dataTable.getData(stepNum,"SetRequestProperty");
		String sXPathQuery=dataTable.getData(stepNum,"XpathExpression");		
		String sAttribute=dataTable.getData(stepNum,"Attribute");
		
		sRequestPropToSet=sRequestPropToSet+",Authorization:"+sAuthorizationKey;		
			
		
		String strURL=sEnvUrl+sEndPoint+"/"+sAuthListID+"/deleteitems";
		mapSetReqProp=APITesting.setRequestPropToMap(sRequestPropToSet);
		
		String sResponse=apiDemo.deleteListItemUsingRest(strURL,sReqXMLPath,mapSetReqProp,sXPathQuery,sAttribute);
		if(sResponse.equalsIgnoreCase("success")){
			String aHrf="<a href="+apiDemo.sXMLResponsePath+" "+"target=_self"+">Click To Check XML Response</a>";
			rptUtil.addReportStep("Delete List item using api", "List item deleted successfully                    <b>"+aHrf, StepResult.PASS);
			
		}else{
			rptUtil.addReportStep("Delete List item using api", "Fail to delete list item", StepResult.FAIL);		
		}	
		
	  
	  
	}

	
	
	
	
}
