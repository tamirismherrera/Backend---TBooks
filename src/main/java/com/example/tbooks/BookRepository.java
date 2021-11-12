package com.example.tbooks;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookRepository extends JpaRepository<Book, Integer> {

	@Query(value = "SELECT * FROM favorites_books WHERE id_user = ?1", nativeQuery = true)
    public List<Book> findByParentId(int id_user);

}