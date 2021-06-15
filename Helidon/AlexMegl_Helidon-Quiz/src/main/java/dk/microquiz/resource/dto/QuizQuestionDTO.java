package dk.microquiz.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import dk.microquiz.domain.Option;

import java.util.List;
import java.util.Set;

public class QuizQuestionDTO {

    private int id;
    private final String category;
    private final String questionText;
    private final String field;
    private final int points;
    private final List<OptionDTO> options;

    @JsonCreator
    public QuizQuestionDTO(
            @JsonProperty("id") int id,
            @JsonProperty("category") String category,
            @JsonProperty("questionText") String questionText,
            @JsonProperty("field") String field,
            @JsonProperty("points") int points,
            @JsonProperty("options") List<OptionDTO> options
    ) {
        this.id = id;
        this.category = category;
        this.questionText = questionText;
        this.field = field;
        this.points = points;
        this.options = options;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getQuestionText() {
        return questionText;
    }

    public String getField() {
        return field;
    }

    public int getPoints() {
        return points;
    }

    public List<OptionDTO> getOptions() {
        return options;
    }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", questionText='" + questionText + '\'' +
                ", field='" + field + '\'' +
                ", points=" + points +
                ", options=" + options +
                '}';
    }
}

