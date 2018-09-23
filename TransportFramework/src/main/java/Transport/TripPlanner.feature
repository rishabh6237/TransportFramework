Feature:  Trip Request

Scenario Outline:  A trip request can be executed and results returned

Given Phileas is planning a trip
When he executes a trip plan from "<from_station>" to "<to_station>"
Then a list of trips should be provided


Examples:
	|from_station 	     |to_station           |
	|North Sydney Station|Town Hall Station    |
