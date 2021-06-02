# Creating custom JFR events
This is an example demonstrating how custom JFR events can be created and used for collecting data that is specific to the domain of your application.

This project shows a very simple webservice that consists of:
- a custom JFR event: [RestCallEvent](src/main/java/nl/ns/jfr/RestCallEvent.java)
- an endpoint: [RestEndpoint](src/main/java/nl/ns/jfr/RestEndpoint.java)
- a request filter: [RestCallEventFilter](src/main/java/nl/ns/jfr/RestCallEventFilter.java) that submits our custom event for each invocation of our webservice.
## Perquisites
- JDK 9 or later
## Running

Start the REST APi with

```shell
gradlew :custom_events:quarkusDev
```
The webservice exposes a single endpoint at [localhost:8080/hoiRick](localhost:8080/hoiRick)

## Analysing the custom events
### Using commandline tools
### Using JMC
