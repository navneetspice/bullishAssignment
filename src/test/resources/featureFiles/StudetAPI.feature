Feature: Test API
  Scenario: Test the get API
    Given I Launch the get API
    When Response code is 200 OK


  Scenario Outline: Test the put API
    Given I Launch the put API "<id>" "<firstName>"
    When Response code is 200 OK
    Examples:
      | id   | firstName |
      | 101  | Tango     |
      | 102  | Charlie   |

  Scenario Outline: Test the post API
    Given I Launch the post API "<id>" "<firstName>" "<lastName>" "<studentClass>" "<nationality>"
    When Response code is 200 OK
    Examples:
      | id   | firstName    | lastName| studentClass | nationality |
      | 121 | Navneet1      | Sh1     | 1 C          | Singapore   |
      | 122 | Navneet2      | Sh2     | 1 C          | Singapore   |
      | 123 | Navneet3      | Sh3     | 1 C          | Singapore   |
      | 124 | Navneet4      | Sh4     | 1 C          | Singapore   |

  Scenario Outline: Test the delete API
    Given I Launch the delete API with id "<id>"
    When Response code is 200 OK
    Examples:
    | id  |
    | 121 |
    | 122 |
    | 123 |
    | 124 |