package com.sample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {
    @GetMapping("/hello")
    public String hello() {
        return "get-hello";
    }

    @PostMapping("/hello")
    public String postHello() {
        return "post-hello";
    }

    @PutMapping("/hello")
    public String putHello() {
        return "put-hello";
    }

    @DeleteMapping("/hello")
    public String deleteHello() {
        return "delete-hello";
    }

    @GetMapping("/test/param") // param?name=&age=
    public String requestParam(@RequestParam("name") String name,
                               @RequestParam("age") Integer age) {
        return "request-param " + name + "age is " + age;
    }

    @GetMapping("/test/path/{name}/{age}")
    public String requestPathVariable(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age) {
        return "request-param " + name + "age is " + age;
    }

    @PostMapping("/test")
    public String postTest(@RequestBody RequestDto request) {

        return "post-test " + request.getName();
    }
}
