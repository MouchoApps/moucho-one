package com.mouchoapps.mouchoone.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j

@RequestMapping(path = "/")
public class HelloWorldController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getHelloWorld() {
        return ResponseEntity.ok()
                .build();
    }

}
