# GC example
## Perquisites
- JDK 8 or later
- Java Mission Control 8

## Creating an JFR dump
### Start this example with JFR from the commandline
Compile executable jars using Gradle
```shell
gradlew :basics:memory:jar
```
To launch the application with JFR and directly start a dump.

```shell
java -Xmx250m -XX:StartFlightRecording=dumponexit=true,filename=/tmp/dumpMemory.jfr,disk=true,settings=profile -jar build/libs/memory.jar 
```
This will create a JFR dump using the preconfigured 'profiling' configuration. JFR wil write the dump file to `/tmp/dumpMemory.jfr` after the program has exited. The next step is to use this file to analyse your application, see [Analysing the JFR dump](#analysing-the-jfr-dump)

### Run the example using Gradle
This example can also be launched using the Gradle Application plugin. This will start the application with JVM options to start a flight recording, which will be dumped to `/tmp/jdrdump-{timestamp}.jfr` upon exit of the application. Each example application will automatically after some time.

The JVM options used are
```shell
-Xmx128m
-XX:StartFlightRecording=dumponexit=true,filename=/tmp/jfrdump.jfr,path-to-gc-roots=true
```

Start the application with:
```shell
gradlew :basics:memory:run
```

## Analysing the JFR dump
### Using JDK commandline tools
It is possible extract various insights from a JFR dump using the JDK's `jfr` commandline application.

To print a summary of events present in the dump file run:
```shell
jfr summary /tmp/dumpMemory.jfr
```

To print information collected by a specific category of events, in this case the `Profiling` events, use:
```shell
jfr print --categories GC /tmp/dumpMemory.jfr
```

To print information collected by a specific event, in this case the `jdk.GarbageCollection` event, use:
```shell
jfr print --events GarbageCollection /tmp/dumpMemory.jfr
```
### Using Mission Control's Flame View
Start Java Mission Control

1. Go to `file -> Open File..`
2. Navigate to `/tmp/` and select `dump.jfr`
3. Select `Memory` in the outline window 
4. Sort the memory view by clicking the column `Total Allocation`
5. Can you spot anything noteworthy in this view?


## Note on differences per JDK


