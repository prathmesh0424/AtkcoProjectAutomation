Feature: Homepage and Shop Tests Functionality

Scenario: Verify Homepage Assertions and Navigate to Shop Tests Page 
	Given I launch the browser and go to the URL 
	Then I should see the homepage title 
	And I should see the logo displayed 
	And I should see the navigation menu 
	When I click on the Shop Tests button 
 
	When I am on the Shop Tests page 
	And I should see the test categories displayed 
	And I should see the view more section 
	When I should be on the View More page
	