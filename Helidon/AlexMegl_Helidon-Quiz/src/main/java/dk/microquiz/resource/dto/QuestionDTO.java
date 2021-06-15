package dk.microquiz.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Set;

public class QuestionDTO {

    private int id;
    private final String category;
    private final String questionText;
    private final String field;
    private final int points;
    private final String explanation;
    private final String source_url;
    private final List<OptionDTO> options;

    @JsonCreator
    public QuestionDTO(
            @JsonProperty("id") int id,
            @JsonProperty("category") String category,
            @JsonProperty("questionText") String questionText,
            @JsonProperty("field") String field,
            @JsonProperty("points") int points,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("source_url") String source_url,
            @JsonProperty("options") List<OptionDTO> options
    ) {
        this.id = id;
        this.category = category;
        this.questionText = questionText;
        this.field = field;
        this.points = points;
        this.explanation = explanation;
        this.source_url = source_url;
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

    public String getExplanation() {
        return explanation;
    }

    public String getSource_url() {
        return source_url;
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
                ", explanation='" + explanation + '\'' +
                ", source_url='" + source_url + '\'' +
                ", options=" + options +
                '}';
    }
}
