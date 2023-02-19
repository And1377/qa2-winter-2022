Feature: Tickets reservation

  Scenario: Successful ticket reservation
    Given flight info:
      | destination | SVO        |
      | departure   | RIX        |
      | discount    | FGHDGD     |
      | adults      | 2          |
      | kids        | 3          |
      | bags        | 2          |
      | flight_date | 14-05-2018 |
      | seat        | 27         |

    And passanger info is:
      | first_name | Dmitry |
      | last_name  | Tester |

    And home page opened

    When we are selecting airports
    Then  selected airports appears on the next page

    When we are filling in apassanger registration form
    And requesting price

    Then passenger name and airports appears
    And price is 500 EUR

    When we are pressing Books button
    And selecting seat

    Then correct seat number appears

    When we are booking selected ticket
    Then successful registration message appears

    When we are requesting reservations data
    Then current reservation is in the list
    And all reservation data is correct
