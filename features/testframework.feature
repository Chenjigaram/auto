# Author: Naveen CM

@test
Feature: Test google

Scenario: Open google.com
	When call "test.feature"
	When I enter "naveen" into input field having "search_input"
	Then I wait for 5 sec
	Then I take screenshot