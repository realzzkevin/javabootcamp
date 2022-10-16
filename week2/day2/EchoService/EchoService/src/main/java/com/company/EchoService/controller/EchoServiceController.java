package com.company.EchoService.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class EchoServiceController {

    @RequestMapping(value = "/echo/{input}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public String echo(@PathVariable String input){
        return input;
    }
}
