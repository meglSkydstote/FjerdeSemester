package dk.microquiz.resource;

import dk.microquiz.domain.Question;
import dk.microquiz.resource.dto.QuestionDTO;
import dk.microquiz.service.QuestionService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/questions")
public class QuestionResource {
    private final QuestionService service;
    private final Mapper mapper;

    @Inject
    public QuestionResource(QuestionService service, Mapper mapper) {
        // Domain
        this.service = service;
        // DTO
        this.mapper = mapper;
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public QuestionDTO findById(@PathParam("id") int id) {
        return mapper.map(service.findById(id));
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Integer> getAll() {
         return service.getQuestions();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createQuestion(QuestionDTO questionDTO) {
        Question question = mapper.map(questionDTO);
        service.createQuestion(question);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateQuestion(@PathParam("id") int id, QuestionDTO questionDTO) {
        Question question = mapper.map(questionDTO);
        service.updateQuestion(id, question);
    }

}