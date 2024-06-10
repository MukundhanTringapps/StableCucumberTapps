Feature: Clear The Shelters Home Page

  Scenario Outline: Verify window title in the CLEAR THE SHELTERS site
    Given TC number <TC_number> and Title <TC_title>
    Then Launch the browser
    And Fetch the URL
    Then Verify the home page title in site
    Then Close the browser

    Examples: 
      | TC_number | TC_title                     |
      | TC 003    | Third Testcase Test2.feature |

  Scenario: Verify page loading in the CLEAR THE SHELTERS site
    Given TC number "TC 004" and title "Fourth Testcase Test2.feature"
    Then Launch the browser
    And Fetch the URL
    Then Verify the Page loading in site
    Then Close the browser
