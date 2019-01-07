package br.com.brendowpodsclan.jokapihib.repository;

import br.com.brendowpodsclan.jokapihib.model.Joke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface JokeRepository extends JpaRepository<Joke, Integer> {

//    @Modifying
//    @Transactional
//    @Query("update Joke j set j.type = ?1, j.joke = ?2, j.authorid = ?3 where j.id = ?4")
//    int updateJoke(String type, String joke, int authorid, int id);

}
