package com.example.echoservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoServiceController {

    @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String month(@PathVariable String input) {
        return input;
    }
}
