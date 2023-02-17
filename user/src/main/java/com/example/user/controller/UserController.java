package com.example.user.controller;

import java.util.List;

// import com.example.user.model.SignupForm;
import com.example.user.model.User;
import com.example.user.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

  @Autowired
  UserService service;

  @GetMapping("/user")
  public List<User> getUserMany() {
    return service.selectMany();
  }

  @GetMapping("/user/{id:.+}")
  public User getUserOne(@PathVariable("id") String userId) {
    return service.selectOne(userId);
  }

  // @PostMapping(value = "/userDetail", params = "update")
  // public String postUserDetailUpdate(@ModelAttribute SignupForm form, Model model) {

  //   System.out.println("更新ボタンの処理");

  //   // Userインスタンスの生成
  //   User user = new User();

  //   // フォームクラスをUserクラスに変換
  //   user.setUserId(form.getUserId());
  //   user.setPassword(form.getPassword());
  //   user.setUserName(form.getUserName());
  //   user.setBirthday(form.getBirthday());
  //   user.setAge(form.getAge());
  //   user.setMarriage(form.isMarriage());

  //   // 更新実行
  //   boolean result = userService.updateOne(user);

  //   if (result == true) {
  //     model.addAttribute("result", "更新成功");
  //   } else {
  //     model.addAttribute("result", "更新失敗");
  //   }

  //   return getUserList(model);
  // }

  // @PostMapping(value = "/userDetail", params = "delete")
  // public String postUserDetailDelete(@ModelAttribute SignupForm form, Model model) {

  //   System.out.println("削除ボタンの処理");

  //   // 削除実行
  //   boolean result = userService.deleteOne(form.getUserId());

  //   if (result == true) {
  //     model.addAttribute("result", "削除成功");
  //   } else {
  //     model.addAttribute("result", "削除失敗");
  //   }

  //   return getUserList(model);
  // }

  // @PostMapping("/logout")
  // public String postLogout() {
  //   return "redirect:/login";
  // }

  // @GetMapping("/admin")
  // public String getAdmin(Model model) {

  //   model.addAttribute("contents", "login/admin :: admin_contents");

  //   return "login/homeLayout";
  // }
}
