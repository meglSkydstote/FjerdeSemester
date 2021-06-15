package dk.microquiz.service;

import dk.microquiz.domain.Answer;
import dk.microquiz.domain.Question;
import dk.microquiz.repository.Repository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class QuizService {
    private final Repository repository;

    @Inject
    public QuizService(Repository repository) {
        this.repository = repository;
    }

    public Question findById(int id) {
        return repository.getQuestion(id);
    }

    public List<Integer> getQuestions() {
        return repository.getQuestions();
    }


    public Answer getAnswerForQuestion(int questionId, int optionId) {
        return repository.getAnswerForQuestion(questionId, optionId);
    }
}
