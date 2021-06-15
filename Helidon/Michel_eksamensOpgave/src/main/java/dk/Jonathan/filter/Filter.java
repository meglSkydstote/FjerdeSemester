package dk.Jonathan.filter;

import javax.annotation.Priority;
import javax.ws.rs.ConstrainedTo;
import javax.ws.rs.Priorities;
import javax.ws.rs.RuntimeType;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.HEADER_DECORATOR)
@ConstrainedTo(RuntimeType.SERVER)
public class Filter implements ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        System.out.println("CORSFILTER CALLED");
        responseContext.getHeaders().addAll("Access-Control-Allow-Headers", "content-type", "authorization", "Authorization");
        responseContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
        responseContext.getHeaders().addAll("Access-Control-Allow-Origin", "http://localhost:3000");
                responseContext.getHeaders().addAll("Access-Control-Allow-Methods", "PUT", "POST", "GET", "PATCH", "OPTION");
    }
}
