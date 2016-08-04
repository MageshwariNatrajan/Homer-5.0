package com.homer.po;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.homer.dao.InstanceContainer;
import com.homer.resuablecomponents.APITesting;

public class APIDemo extends PageBase<APIDemo> {
	
	public APIDemo(InstanceContainer ic) {
		super(ic);
		
	}
	
	APITesting rest=new APITesting();
	
	
	public String sXMLResponsePath;
	//public HashMap<String,String> mapSetReqProp= new HashMap<String, String>();
	
	/**
	 * Method to get activity token for authorization
	 * 
	 * @param sResponse
	 * @throws Exception 
	 */
	public String getAuthorization(String url,String sXMLPath,HashMap<String,String> mapSetReqProp,String sXPathQuery,String sAttribute) throws Exception {
	     
		 String  strResponse="";	  
		 
		 String sInputXML=rest.getInputXML(sXMLPath);
		 
		 strResponse=rest.postEntity(url,sInputXML,mapSetReqProp); 												
				
		if (strResponse.equals("")) {
			return "";
			
		} else {
			
			/*if(sConvertRespToXML.equalsIgnoreCase("yes")){
				JSONObject json = new JSONObject(strResponse);
				strResponse = XML.toString(json);  				
			}
			*/
			sXMLResponsePath=rest.SaveCurrentXML(strResponse,"GetAuthorization");	
			
			String sTokenID=rest.getDataFromResponseXML(sXMLResponsePath,sXPathQuery,sAttribute);	
			
			return sTokenID;
		}
		
	}
	
	
	/**
	 * Method to create a list using rest api
	 * 
	 * @param entityType
	 * @param fields
	 * @return
	 * @throws Exception 
	 */
	public String createListUsingRest(String url,String sXMLPath,HashMap<String,String> mapSetReqProp,String sXPathQuery,String sAttribute) throws Exception {
		
		
		
		String sInputXML=rest.getInputXML(sXMLPath);
		
		String strResponse=rest.postEntity(url,sInputXML,mapSetReqProp);
		
		if (strResponse.equals("")) {
			return "";
			
		} else {			
					
			
			sXMLResponsePath=rest.SaveCurrentXML(strResponse,"CreateList");	
			
			String sStatus=rest.getDataFromResponseXML(sXMLResponsePath,sXPathQuery,sAttribute);
			
			return sStatus;
		}
		
	     
	}
	/**
	 * Method to create a list using rest api
	 * 
	 * @param entityType
	 * @param fields
	 * @return
	 * @throws Exception 
	 */
	public String getListDetailsUsingRest(String url,String sXMLPath,HashMap<String,String> mapSetReqProp,String sXPathQuery,String sAttribute) throws Exception {
		
	    String  strResponse="";	  	    
	  
	    strResponse=rest.getEntity(url,mapSetReqProp);	 
			
		if (strResponse.equals("")) {
			return "";
			
		} else {
			
			sXMLResponsePath=rest.SaveCurrentXML(strResponse,"ListDetails");	
		    
			String sListID=rest.getDataFromResponseXML(sXMLResponsePath,sXPathQuery,sAttribute);			
			
			return sListID;
		}

	     
	}
	
	/**
	 * Method to Delete list item using rest api call
	 * 	
	 * @throws Exception 
	 */
	public String deleteListItemUsingRest(String url,String sXMLPath,HashMap<String,String> mapSetReqProp,String xPathQuery,String sAttribute) throws Exception {
		

		String sInputXML=rest.getInputXML(sXMLPath);
		
		String strResponse=rest.postEntity(url,sInputXML,mapSetReqProp);
		
		if (strResponse.equals("")) {
			return "";
			
		} else {
			
   		    sXMLResponsePath=rest.SaveCurrentXML(strResponse,"DeleteListItem");	
			
			String sStatus=rest.getDataFromResponseXML(sXMLResponsePath,xPathQuery,sAttribute);
			
			return sStatus;
		}
		
	     
	}

	

}
