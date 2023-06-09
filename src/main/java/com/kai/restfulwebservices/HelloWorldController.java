package com.kai.restfulwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @GetMapping("/hello-bean")
    public HelloBean helloBean(){
        return new HelloBean("hello world");
    }

    @GetMapping("/hello-bean/path-variable/{name}")
    public HelloBean helloBeanPathVariable(@PathVariable String name){
        return new HelloBean(String.format("hello world, " + name));
    }
}
