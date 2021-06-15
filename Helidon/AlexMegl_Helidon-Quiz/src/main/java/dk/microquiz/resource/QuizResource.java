package dk.microquiz.resource;

import dk.microquiz.resource.dto.AnswerDTO;
import dk.microquiz.resource.dto.QuizQuestionDTO;
import dk.microquiz.service.QuizService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/quiz")
public class QuizResource {
    private final QuizService service;
    private final Mapper mapper;

    @Inject
    public QuizResource(QuizService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Integer> getAll() {
        return service.getQuestions();
    }

    @GET
    @Path("/{questionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public QuizQuestionDTO findQuizQuestionById(@PathParam("questionId") int id) {
        return mapper.mapQuizQuestion(service.findById(id));
    }

    @POST
    @Path("/{questionId}/answer")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AnswerDTO getAnswerForQuestion(@PathParam("questionId") int questionId, @QueryParam("optionId") int optionId) {
        return mapper.map(service.getAnswerForQuestion(questionId, optionId));
    }

}