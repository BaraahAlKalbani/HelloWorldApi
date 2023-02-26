package com.dynamicdoers.hw.app.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
/*
The @RestController annotation marks the HelloWorldController class as a  controller,
while the @RequestMapping annotation maps the base URL path of the API to /api.
The @GetMapping annotations map the HTTP GET requests to the respective endpoint methods.
 */
@RestController
@RequestMapping(path = "/api")
public class HelloWorldController {
/*
GET /api returns a JSON response containing a HashMap withRESTful
two key-value pairs: "result" with value "Hello World!"
and "status" with value "OK".
 */
    @GetMapping(path = {"","/"})
    public HashMap<String,String> helloWorld() {
        HashMap<String,String> response = new HashMap<>();
        response.put("result","Hello World!");
        response.put("status", "OK");
        response.put("status code", "200");
        return response;
    }
    /*
    GET /api/hw returns a string response that includes a custom message based on a request parameter "myname".
    If the parameter is not provided, the default value "Mr/Ms" is used.
     */
    @GetMapping(path = {"/hw"})
    public String getHomePageContent(@RequestParam(value = "myname", defaultValue = "Mr/Ms") String name){
        return "Hello " + name + " !";
    }
    /*
    The @ExceptionHandler annotation defines an exception handler
    for any unhandled exceptions that occur during the request processing.
    If an exception occurs, it returns an HTTP 500 Internal Server Error
    response with a message that includes the error message.
    */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        String message = "An error occurred: " + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}