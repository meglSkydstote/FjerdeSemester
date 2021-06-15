package dk.microquiz.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question {

    private int id;
    private String category;
    private String questionText;
    private String field;
    private int points;
    private String explanation;
    private String source_url;
    private List<Option> options;

    public Question() { }

    public Question(int id, String category, String questionText, String field, int points, String explanation, String source_url, List<Option> options) {
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

    public void setCategory(String category) {
        this.category = category;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
