package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service {

    @Autowired
    jpaRepo ajax;
    
    public mysqldatabase addbook(mysqldatabase data){
        return ajax.save(data);
    }

    public Optional<mysqldatabase> checkbyid(Long id){
        return ajax.findById(id);
    }

    public mysqldatabase updatebook(Long id,mysqldatabase database){
        database.setId(id);
        return ajax.save(database);
    }

    public String deletebook(Long id) {
        ajax.deleteById(id);
        return "Deleted successfully";
    }

    public List<mysqldatabase> getallbook(){
        return ajax.findAll();
    }

}