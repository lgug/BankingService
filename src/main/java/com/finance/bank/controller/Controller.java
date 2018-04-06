package com.finance.bank.controller;

import com.finance.bank.entities.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class Controller {

    @RequestMapping(value = "/user", method = POST)
    public ResponseEntity<?> insertNewUser(@RequestBody User user) {
        user.saveUser();
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());
        return new ResponseEntity<Object>()
    }

}
