package nl.ns.jfr;


import jdk.jfr.Category;
import jdk.jfr.Event;
import jdk.jfr.Label;

@Category("custom_events")
public class RestCallEvent extends Event {

    private static final String NAME = "REST_CALL_EVENT";

    @Label("endpoint")
    private String endpoint;

    public RestCallEvent(String endpoint) {
        this.endpoint = endpoint;
    }

    public static String getNAME() {
        return NAME;
    }
}
