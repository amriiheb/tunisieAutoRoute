package tn.Proxym.ProxymAcademy.model;

import javax.persistence.*;

@Entity
@Table(name="question_quiz")
public class Question_Quiz {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id ;


@ManyToOne
@JoinColumn(name="id_quiz", referencedColumnName = "id")
private Quiz quiz ;

@Column(name = "title")
private String title ;

@Column(name = "question")
private String question ;


@Column(name = "response")
    private String response ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
