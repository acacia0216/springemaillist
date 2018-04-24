package kr.co.bit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(){
        System.out.println("main");
        return "/WEB-INF/views/main.jsp";
    }


}
