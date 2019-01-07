package br.com.brendowpodsclan.jokapihib.controller;

import br.com.brendowpodsclan.jokapihib.model.Author;
import br.com.brendowpodsclan.jokapihib.model.Joke;
import br.com.brendowpodsclan.jokapihib.model.JokePlusAuthor;
import br.com.brendowpodsclan.jokapihib.model.JokesDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/jokesAPI")
public class JokesController {

    @Autowired
    JokesDAO dao;

    //SHOW ALL DATA

    @RequestMapping(value = "", method = RequestMethod.GET)
    public JokePlusAuthor getAll() {                                //method which return one joke
        Random random = new Random();
        int x = random.nextInt(12) + 1;
        return dao.read(x);
    }

    //SHOWING ALL JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/all", method = RequestMethod.GET)
    public List<JokePlusAuthor> getAllJokes() {                       //method which return all jokes on database
        return dao.readAllJokes();
    }

    @RequestMapping(value = "/authors/all", method = RequestMethod.GET)
    public List<Author> getAllAuthor() {                       //method which return all authors on database
        return dao.readAllAuthors();
    }

    //UPDATING JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/update", method = RequestMethod.PUT, produces = "application/json")
    public void update(@RequestBody Joke aux) {        //method which update some joke's information on database
        dao.updateJoke(aux);
    }

    @RequestMapping(value = "/authors/update", method = RequestMethod.PUT, produces = "application/json")
    public void update(@RequestBody Author aux) {        //method which update some joke's information on database
        dao.updateAuthor(aux);
    }

    //CREATING NEW JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/create", method = RequestMethod.POST, produces = "application/json")
    public void createJoke(@RequestBody Joke aux) {
        dao.createJoke(aux);
    }

    @RequestMapping(value = "/authors/create", method = RequestMethod.POST, produces = "application/json")
    public void createAuthor(@RequestBody Author aux) {
        dao.createAuthor(aux);
    }

    //DELETING JOKE OR AUTHOR

    @RequestMapping(value = "/jokes/delete", method = RequestMethod.DELETE)
    public void deleteJoke(@RequestParam("id") int id) {
        dao.deleteJoke(id);
    }

    @RequestMapping(value = "/authors/delete", method = RequestMethod.DELETE)
    public void deleteAuthor(@RequestParam("id") int id) {
        dao.deleteAuthor(id);
    }

}
