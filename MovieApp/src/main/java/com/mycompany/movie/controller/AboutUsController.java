package com.mycompany.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutUsController {
    @RequestMapping("about-us")
    public String displayFullDatail(){
        System.out.println("La methode displyaFullDetail a été invoquée");
        return "about-us";
    }
}
