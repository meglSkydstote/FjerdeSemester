package dk.microquiz.repository.entity;


import javax.persistence.*;

@Entity
@Table(name = "options")
public class OptionPO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "optionText", columnDefinition = "VARCHAR(255)", nullable = false)
    private String optionText;

    @ManyToOne
    @JoinColumn(name = "questionId_FK", nullable = false)
    private QuestionPO question;

    @Column(name = "isCorrect", columnDefinition = "boolean", nullable = false)
    private boolean isCorrect;

    public OptionPO() {
    }

    public OptionPO(String optionText, boolean isCorrect) {
        this.optionText = optionText;
        this.isCorrect = isCorrect;
    }

    public int getId() {
        return id;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean isCorrect) {
        this.isCorrect = isCorrect;
    }

    public void setQuestion(QuestionPO question) {
        this.question = question;
    }
}
