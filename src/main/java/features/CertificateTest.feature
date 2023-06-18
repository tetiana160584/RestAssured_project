@CertPositiveCase
Feature:Certificate verification
  Scenario:Positive case
    When I enter certificate number"45924126"
    Then Verification  certificate "true"


    Scenario Outline:
    When I enter negative certificate number <NUMBER>
    Then I check <RESULT> "true"
    And  I check <RESULT> "false"
    Examples:
      | NUMBER   | RESULT |
      | 45924126 | true   |
      | 78008248 | true   |
      | 000      | false  |
      | 122      | false  |
      | 1R2y     | false  |

