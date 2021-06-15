package dk.microquiz.service;

import dk.microquiz.domain.Answer;
import dk.microquiz.domain.Question;
import dk.microquiz.repository.Repository;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Dependent
public class QuestionService {
    private final Repository repository;

    @Inject
    public QuestionService(Repository repository) { this.repository = repository; }

    public Question findById(int id) {
        return repository.getQuestion(id);
    }

    public List<Integer> getQuestions() {
        return repository.getQuestions();
    }

    public void createQuestion(Question question) {
        repository.createQuestion(question);
    }

    public void updateQuestion(int id, Question question) {
        repository.updateQuestion(id, question);
    }
}
