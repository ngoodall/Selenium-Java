Feature: WebForm
  As a user of the system.
  I want to interact with the web form.
  So that I can complete a submit the form.

  Background:
    Given I have navigated to "https://www.selenium.dev/selenium/web/web-form.html" website

  @SmokeTest
  Scenario: Short Form Submission
    When I enter "Testing..." into "Text input" field
    And I click the "Submit" button
    Then The header "Recieved" text is displayed

  Scenario: Full Form Submission
    When I enter "Testing..." into "Text input" field
    And I enter "Password..." into "Password" field
    And I enter "Testing1234567890" into "Textarea" field
    And I select "Two" from the "Dropdown (select)" dropdown
    And I enter "San Francisco" into "Dropdown (datalist)" field
    And I upload "ImageFile" file
    And I select the "Checked checkbox" option
    And I select the "Default checkbox" option
    And I select the "Default radio" option
    And I enter "#BB8872" into "Color picker" field
    And I enter "9" into "Example range" field
    And I enter "04/01/2024" into "Date picker" field
    And I click the "Submit" button
    Then The header "Recieved" text is displayed

  Scenario Outline: File Types - <FileType>
    When I upload "<FileType>" file
    And I click the "Submit" button
    Then The header "Recieved" text is displayed
  Examples:
    | FileType |
    | ImageFile|
    | TextFile |
    | WordFile |
