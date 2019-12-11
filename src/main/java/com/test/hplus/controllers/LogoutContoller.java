package com.test.hplus.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LogoutContoller {

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        System.out.println("Ending user session");
        //System.out.println(session.getAttribute("login"));
        return "login";
    }
}
