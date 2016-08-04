package com.homer.glue;

import com.homer.dao.DataClass;
import com.homer.dao.Given;
import com.homer.dao.Then;
import com.homer.enums.EnumClass.StepResult;

public class JenkinsFilterStepdefn extends BaseStepDefn {

	public JenkinsFilterStepdefn(DataClass data) {
		super(data);
		
	}
	
	@Given("^Testing Jenkins Filter one$")
	public void testing_Jenkins_Filter_one() throws Throwable { 
		
		/*driver.get("http://www.homedepot.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		rptUtil.addReportStep("Testing fail step", "Fail step tested", StepResult.FAIL);*/
		
		System.out.println("Testing Jenkins Filter one");
	}

	@Given("^Testing Jenkins Filter two$")
	public void testing_Jenkins_Filter_two() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter two");
	}

	@Given("^Testing Jenkins Filter three$")
	public void testing_Jenkins_Filter_three() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter three");
	}

	@Given("^Testing Jenkins Filter four$")
	public void testing_Jenkins_Filter_four() throws Throwable { 
	  
		System.out.println("Testing Jenkins Filter four");
	}

	@Given("^Testing Jenkins Filter five$")
	public void testing_Jenkins_Filter_five() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter five");
	}

	@Given("^Testing Jenkins Filter six$")
	public void testing_Jenkins_Filter_six() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter six");
	}

	@Given("^Testing Jenkins Filter seven$")
	public void testing_Jenkins_Filter_seven() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter seven");
	}

	@Given("^Testing Jenkins Filter eight$")
	public void testing_Jenkins_Filter_eight() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter eight");
	}

	@Given("^Testing Jenkins Filter nine$")
	public void testing_Jenkins_Filter_nine() throws Throwable {
		
		System.out.println("Testing Jenkins Filter nine");	  
	}

	@Given("^Testing Jenkins Filter ten$")
	public void testing_Jenkins_Filter_ten() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter ten");	
	}

	@Given("^Testing Jenkins Filter eleven$")
	public void testing_Jenkins_Filter_eleven() throws Throwable { 
	  
		System.out.println("Testing Jenkins Filter eleven");	
	}

	@Given("^Testing Jenkins Filter twelve$")
	public void testing_Jenkins_Filter_twelve() throws Throwable {
	  
		System.out.println("Testing Jenkins Filter twelve");
	}

	@Given("^Testing Jenkins Filter thirteen$")
	public void testing_Jenkins_Filter_thirteen() throws Throwable { 
	  
		System.out.println("Testing Jenkins Filter thirteen");
	}

	@Given("^Testing Jenkins Filter fourteen$")
	public void testing_Jenkins_Filter_fourteen() throws Throwable { 
	  
		System.out.println("Testing Jenkins Filter fourteen");
	}

	@Given("^Testing Jenkins Filter fifteen$")
	public void testing_Jenkins_Filter_fifteen() throws Throwable { 
		
		System.out.println("Testing Jenkins Filter fifteen");
	}
	
	@Given("^Testing Jenkins Filter MultiIteration$")
	public void testing_Jenkins_Filter_MultiIteration() throws Throwable { 
		
		System.out.println("Iteration is "+data.iterationNo);	  
	}

}
