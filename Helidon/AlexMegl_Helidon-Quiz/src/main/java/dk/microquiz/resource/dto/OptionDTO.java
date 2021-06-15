package dk.microquiz.resource.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OptionDTO {
    private int id;
    private String optionText;
    private boolean isCorrect;

    @JsonCreator
    public OptionDTO(
            @JsonProperty("id") int id,
            @JsonProperty("optionText") String optionText,
            @JsonProperty("correct") boolean isCorrect
    ) {
        this.id = id;
        this.optionText = optionText;
        this.isCorrect = isCorrect;
    }

    public int getId() {
        return id;
    }

    public String getOptionText() {
        return optionText;
    }

    public boolean isCorrect() { return  isCorrect; }

}
