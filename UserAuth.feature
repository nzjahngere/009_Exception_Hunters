Feature: User Authentication (UAU_001)
  This covers user registration, login, logout, and password recovery—but password recovery is missing on the site.

  @Functional
  Scenario: UAU_001_001 (Valid Login)
    Given I am on the login page
    When I enter valid credentials
    Then I should be redirected to the product inventory page

  @Negative
  Scenario: UAU_001_002 (Invalid Login)
    Given I am on the login page
    When I enter incorrect username and password
    Then I should see a login error message

  @Negative
  Scenario: UAU_001_003 (Empty Fields)
    Given I am on the login page
    When I leave username and password blank
    Then I should see an error prompting for required fields

  @Negative
  Scenario: UAU_001_004 (Case Sensitivity)
    Given I am on the login page
    When I enter my username in uppercase and password in lowercase
    Then I should see a login error if credentials are case-sensitive

  @Negative
  Scenario: UAU_001_005 (Forgot Password Feature - Missing)
    Given I am on the login page
    When I look for a "Forgot Password" link
    Then I should not find any password recovery option
    And the site does not offer password reset functionality
