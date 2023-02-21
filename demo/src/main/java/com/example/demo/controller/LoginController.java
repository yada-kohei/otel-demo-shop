package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;

@Controller
public class LoginController {

  private static final Meter meter = GlobalOpenTelemetry.getMeter("demo");

  private static final LongCounter requestsCounter = meter.counterBuilder("app.demo.login_requests")
      .setDescription("Counts ad requests by request and response type").build();

  @GetMapping("/login")
  public String getLogin(Model model) {
    requestsCounter.add(1);
    return "login/login";
  }

  @PostMapping("/login")
  public String postLogin(Model model) {
    return "redirect:/home";
  }

  @PostMapping("/logout")
  public String postLogout() {
    return "redirect:/login";
  }
}
