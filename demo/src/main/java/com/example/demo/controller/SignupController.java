package com.example.demo.controller;

import com.example.demo.domain.model.GroupOrder;
import com.example.demo.domain.model.SignupForm;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

  @Autowired
  private UserService userService;

  // ユーザ登録画面のGET用のコントローラー
	@GetMapping("/signup")
  public String getSignUp(@ModelAttribute SignupForm form, Model model) {

    // signup.htmlに画面遷移
    return "login/signup";
  }

  @PostMapping("/signup")
  public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form, BindingResult bindingResult, Model model) {

    if (bindingResult.hasErrors()) {
      return getSignUp(form, model);
    }

    System.out.println(form);

    User user = new User();

    user.setUserId(form.getUserId());
    user.setPassword(form.getPassword());
    user.setUserName(form.getUserName());
    user.setRole("ROLE_GENERAL");

    boolean result = userService.createUser(user);

    if (result == true) {
      System.out.println("insert成功");
    } else {
      System.out.println("insert失敗");
    }

    return "redirect:/login";
  }
}