## Perquisites
## Basics
### Creating a dump of a running application
 Start the REST API 
 ```shell
gradle run
```

Start an JFR recording of the running application
```shell
jcmd nl.ns.ApplicationKt JFR.start name=1 filename=dump.jfr
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

### Attach JFR from Mission Control


## Example cases
### Monitor hot methods 