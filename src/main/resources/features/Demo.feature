@Demo1
Feature: Feature to show new BDD framework features

  @Scenario1 @P1Test
  Scenario: Search for keyword
    Given I am a customer on Home Depot
    
  @Scenario2
  Scenario Outline: Search for keyword multi iteration
    Given I am a customer on Home Depot
    When I search for "hammer"
    Then I see the initial search PLP
    When I click first prod in Search PLP
    Then I see PIP page displayed
    When I search for "drill"
    Then I see the initial search PLP
    When I click first prod in Search PLP
    Then I see PIP page displayed
    When I search for "sinks"
    Then I see the initial search PLP
    When I click first prod in Search PLP
    Then I see PIP page displayed

    Examples: Keyword
      | keyword |
      | hammer  |
      | drill   |
      | sinks   |

  @CheckoutScenario @P1Test
  Scenario: Place online STH order
    Given I am a customer on Home Depot
    When I search for sku "202304610"
    Then I see PIP page for SKU displayed
    When I click on AddToCart in PIP page
    Then I see Shopping Cart page
    And I click AddToCart in ShoppingCart page
    Then I see Guest Checkout page
    And I enter Guest email id and click continue
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in Shipping page
    Then I see Payment page
    When I fill payment details
    And I click continue button in Payment page
    Then I see thank you page for order placed
    
    @TestTableData    
    Scenario: Test Step Level Table Data
     Then I test data table Map
    |FirstName|Prashant|
    |LastName|Sajjan|
    |City|Austin|
    Given I test two column map
    |FirstName|Prashant|
    |LastName|Sajjan|
    |City|Austin|
    Then I test table data List String
	| order           | credit        | gift    | status  |
 	| STH             | VISA          | no GIFT | success |
    | BOSS            | MASTER        | no GIFT | success |
	| BOPIS           | AMEX          | no GIFT | success |
    Given I am a customer on Home Depot
    Then I type "suprita"
	Then  I test table data List Employee
    | order           | credit        | gift    | status  |
 	| STH             | VISA          | no GIFT | success |
    | BOSS            | MASTER        | no GIFT | success |
	| BOPIS           | AMEX          | no GIFT | success |
	| Blinds          | Discover      | no GIFT | success |
	| Appliance       | VISA          | no GIFT | success |
	| Blinds          | VISA          | GIFT    | success |	
	Then I test table data List Map
    | Component_1                          | Component_2                                                                     | Component_3                                                       |
	| Elements\\Title.png;Drilling Machine | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/power-tools-visnav.jpg | Elements\\List.png;Price - 100$%Color - Orange %In-stock          |
	| Elements\\Title.png;Wood Works       | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/woodworking-visnav.jpg |                                                                   |
	| Elements\\Title.png;Safe             | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/safes-visnav.jpg       | Elements\\List.png;Price - 200$%Colour - Black%Back Order         |	
    Given I test table data one
    | keyword |
    | hammer  |
    | drill   |
    | sinks   |
 	Then I test table data two 
 	| order           | credit        | gift    | status  |
 	| STH             | VISA          | no GIFT | success |
    | BOSS            | MASTER        | no GIFT | success |
	| BOPIS           | AMEX          | no GIFT | success |
	| Blinds          | Discover      | no GIFT | success |
	| Appliance       | VISA          | no GIFT | success |
	| Blinds          | VISA          | GIFT    | success |
	| STH + Appliance | AMEX          | GIFT    | success |
    | STH             | PLCC Consumer | no GIFT | success |
    | BOSS            | PLCC Consumer | no GIFT | success |
    | Appliance       | LCC Proxy     | no GIFT | success |
    Then I test table data three one
    | Component_1                          | Component_2                                                                     | Component_3                                                       |
	| Elements\\Title.png;Drilling Machine | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/power-tools-visnav.jpg | Elements\\List.png;Price - 100$%Color - Orange %In-stock          |
	| Elements\\Title.png;Wood Works       | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/woodworking-visnav.jpg |                                                                   |
	| Elements\\Title.png;Safe             | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/safes-visnav.jpg       | Elements\\List.png;Price - 200$%Colour - Black%Back Order         |
	| Elements\\Title.png;Wet-Dry Vaccum   |                                                                                 | Elements\\List.png;Price - 50$%Colour - Orange And Black%In-Stock |
	And I test data table with parameters "sinks"
	| order           | credit        | gift    | status  |
 	| STH             | VISA          | no GIFT | success |
    | BOSS            | MASTER        | no GIFT | success |
	| BOPIS           | AMEX          | no GIFT | success |
	| Blinds          | Discover      | no GIFT | success |
	| Appliance       | VISA          | no GIFT | success |
	
	
	
	@TestTableDataOutline    
    Scenario Outline: Test Step Level Table Data MultiIteration
    Given I am a customer on Home Depot
	Given I test table data one
    | keyword |
    | hammer  |
    | drill   |
    | sinks   |
    And I test data table with parameters "sinks" and <keyword>
	| order           | credit        | gift    | status  |
 	| STH             | VISA          | no GIFT | success |
    | BOSS            | MASTER        | no GIFT | success |
	| BOPIS           | AMEX          | no GIFT | success |
	| Blinds          | Discover      | no GIFT | success |
	| Appliance       | VISA          | no GIFT | success |
	Examples: Keyword
      | keyword |
      | hammer  |
      | drill   |
      | sinks   |