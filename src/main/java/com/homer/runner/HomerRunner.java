package com.homer.runner;

import com.homer.setup.RunManager;

public class HomerRunner {

	public static void main(String[] args) throws Exception {	
		
		RunManager rm = new RunManager();
		rm.runTestCases(args);
			
		System.out.println("Automation execution completed successfully");
			
		
	}
}
