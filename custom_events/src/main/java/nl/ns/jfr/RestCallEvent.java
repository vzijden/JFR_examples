package nl.ns.jfr;


import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;

@Category("custom_events")
public class RestCallEvent extends Event {

    private static final String NAME = "REST_CALL_EVENT";

    @Label("endpoint")
    private final String endpoint;

    @Label("ip")
    private final String ip;

    public RestCallEvent(String endpoint, String ip) {
        this.endpoint = endpoint;
        this.ip = ip;
    }

    public static String getNAME() {
        return NAME;
    }

    public String getIp() {
        return ip;
    }
}
