Feature: Search for AUDI A4

  @searchforA4
  Scenario Outline: Searching for Audi A4 on Autopapa.ge
    Given I am on Autopapa.ge home page
    Then I select all mandatory fields <make>,<model>,<yearFrom> and <yearTo>
    Then I click on Search button and assert that there is only one car with exact <expectedPrice>

    Examples: 
      | make   | model | yearFrom | yearTo | expectedPrice |
      | "Audi" | "A4"  | "2017"   | "2019" | "5500"        |
