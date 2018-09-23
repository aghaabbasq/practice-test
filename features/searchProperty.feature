Feature: search for sale
	As a user
	I want to do a search for sale property
	So that I can click on first non featured property form list


Scenario: search

Given Open chrome browser and go to homepage
When User input and choose an option from dropdown
Then Perform a sale search
When User filter by selecting options from dropdowns
Then Find propertie
When User can sort by 
Then Click on first non-featured property to view description 