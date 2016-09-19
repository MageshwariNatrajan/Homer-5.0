@JenkinsFilter 
Feature: Feature to test Jenkins folder 

@JenkinsFilter1 @Priority1 @Jenkins1
Scenario: Jenkins Filter 1 
	Given Testing Jenkins Filter one
	
@JenkinsFilterMultiIt
Scenario Outline: Jenkins Filter MultiIteration 
	Given Testing Jenkins Filter MultiIteration
Examples: 
|Iteration|
|1|
|2|
	
@JenkinsFilter2 @Priority2 @NRF @Jenkins2
Scenario: Jenkins Filter 2 
	Given Testing Jenkins Filter two 
	
@JenkinsFilter3  @Priority3 @NRF
Scenario: Jenkins Filter 3 
	Given Testing Jenkins Filter three 
	
@JenkinsFilter4 @Priority1 @VisualNav
Scenario: Jenkins Filter 4 
	Given Testing Jenkins Filter four 
	
@JenkinsFilter5 @Priority2 @SEO
Scenario: Jenkins Filter 5 
	Given Testing Jenkins Filter five 
	
@JenkinsFilter6 @Priority3 @Search
Scenario: Jenkins Filter 6 
	Given Testing Jenkins Filter six 
	
@JenkinsFilter7 @Priority1 @SEO
Scenario: Jenkins Filter 7 
	Given Testing Jenkins Filter seven 
	
@JenkinsFilter8 @Priority3 @Certona
Scenario: Jenkins Filter 8 
	Given Testing Jenkins Filter eight 
	
@JenkinsFilter9 @Priority2 @Certona
Scenario: Jenkins Filter 9 
	Given Testing Jenkins Filter nine 
	
@JenkinsFilter10 @Priority1 @Search
Scenario: Jenkins Filter 10 
	Given Testing Jenkins Filter ten 
	
@JenkinsFilter11 @Priority3 @NRF
Scenario: Jenkins Filter 11 
	Given Testing Jenkins Filter eleven 
	
@JenkinsFilter12 @Priority2 @Search
Scenario: Jenkins Filter 12 
	Given Testing Jenkins Filter twelve 
	
@JenkinsFilter13 @Priority1 @Certona
Scenario: Jenkins Filter 13 
	Given Testing Jenkins Filter thirteen 
	
@JenkinsFilter14 @Priority2 @DataCollector
Scenario: Jenkins Filter 14 
	Given Testing Jenkins Filter fourteen 
	
@JenkinsFilter15 @Priority1 @NRF
Scenario: Jenkins Filter 15 
	Given Testing Jenkins Filter fifteen