package dk.microquiz.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AnswerDTO {
    private boolean isCorrect;
    private String explanation;
    private String source_url;

    @JsonCreator
    public AnswerDTO(
            @JsonProperty("isCorrect") boolean isCorrect,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("source_url") String source_url
    ) {
        this.isCorrect = isCorrect;
        this.explanation = explanation;
        this.source_url = source_url;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getSource_url() {
        return source_url;
    }
}
