#suresh.kasi@capestart.com
#Date:	Nov-10-2023 
@API
Feature: REST API Validation

Background: User generates token for Authorization
Given I am an authorized user

@GetBook
Scenario: the Authorized user can Add and Remove a book
Given A list of books are available
Then the book is added
Then the book is removed