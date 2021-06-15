package dk.microquiz.repository;

import dk.microquiz.domain.Option;
import dk.microquiz.domain.Question;
import dk.microquiz.repository.entity.OptionPO;
import dk.microquiz.repository.entity.QuestionPO;

import java.util.stream.Collectors;

public class Mapper {

    public Option map(OptionPO optionPO) {
        return new Option(optionPO.getId(), optionPO.getOptionText(), optionPO.isCorrect());
    }

    public OptionPO map(Option option) {
        return new OptionPO(option.getOptionText(), option.isCorrect());
    }

    public Question map(QuestionPO questionPO) {
        return new Question(
                questionPO.getId(),
                questionPO.getCategory(),
                questionPO.getQuestionText(),
                questionPO.getField(),
                questionPO.getPoints(),
                questionPO.getExplanation(),
                questionPO.getSource_url(),
                questionPO.getOptions().stream().map(this::map).collect(Collectors.toList())
        );
    }

}
