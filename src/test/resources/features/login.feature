Feature: Login Performance Feature
  Validates login functionality across UI and API

  @ui @performance
  Scenario: Login UI performance check
    When user logs in via UI
    Then products page should be displayed within 2000 ms

  @api @performance
  Scenario: Login API performance
    Given login API performance is measured

  @ui @performance
  Scenario: Login API and UI performance check
    Given login API performance is measured
    When user logs in via UI
    Then products page should be displayed within 2000 ms