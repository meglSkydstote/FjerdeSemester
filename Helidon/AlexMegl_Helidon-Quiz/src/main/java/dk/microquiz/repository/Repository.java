package dk.microquiz.repository;

import dk.microquiz.domain.Answer;
import dk.microquiz.domain.Option;
import dk.microquiz.domain.Question;
import dk.microquiz.repository.entity.OptionPO;
import dk.microquiz.repository.entity.QuestionPO;
import dk.microquiz.repository.entitymanager.MsSqlEntityManager;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;


@Dependent
public class Repository {
    private final EntityManager entityManager;
    private Mapper mapper;

    @Inject
    public Repository(MsSqlEntityManager entityManager) {
        this.entityManager = entityManager.getEntityManager();
        mapper = new Mapper();
    }

    ///////////////////
    /// Questions

    // Kunne sagtens returnere QuestionPOs, men vi ønsker flere kald mellem services
    public List<Integer> getQuestions() {
        final List<Integer> questionsPOs = this.entityManager.createQuery("SELECT a.id FROM QuestionPO a").getResultList();
        return questionsPOs;
    }

    public Question getQuestion(int id) {
        return mapper.map(entityManager.find(QuestionPO.class, id));
    }


    public void updateQuestion(int id, Question question) {
        QuestionPO questionPO = entityManager.find(QuestionPO.class, id);
        questionPO.setCategory(question.getCategory());
        questionPO.setQuestionText(question.getQuestionText());
        questionPO.setField(question.getField());
        questionPO.setPoints(question.getPoints());
        questionPO.setExplanation(question.getExplanation());
        questionPO.setSource_url(question.getSource_url());

        question.getOptions().forEach(this::updateOptionPO);
    }

    public void createQuestion(Question question) {
        QuestionPO questionPO = new QuestionPO(
                question.getCategory(),
                question.getQuestionText(),
                question.getField(),
                question.getPoints(),
                question.getExplanation(),
                question.getSource_url()
        );

        question.getOptions().stream().forEach(o -> questionPO.addOption(mapper.map(o)));
        entityManager.persist(questionPO);
        questionPO.getOptions().forEach(entityManager::persist);
    }

    ///////////////////
    /// Option
    public Option getOption(int id) {
        return mapper.map(entityManager.find(OptionPO.class, id));
    }

    private void updateOptionPO(Option option) {
        OptionPO optionPO = entityManager.find(OptionPO.class, option.getId());
        optionPO.setOptionText(option.getOptionText());
        optionPO.setCorrect(option.isCorrect());
    }
    ///////////////////
    /// Answer

    public Answer getAnswerForQuestion(int questionId, int optionId) {
        Question question = getQuestion(questionId);
        Option option = getOption(optionId);
        return new Answer(question, option);
    }

}

