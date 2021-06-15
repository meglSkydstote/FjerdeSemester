package dk.howard.resource.exception;

import dk.howard.resource.error.RestError;
import dk.howard.service.exception.InputException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.UUID;

@Provider
public class InputExceptionMapper implements ExceptionMapper<InputException> {

    @Override
    public Response toResponse(InputException exception) {


        RestError restError = new RestError(
                exception.getSid().name(),
                exception.getMessage(),
                UUID.randomUUID().toString());
        System.out.println(restError);

        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity(restError)
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }


}
