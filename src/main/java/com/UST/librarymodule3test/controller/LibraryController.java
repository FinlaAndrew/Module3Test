package com.UST.librarymodule3test.controller;

import com.UST.librarymodule3test.entity.Book;
import com.UST.librarymodule3test.entity.User;
import com.UST.librarymodule3test.reporitory.BookRepo;
import com.UST.librarymodule3test.reporitory.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping
public class LibraryController {
    @Autowired
    private BookRepo bookRepo;
    @Autowired
    private UserRepo userRepo;
    @PostMapping("/user")
    public ResponseEntity<User> Create(@RequestBody User user){
        userRepo.save(user);
        return ResponseEntity.ok().body(user);
    }
    @PostMapping("/book")
    public ResponseEntity<Book> Create(@RequestBody Book book){
        bookRepo.save(book);
        return ResponseEntity.ok().body(book);
    }
    @GetMapping("/Id/{Id}")
    public ResponseEntity<User> getUserId(@PathVariable Long Id){
        User user= userRepo.findById(Id).orElse(null);
        if(user==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(user);
        }
    }
    @GetMapping("/bId/{Id}")
    public ResponseEntity<Book> getbookId(@PathVariable Long Id){
        Book book =bookRepo.findById(Id).orElse(null);
        if(book==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok().body(book);
        }
    }
    @PutMapping("/update/{Id}")
    public ResponseEntity<Book> Updatedetails(@RequestBody Book book,@PathVariable Long Id){
        Book buk=null;
        Optional<Book> updatebook =bookRepo.findById((Id));
        if(updatebook.isPresent()){
            buk=updatebook.get();
            buk.setId(Id);
            buk.setName(buk.getName());
            bookRepo.save(buk);
            return ResponseEntity.ok().body(buk);
        }else{
            return ResponseEntity.noContent().build();
        }
    }
    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<Boolean> DeleteId(@PathVariable Long Id){
        Optional<Book> buk=bookRepo.findById(Id);
        if(buk.isEmpty()){
            return ResponseEntity.ok(false);
        }else{
            bookRepo.deleteById(Id);
            return ResponseEntity.ok(true);
        }
    }
}
