package edu.neu.ccs.cs5500.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloWorld {

  @GetMapping("/")
  public String helloWorld(){
    return "Hello World!";
  }

}
