package com.example.demo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

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

  private Map<String, String> radioMarriage;

  private Map<String, String> initRadioMarriage() {
    Map<String, String> radio = new LinkedHashMap<>();

    radio.put("既婚", "true");
		radio.put("未婚", "false");

		return radio;
  }

  // ユーザ登録画面のGET用のコントローラー
	@GetMapping("/signup")
  public String getSignUp(@ModelAttribute SignupForm form, Model model) {

    // ラジオボタンの初期化メソッド呼び出し
    radioMarriage = initRadioMarriage();

    // ラジオボタン用のMapをModelに登録
    model.addAttribute("radioMarriage", radioMarriage);

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
    user.setBirthday(form.getBirthday());
    user.setAge(form.getAge());
    user.setMarriage(form.isMarriage());
    user.setRole("ROLE_GENERAL");

    boolean result = userService.insert(user);

    if (result == true) {
      System.out.println("insert成功");
    } else {
      System.out.println("insert失敗");
    }

    return "redirect:/login";
  }
}