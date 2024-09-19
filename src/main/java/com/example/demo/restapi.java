package com.example.demo;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class restapi {

    @Autowired
    service s;

    @PostMapping("addbooks")
    public mysqldatabase addbooks(@RequestBody mysqldatabase data) {
        return s.addbook(data);
    }

    @GetMapping("getbook/{id}")
    public mysqldatabase getbookbyid(@PathVariable Long id) {
        return s.getbookbyid(id);
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

}
