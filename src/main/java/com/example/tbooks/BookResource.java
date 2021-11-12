package com.example.tbooks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books") //indica que a url da api começca com /books
public class BookResource {
	//private final BookResource repository;
	private final BookRepository repository;
	
    @Autowired
    public BookResource(BookRepository repository){
        this.repository = repository;
    }
      
    @CrossOrigin()
    @GetMapping("/all")
    public List<Book> books() {
        return repository.findAll();
    }
    
    @CrossOrigin()
    @PostMapping("save")
    public Book save(@RequestBody Book book){
        Book createdFavoriteBook = repository.save(book);
        return createdFavoriteBook;
    }
    
    @CrossOrigin()
    @GetMapping("{id_user}")
    public List<Book> getBooks(@PathVariable int id_user){
        return repository.findByParentId(id_user);
    }
    

    @CrossOrigin()
    @DeleteMapping("{id}")
    public String delete(@PathVariable int id){
    	repository.deleteById(id);
        return "Favorite book with ID " + id + " removed.";
    }
}


