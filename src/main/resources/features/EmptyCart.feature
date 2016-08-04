@EmptyCart
Feature: Validation of Empty cart scenarios

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item from PIP certona goto cart from PIP submit an order 
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_As a Guest add item and submit order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page and goto cart from PLP submit an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item from PLP goto cart from PLP mini cart button submit an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item from PLP goto cart from PIP mini cart button submit an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item from PIP goto cart place an order
    When I click checkoutNow in ShoppingCart page
    Then I see pickup option page
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item PIP goto cart PIP mini cart button submit order
    When I click checkoutNow in ShoppingCart page
    Then I see pickup option page
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item from PLP certona goto cart from PLP submit an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item PLP certona goto cart from PLP mini cart submit order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item PLP certona goto cart from PIP mini cart submit order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add from PIP certona goto cart from PIP mini cart submit order
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item from SBOTD submit an order
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page goto my account search an item from PLP submit an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page goto my account goto PIP submit an order
    When I click checkoutNow in ShoppingCart page
    Then I see pickup option page
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed

  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page close the browser relaunch add item from PLP submit an order
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page edit details in my account goto cart from mini cart submit order
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see pickup option page
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page goto cart add item from search submit an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page add item from PLP goto cart submit an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page add item from PLP goto cart from PLP mini cart button submit order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page add item from PLP goto cart from PIP mini cart button submit order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page add item from PIP goto cart place an order
    When I click checkoutNow in ShoppingCart page
    Then I see pickup option page
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page add item from PIP goto cart from PIP mini cart button submit order
    Then I click mini cart button in the header
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page add item from SBOTD PIP submit an order
    And I click checkout now
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page add item from PLP goto cart submit an order
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page add item from PLP goto cart from PLP mini cart button submit order
    Then I click mini cart button in the header
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page add item from PLP goto cart from PIP mini cart button submit order
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page add item from PIP goto cart place an order
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page add item from PIP goto cart from PIP mini cart button submit order
    Then I click mini cart button in the header
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see pickup option page
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page add item from SBOTD PIP submit an order
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page goto my account change store details search item submit order
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page close the browser relaunch add item from PLP mini cart submit
    And I click Continue shopping in overlay
    Then I click mini cart button in the header
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page close the browser relaunch add item from PIP mini cart submit order
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP page close the browser relaunch add item from PIP submit order
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page close the browser relaunch add item PLP submit order
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP close browser relaunch add item from PLP goto cart via mini cart submit
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP close browser relaunch add item from PIP goto cart via mini cart submit
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP page close browser relaunch add item to cart from PIP submit order
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP goto my account change store close browser relaunch search item submit
    And I click checkout now
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    And I see session expired error msg in secure checkout page
    Then I enter password for persistent user
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PIP close browser relaunch goto my account change store search item submit
    When I click checkoutNow in ShoppingCart page
    Then I see pickup option page
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_As guest add item from PLP go to payment as guest come back to PLP to reg submit
    And I click Checkout Now in overlay
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    And I click continue button in checkout page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_As guest add item PLP go payment back to PLP to reg goto cart via min cart submit
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    And I click continue button in checkout page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_As guest add item PLP close browser relaunch reg in PLP goto cart via mini cart submit
    And I sign in through header
    Then I click mini cart button in the header
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in home page add item SBOTD close browser relaunch go cart PIP mini cart submit
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_As a Guest add item SBOTD close browser relaunch reg PIP go cart PIP mini cart submit
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_As a Guest add item SBOTD close browser relaunch reg PLP go cart PIP mini cart submit
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in Home page add customized blinds item and submit order
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in Home add blinds item add any other item from PLP go cart PLP mini cart submit
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed 
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in PLP add blinds item add any other item from PIP go cart PIP mini cart submit
    Then I see Shopping Cart page
    When I click checkoutNow in ShoppingCart page
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_As guest add blinds item reg in PLP goto cart from PIP mini cart submit order
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
    Then I see thank you page for order placed
    
  @EmptyCart @MLTC-1128 @1518 @P1
  Scenario: CC_Reg in my account update store add blinds go cart PIP mini cart button submit
    Then I see Shipping Details page
    When I enter Shipping Details
    And I click continue button in checkout page
    Then I see payment page
    When I fill payment details
    And I click submitorder button in Payment page
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
    Then I see thank you page for order placed
    | Component_1                          | Cpmponent_2                                                                     | Component_3                                                       |
	| Elements\\Title.png;Drilling Machine | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/power-tools-visnav.jpg | Elements\\List.png;Price - 100$%Color - Orange %In-stock          |
	| Elements\\Title.png;Wood Works       | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/woodworking-visnav.jpg |                                                                   |
	| Elements\\Title.png;Safe             | Elements\\Image.png;/fetch/FetchRules/Tools_and_Hardware/safes-visnav.jpg       | Elements\\List.png;Price - 200$%Colour - Black%Back Order         |
	| Elements\\Title.png;Wet-Dry Vaccum   |                                                                                 | Elements\\List.png;Price - 50$%Colour - Orange And Black%In-Stock |

    
    