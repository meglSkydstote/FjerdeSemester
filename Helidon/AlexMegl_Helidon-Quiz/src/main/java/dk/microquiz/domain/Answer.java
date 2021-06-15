package dk.microquiz.domain;

public class Answer {
    private boolean isCorrect;
    private String explanation;
    private String source_url;

    public Answer(Question question, Option option) {
       isCorrect = option.isCorrect();
       explanation = question.getExplanation();
       source_url = question.getSource_url();
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
