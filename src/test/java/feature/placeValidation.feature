Feature: Validating plce API's

  Scenario Outline: Varify add place is being succesfully added using addPlaceAPI
    Given Add place payload with "<name>" "<language>" "<address>"
    When User calls "addplaceAPI" with "post" http request
    Then the API call got success with status code 200
    And "status" is "OK"
    And "scope" is "APP"
    And verify place_id created maps to "<name>" using "getPlaceAPI"

    Examples: 
      | name    | language | address |
      | shivaji | English  | Vashi   |

  Scenario: Varify delete place payload 
    Given: DeletePlace playload
    When User calls "deletePlaceAPI" with "post" http request
    Then the API call got succsssess with status code 200
    And "status" is "OK"
