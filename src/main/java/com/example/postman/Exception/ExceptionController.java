package com.example.postman.Exception;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exception")
public class ExceptionController {

    //exception handling in controller
    @RequestMapping("arithmetic")
    public String controllerForArithmeticException()
    {
        try {
            throw new ArithmeticException("Divide by zero error");
        }
        catch(ArithmeticException ae){
            return ae.getMessage();
        }
    }

    @RequestMapping("exception/null-pointer")
    public String controllerForException() throws Exception
    {
        throw new NullPointerException("Null reference");
    }
}
