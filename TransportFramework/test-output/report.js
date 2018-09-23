$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Transport/TripPlanner.feature");
formatter.feature({
  "line": 1,
  "name": "Trip Request",
  "description": "",
  "id": "trip-request",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "A trip request can be executed and results returned",
  "description": "",
  "id": "trip-request;a-trip-request-can-be-executed-and-results-returned",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Phileas is planning a trip",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he executes a trip plan from \"\u003cfrom_station\u003e\" to \"\u003cto_station\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a list of trips should be provided",
  "keyword": "Then "
});
formatter.examples({
  "line": 10,
  "name": "",
  "description": "",
  "id": "trip-request;a-trip-request-can-be-executed-and-results-returned;",
  "rows": [
    {
      "cells": [
        "from_station",
        "to_station"
      ],
      "line": 11,
      "id": "trip-request;a-trip-request-can-be-executed-and-results-returned;;1"
    },
    {
      "cells": [
        "North Sydney Station",
        "Town Hall Station"
      ],
      "line": 12,
      "id": "trip-request;a-trip-request-can-be-executed-and-results-returned;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 3912838390,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "A trip request can be executed and results returned",
  "description": "",
  "id": "trip-request;a-trip-request-can-be-executed-and-results-returned;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 5,
  "name": "Phileas is planning a trip",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he executes a trip plan from \"North Sydney Station\" to \"Town Hall Station\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "a list of trips should be provided",
  "keyword": "Then "
});
formatter.match({
  "location": "TripPlanStepDefinition.phileas_is_planning_a_trip()"
});
formatter.result({
  "duration": 5609258975,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "North Sydney Station",
      "offset": 30
    },
    {
      "val": "Town Hall Station",
      "offset": 56
    }
  ],
  "location": "TripPlanStepDefinition.he_executes_a_trip_plan_from_to(String,String)"
});
formatter.result({
  "duration": 5897800772,
  "status": "passed"
});
formatter.match({
  "location": "TripPlanStepDefinition.a_list_of_trips_should_be_provided()"
});
formatter.result({
  "duration": 3976616709,
  "status": "passed"
});
formatter.after({
  "duration": 1575769224,
  "status": "passed"
});
});