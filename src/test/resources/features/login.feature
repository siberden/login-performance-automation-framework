Feature: Login Feature
  Validates login functionality and performance
  across UI and API layers

  @ui @performance
  Scenario: Login UI performance check
    When user logs in via UI
    Then products page should be displayed within 2000 ms

  @api @performance
  Scenario: Login API performance
    Given login API performance is measured

  @api @ui @performance
  Scenario: Login API and UI performance check
    Given login API performance is measured
    When user logs in via UI
    Then products page should be displayed within 2000 ms



