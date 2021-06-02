# Java flight recorder examples

This project contains examples used in the NLJUG Java Flight Recorder webcast. 

## Topics
This repository contains three example sub-project:

[Basic examples](basics/README.md) demonstrates how to start, obtain and analyse a JFR recording using the commandline tools that come with the JDK or by using JMC (Java Mission Control). It also contains some examples of some common use cases of JVM issues which could be easily found using JFR and JMC.

[Custom events](custom_events/README.md) is an example showing how custom JFR events can be created and used for collecting data that is specific to the domain of your application.

[Streaming events](streaming/README.md) demonstrates the capabilities of the JFR event streaming that is available since JDK 14. This example project streams custom JFR events show that they can be monitored realtime on a dashboard using Grafana and InfluxDB.