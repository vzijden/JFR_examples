package nl.ns.jfr;

import io.vertx.core.http.HttpServerRequest;
import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

@Provider
public class RestCallEventFilter implements ContainerRequestFilter {

    @Context
    HttpServerRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        RestCallEvent restCallEvent = new RestCallEvent(
                requestContext.getMethod(),
                httpRequest.remoteAddress().host());
        restCallEvent.commit();
    }
}
