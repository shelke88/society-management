package com.ss.societymanagment.customerror;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;

@Controller
public class CustomErrorController implements ErrorController {

    public String handleError(){
        System.out.println("handleError called... handleError()");
        return "***** Error occurred. Please check the application logs...";
    }

}
