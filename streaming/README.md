# Event streaming
This project demonstrates the capabilities of the JFR event streaming that is available since JDK 14. In this example, custom JFR from a webservice are streamed to a realtime dashboard using Grafana and InfluxDB.

### Note on event streaming and performance
#### Comparison with performance of other realtime monitoring solutions?

## Running
### Starting the dashboard
This project uses Docker to provide the InfluxDB and Grafana services.

```shell
docker compose up
```

The Grafana dashboard can be accessed at [localhost:3000](localhost:3000)
### Starting the webservice
````shell
gradlew :streaming:quarkusDev
````
The webservice exposes a single endpoint at [localhost:8080/hoiRick](localhost:8080/hoiRick)
### Monitoring events


## Perquisites
- JDK 14 or later
- Docker 
