package br.com.brendowpodsclan.jokapihib.controller;

import br.com.brendowpodsclan.jokapihib.model.*;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Date;


@RestController
@RequestMapping("/jokesAPI")
public class JokesController {

    @Autowired
    JokesDAO dao;

    @Autowired
    JokePlusAuthor joke;

    KProducer kProducer = new KProducer();

    //SHOW ALL DATA

    @RequestMapping(value = "", method = RequestMethod.GET)
    public JokePlusAuthor getAll() {                                //method which return one joke
        Random random = new Random();
        int x = random.nextInt(12) + 1;
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] SHOWED A JOKE");
        return dao.read(x);
    }

    //SHOWING ALL JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/all", method = RequestMethod.GET)
    public List<JokePlusAuthor> getAllJokes() {                       //method which return all jokes on database
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] SHOWED ALL JOKES");
        return dao.readAllJokes();
    }

    @RequestMapping(value = "/authors/all", method = RequestMethod.GET)
    public List<Author> getAllAuthor() {                       //method which return all authors on database
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] SHOWED ALL AUTHORS");
        return dao.readAllAuthors();
    }

    //UPDATING JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/update", method = RequestMethod.PUT, produces = "application/json")
    public void update(@RequestBody Joke aux) {        //method which update some joke's information on database
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "\n[" + ts + "] UPDATED A JOKE \n" +
                "BEFORE:\n" +
                "   JOKE ID:" + dao.read(aux.getId()).getId() +
                "\n JOKE TYPE:" + dao.read(aux.getId()).getType() +
                "\n JOKE:" + dao.read(aux.getId()).getJoke() +
                "\n AUTHOR ID:" + dao.read(aux.getId()).getAuthor().getId() +
                "\n\nNOW:\n" +
                "   JOKE ID:" + aux.getId() +
                "\n JOKE TYPE:" + aux.getType() +
                "\n JOKE:" + aux.getJoke() +
                "\n AUTHOR ID:" + aux.getAuthorid());
        dao.updateJoke(aux);
    }

    @RequestMapping(value = "/authors/update", method = RequestMethod.PUT, produces = "application/json")
    public void update(@RequestBody Author aux) {        //method which update some joke's information on database
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] UPDATED AN AUTHOR");
        dao.updateAuthor(aux);
    }

    //CREATING NEW JOKES OR AUTHORS

    @RequestMapping(value = "/jokes/create", method = RequestMethod.POST, produces = "application/json")
    public void createJoke(@RequestBody Joke aux) {
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] CREATED A JOKE");
        dao.createJoke(aux);
    }

    @RequestMapping(value = "/authors/create", method = RequestMethod.POST, produces = "application/json")
    public void createAuthor(@RequestBody Author aux) {
        dao.createAuthor(aux);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] CREATED AN AUTHOR");
    }

    //DELETING JOKE OR AUTHOR

    @RequestMapping(value = "/jokes/delete", method = RequestMethod.DELETE)
    public void deleteJoke(@RequestParam("id") int id) {
        dao.deleteJoke(id);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] DELETED A JOKE");
    }

    @RequestMapping(value = "/authors/delete", method = RequestMethod.DELETE)
    public void deleteAuthor(@RequestParam("id") int id) {
        dao.deleteAuthor(id);
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
        kProducer.produceMessage(kProducer.createProducer(), "[" + ts + "] DELETED AN JOKE");
    }

}
