package br.com.brendowpodsclan.jokapihib.model;

import br.com.brendowpodsclan.jokapihib.repository.AuthorRepository;
import br.com.brendowpodsclan.jokapihib.repository.JokeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class JokesDAO {
    @Autowired
    JokeRepository jokeRepository;
    @Autowired
    AuthorRepository authorRepository;

    public JokePlusAuthor read(int id) {
        JokePlusAuthor j = setJoke(jokeRepository.getOne(id));
        return j;
    }


    public List<JokePlusAuthor> readAllJokes() {

        List<Joke> list = jokeRepository.findAll();
        List<JokePlusAuthor> listAux = new ArrayList<>();
        for (Joke joke : list) {
            JokePlusAuthor j = setJoke(joke);
            listAux.add(j);
        }
        return listAux;
    }

    public List<Author> readAllAuthors() {
        return authorRepository.findAll();
    }

    public JokePlusAuthor setJoke(Joke joke) {
        JokePlusAuthor j = new JokePlusAuthor();
        Optional<Author> author = authorRepository.findById(joke.getAuthorid());
        j.setId(joke.getId());
        j.setType(joke.getType());
        j.setJoke(joke.getJoke());
        j.setAuthor(author);
        return j;
    }

    public void updateJoke(Joke aux) {
        jokeRepository.save(aux);
    }

    public void updateAuthor(Author aux) {
        authorRepository.save(aux);
    }

    public void deleteJoke(int id) {
        jokeRepository.deleteById(id);
    }

    public void deleteAuthor(int id) {
        authorRepository.deleteById(id);
    }

    public void createJoke(Joke aux) {
        jokeRepository.save(aux);
    }

    public void createAuthor(Author aux) {
        authorRepository.save(aux);
    }

}
