package com.example.demo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Exception.BookNotFoundException;
import com.example.demo.Exception.ErrorResponse;

@RestController
public class RestApi {
    @Autowired
    protected service s;

    @PostMapping("addbooks")
    public mysqldatabase addbooks(@RequestBody mysqldatabase data) {
        return s.addbook(data);
    }

    @GetMapping("getbook/{id}")
    public ResponseEntity<?> getbookbyid(@PathVariable Long id) {
        mysqldatabase books = s.checkbyid(id).orElseThrow(() -> new BookNotFoundException("bookn not found" + id));
        return ResponseEntity.ok(books);
    }

    @GetMapping("viewAllbooks")
    public List<mysqldatabase> getallbook() {
        return s.getallbook();
    }

    @PutMapping("updatebook/{id}")
    public mysqldatabase update(@PathVariable Long id, @RequestBody mysqldatabase database) {
        return s.updatebook(id, database);
    }

    @DeleteMapping("deletebook/{id}")
    public String delete(@PathVariable Long id) {
        return s.deletebook(id);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<?> booknotfound(BookNotFoundException e) {
        ErrorResponse booknotfound = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "Book Not found");
        return new ResponseEntity<>(booknotfound, HttpStatus.NOT_FOUND);
    }
}