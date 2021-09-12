package com.example.demo;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


  @GetMapping("/test")
  @Operation(summary = "Get something", operationId = "simpleGet")
  public String get(){
    return "GET";
  }

}
