package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service {

    @Autowired
    jpaRepo jpa;
    
    public mysqldatabase addbook(mysqldatabase data){
        return jpa.save(data);
    }

    public mysqldatabase getbookbyid(Long id){
        return jpa.findById(id).orElse(null);
    }

    public mysqldatabase updatebook(Long id,mysqldatabase database){
        database.setId(id);
        return jpa.save(database);
    }

    public String deletebook(Long id) {
        jpa.deleteById(id);
        return "Deleted successfully";
    }

    public List<mysqldatabase> getallbook(){
        return jpa.findAll();
    }

}
