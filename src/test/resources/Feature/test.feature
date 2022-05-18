Feature: Page Element validation on DemoQA

  #Background: User is on demoQA home page
    #Given user is on Google Home Page

  @RallyId:TC-1245
  @smoke
  Scenario: Validate text boxes on demoQA
    Given user is on Google Home Page
    Then validate search results

  Scenario: Validate radio button on demoQA
    Given user is on Google Home Page
    Then verify title
