package dk.microquiz.resource;

import dk.microquiz.domain.Answer;
import dk.microquiz.domain.Option;
import dk.microquiz.domain.Question;
import dk.microquiz.resource.dto.AnswerDTO;
import dk.microquiz.resource.dto.OptionDTO;
import dk.microquiz.resource.dto.QuestionDTO;
import dk.microquiz.resource.dto.QuizQuestionDTO;

import javax.enterprise.context.Dependent;
import java.util.List;
import java.util.stream.Collectors;

@Dependent
public class Mapper {

    public QuestionDTO map(Question question) {
        return new QuestionDTO(
                question.getId(),
                question.getCategory(),
                question.getQuestionText(),
                question.getField(),
                question.getPoints(),
                question.getExplanation(),
                question.getSource_url(),
                mapOptions(question.getOptions())
        );
    }

    public Question map(QuestionDTO questionDTO) {
        List<Option> options = mapOptionList(questionDTO.getOptions());
        return new Question(
                questionDTO.getId(),
                questionDTO.getCategory(),
                questionDTO.getQuestionText(),
                questionDTO.getField(),
                questionDTO.getPoints(),
                questionDTO.getExplanation(),
                questionDTO.getSource_url(),
                options
        );
    }

    public List<QuestionDTO> map(List<Question> questions) {
        return questions.stream()
                .map(q -> map(q))
                .collect(Collectors.toList());
    }

    public Option map(OptionDTO optionDTO) {
        Option option = new Option();
        option.setId(optionDTO.getId());
        option.setOptionText(optionDTO.getOptionText());
        option.setCorrect(optionDTO.isCorrect());
        return option;
    }

    public List<Option> mapOptionList(List<OptionDTO> optionDTOs) {
        return optionDTOs.stream()
                .map(o -> map(o))
                .collect(Collectors.toList());
    }

    public OptionDTO map(Option option) {
       return new OptionDTO(option.getId(), option.getOptionText(), option.isCorrect());
    }

    public List<OptionDTO> mapOptions(List<Option> options) {
        return options.stream()
            .map(o -> map(o))
            .collect(Collectors.toList());
    }

    public AnswerDTO map(Answer answer) {
        return new AnswerDTO(answer.isCorrect(), answer.getExplanation(), answer.getSource_url());
    }

    public QuizQuestionDTO mapQuizQuestion(Question question){
        return new QuizQuestionDTO(question.getId(),
                question.getCategory(),
                question.getQuestionText(),
                question.getField(),
                question.getPoints(),
                mapOptions(question.getOptions())
        );
    }
}
