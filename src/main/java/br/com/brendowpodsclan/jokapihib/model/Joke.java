package br.com.brendowpodsclan.jokapihib.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "joke")
public class Joke {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "JOKE_ID")
    private int id;

    @Column(name = "JOKE_TYPE")
    private String type;

    @Column(name = "JOKE_JOKE")
    private String joke;

    @Column(name = "JOKE_AUTHORID")
//    @ManyToOne
    private int authorid;

    public Joke(int id, String type, String joke, int authorid) {
        this.id = id;
        this.type = type;
        this.joke = joke;
        this.authorid = authorid;
    }

    public Joke() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJoke() {
        return joke;
    }

    public void setJoke(String joke) {
        this.joke = joke;
    }

    public int getAuthorid() {
        return authorid;
    }

    public void setAuthorid(int author) {
        this.authorid = author;
    }
}
