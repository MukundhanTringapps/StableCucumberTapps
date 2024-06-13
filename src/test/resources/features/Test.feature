Feature: Clear The Shelters Home Page

  Scenario Outline: Verify window title in the CLEAR THE SHELTERS site
    Given TC number <TC_number> and Title <TC_title>
    Then Launch the browser
    And Fetch the URL
    Then Verify the home page title in site
    Then Close the browser

    Examples: 
      | TC_number | TC_title       |
      | TC 001    | First Testcase |

  Scenario: To verify page loading in the CLEAR THE SHELTERS site
    Given TC number "TC 002" and title "Second Testcase"
    Then Launch the browser
    And Fetch the URL
    Then Verify the Page loading in site
    Then Close the browser