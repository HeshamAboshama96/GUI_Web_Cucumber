Feature: Subscription packages
    Background: "Open the browser then navigate to subscribtion page"
      Given I Open the target browser
      When I navigate to subscribtion page.
      
      
     Scenario: "Change the country then verify that the country is selected, plans names are correct, plans prices are correct and prices currency are correct."
      Then Verify that the country selected is KSA.
      When Click on the country button.
      And Choose <newCountry> Country.
      Then Verify that the country selected is <newCountry>.
      And Verify that plans names are correct.
      And Check that the planes prices of <newCountry> country are correct.
      And Check that the prices currency of <newCountry> country are correct.
      
Examples:
  | existingCountry | newCountry |
  | KSA             | Bahrain    |
  | Bahrain         | Kuwait     |
  | Kuwait          | KSA        |