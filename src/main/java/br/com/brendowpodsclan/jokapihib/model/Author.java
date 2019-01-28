package br.com.brendowpodsclan.jokapihib.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "author")
public class Author {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "AUTHOR_ID")
    private int id;
    @Column(name = "AUTHOR_NAME")
    private String name;

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Author() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
