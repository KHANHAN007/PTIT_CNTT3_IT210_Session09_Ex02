package com.session05.ex02.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @GetMapping("/home")
    public String homePage(@CookieValue(value = "guest_name", required = false) String guestName, Model model) {
        if (guestName == null) {
            model.addAttribute("msg", "Chào khách lạ");
        } else {
            model.addAttribute("msg", "Chào khách quen");
        }
        model.addAttribute("guestName", guestName);
        return "home-page";
    }

    @PostMapping("/set-name")
    public String setName(@RequestParam("name") String name, HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("guest_name", name);
        cookie.setMaxAge(60 * 60);
        cookie.setPath(request.getContextPath());
        response.addCookie(cookie);
        return "redirect:/home";
    }

    @GetMapping("/delete-cookie")
    public String deleteCookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("guest_name", null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);
        return "redirect:/home";
    }
}
