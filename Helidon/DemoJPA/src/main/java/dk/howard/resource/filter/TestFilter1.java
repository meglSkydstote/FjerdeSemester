package dk.howard.resource.filter;

import javax.annotation.Priority;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Priority(1)// notice prirority
@Provider    // JAX-RS magic annotation that is scanned at deploymenttime
@ConstrainedTo(RuntimeType.SERVER) // Server filter
public class TestFilter1 implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("Filter called: " + this.toString() + "request:" + requestContext);
    }
}
