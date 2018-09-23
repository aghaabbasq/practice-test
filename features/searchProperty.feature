Feature: search for sale
	As a user
	I want to do a search for sale property
	So that I can click on first non featured property form list


Scenario: search
Given Open chrome browser and go to ""
When User is on home page search for ""
And Choose an option from dropdown
Then Find Sale button 