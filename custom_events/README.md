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
The webservice exposes a single endpoint at [localhost:8080/hiRick](localhost:8080/hoiRick)

## Attaching JFR to a running application
It's possible to start a JFR dump of a running application using JMC:
1. Expand the custom_events application from the _JVM Browser_ tab
2. Double click _Flight Recorder_
3. Check the radio button for _continuous recording_.
4. Now that the recording has started, invoke the endpoint at [localhost:8080/hiRick](localhost:8080/hoiRick) a couple of times.
5. Create a dump of the recording by expanding the _Flight recorder_ and double-clicking _My Recording_ in the JVM Browser.
6. The dump will be opened in JMC automatically
## Analysing the custom events in JMC
1. In the _Outline_ window select _Event Browser_
2. Scroll down and expand _custom_events_
3. Select _nl.ns.jfr.RestCallEvent_.
4. Table view on the right shows the duration, ip-address and other data we have included in each 'RestCallEvent' produced by our application.
