Feature: Homepage and Appreal and Gifts Functionality

Scenario: Verify Homepage Assertions and Navigate to Appreal and Gifts Functionality Page 
	Given I launch the browser and go to the URL 
	Then I should see the homepage title 
	And I should see the logo displayed 
	And I should see the Promo Code box
	When I click on the Shop Tests button 
 
	When I am on the Shop Tests page 
	And I click on the Appreal and Gifts section
	And I should see the T Shirt image section displayed
	Then I should see the name and pricing displayed
	When I click on the View More button
	Then I should see the T Shirt Details Page