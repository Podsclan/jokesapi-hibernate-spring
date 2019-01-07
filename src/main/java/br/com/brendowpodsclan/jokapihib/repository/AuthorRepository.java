package br.com.brendowpodsclan.jokapihib.repository;

import br.com.brendowpodsclan.jokapihib.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface AuthorRepository extends JpaRepository<Author, Integer> {

//    @Modifying
//    @Transactional
//    @Query("update Author a set a.name= ?1 where a.id = ?2")
//    int updateAuthor(String name, int id);

}
