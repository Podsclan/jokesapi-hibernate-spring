package br.com.brendowpodsclan.jokapihib.model;

import java.util.Optional;

public class JokePlusAuthor {

    private int id;
    private String type;
    private String joke;
    private Optional<Author> author;

    public JokePlusAuthor() {
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

    public Optional<Author> getAuthor() {
        return author;
    }

    public void setAuthor(Optional<Author> author) {
        this.author = author;
    }
}
