## Perquisites
- JDK 8 or later
## Basics
### Creating a dump of a running application
 Start the REST API 
 ```shell
gradle run
```

Start an JFR recording of the running application
```shell
jcmd nl.ns.ApplicationKt JFR.start name=JFRRecording filename=dump.jfr
```

Check an JFR recording of the running application
```shell
jcmd nl.ns.ApplicationKt JFR.check
```

Stop and dump an JFR recording of the running application
```shell
jcmd nl.ns.ApplicationKt JFR.dump name=JFRRecording filename=dump.jfr
```

Open mission control en open dump.jfr
#### Analysing JFR dumps using JDK commandline tools 
#### Note on differences per JDK
### Starting JFR with the start of a JVM
### Attach JFR from Mission Control


## Examples
All example cases can be run through the Gradle Application plugin. This will start the application with JVM options to start a flight recording, which will be dumped to `/tmp/jdrdump-{timestamp}.jfr` upon exit of the application. Each example application will automatically after some time. 

The JVM options used are
```shell
-Xmx128m
-XX:StartFlightRecording=dumponexit=true,filename=/tmp/jfrdump.jfr,path-to-gc-roots=true
```
### [Memory allocation / Garbage collection](memory/src/main/java/nl/ns/jfr/Main.java)
Start the application with:
```shell
gradlew :basics:memory:run
```
### [Monitor hot methods](hotmethods/src/main/java/nl/ns/jfr/Main.java)
Start the application with:
```shell
gradlew :basics:hotmethods:run
```
