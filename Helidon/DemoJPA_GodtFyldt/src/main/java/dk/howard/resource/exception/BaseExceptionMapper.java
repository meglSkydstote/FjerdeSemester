package dk.howard.resource.exception;

import dk.howard.resource.error.RestError;
import dk.howard.service.exception.Sid;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class BaseExceptionMapper implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(Exception exception) {

        RestError restError = new RestError(
                Sid.GENERAL_SERVER_ERROR.name(),
                exception.getMessage(),
                UUID.randomUUID().toString());
        System.out.println(restError);
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(restError)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }


}
