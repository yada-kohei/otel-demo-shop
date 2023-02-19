package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String getHome(Model model) {
    model.addAttribute("contents", "home/home :: home_contents");
    return "home/homeLayout";
  }

  @GetMapping("/admin")
  public String getAdmin(Model model) {

    model.addAttribute("contents", "home/admin :: admin_contents");

    return "home/homeLayout";
  }
}
