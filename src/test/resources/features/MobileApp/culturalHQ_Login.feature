#suresh.kasi@capestart.com
#Date:	Nov-10-2023 
@Regression @Smoke
Feature: CultualHQ Login Functionality

@LoginCHQ
Scenario: Authorized user can login CultualHQ Application
Given User launch the CHQ mobile application
When User enter valid credentials
Then User verify the dashbaord