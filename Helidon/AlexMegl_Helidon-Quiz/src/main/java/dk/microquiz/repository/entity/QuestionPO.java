package dk.microquiz.repository.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "questions")
public class QuestionPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "category", columnDefinition = "VARCHAR(255)", nullable = false)
    private String category;

    @Column(name = "questionText", columnDefinition = "VARCHAR(255)", nullable = false)
    private String questionText;

    @Column(name = "field", columnDefinition = "VARCHAR(255)", nullable = false)
    private String field;

    @Column(name = "points", columnDefinition = "int", nullable = false)
    private int points;

    @Column(name = "explanation", columnDefinition = "VARCHAR(255)", nullable = false)
    private String explanation;

    @Column(name = "source_url", columnDefinition = "VARCHAR(255)", nullable = false)
    private String source_url;

    @OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
    private Set<OptionPO> options;

    public QuestionPO(){
        // JPA
    }

    public QuestionPO(String category, String questionText, String field, int points, String explanation, String source_url) {
        this.category = category;
        this.questionText = questionText;
        this.field = field;
        this.points = points;
        this.explanation = explanation;
        this.source_url = source_url;
        options = new HashSet<OptionPO>();
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

    public Set<OptionPO> getOptions() {
        return options;
    }

    public void addOption(OptionPO option) {
        option.setQuestion(this);
        getOptions().add(option);
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }
}
