package com.example.exersice2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Assigment {
@GetMapping("/name")
    public String MyName(){
    return "My name is Manal";
}
@GetMapping("/age")
    public String MyAge(){
    return "My age is 24";
}
@GetMapping("/check")
    public String Check(){
    return "Everything ok!";
}
@GetMapping("health")
    public String Health(){
    return "Server health is up";
}
}
