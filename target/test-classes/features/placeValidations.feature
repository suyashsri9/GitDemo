Feature: Vaidating Place API's

@AddPlace @Regression
Scenario Outline: Veriy if place is being successfully added using AddPlaceAPI
Given Add Place Payload with "<name>" "<language>" "<address>"
When user calls "AddPlaceAPI" with "POST" http request
Then the API call is success with status code 200
And "status" in response body is "OK"
And "scope" in response body is "APP"
And Verify palce ID is created maps to "<name>" using "getPlcaeAPI"


Examples:

	|name	|language	|address	|
	|AAhouse|English	|Prayagraj	|
#	|BBhouse|hindi		|Lucknow	|


@DeletePlace  @Regression
Scenario: Verify if Delete Place functionality is working
Given DeletePlace payload
When user calls "deletePlaceAPI" with "POST" http request
Then the API call is success with status code 200
And "status" in response body is "OK"