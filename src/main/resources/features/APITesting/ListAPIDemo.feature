@MYLISTAPI
Feature: List API validation using Get and Post

@MYLISTAPI
Scenario: MYAC_01_Create_Delete_List_Using_MyList_API
	Given I am a authorized user and get activity token	
	And I Create a List using api end point and input xml 
	And I Get List details using api end point
	And I Delete List using api end point and input xml
	
	Scenario: MYAC_01_Create_Delete_List_Using_MyList_API_1
	Given I am a authorized user and get activity token	
	And I Create a List using api end point and input xml 
	And I Get List details using api end point
	And I Delete List using api end point and input xml
	
	Scenario: MYAC_01_Create_Delete_List_Using_MyList_API_2
	Given I am a authorized user and get activity token	
	And I Create a List using api end point and input xml 
	And I Get List details using api end point
	And I Delete List using api end point and input xml
	
	Scenario: MYAC_01_Create_Delete_List_Using_MyList_API_3
	Given I am a authorized user and get activity token	
	And I Create a List using api end point and input xml 
	And I Get List details using api end point
	And I Delete List using api end point and input xml