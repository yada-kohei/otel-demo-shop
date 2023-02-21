package com.example.demo.controller;

import java.util.List;

import com.example.demo.domain.model.SignupForm;
import com.example.demo.domain.model.User;
import com.example.demo.domain.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
  private static final Logger logger = LogManager.getLogger(UserController.class);

  @Autowired
  UserService userService;

  @GetMapping("/userList")
  public String getUserList(Model model) {

    // コンテンツ部分にユーザ一覧を表示するための文字列を登録
    model.addAttribute("contents", "user/userList::userList_contents");

    // ユーザ一覧の生成
    // List<User> userList = userService.selectMany();
    List<User> userList = userService.getUsers();

    // Modelにユーザリストを登録
    model.addAttribute("userList", userList);

    // データ件数を取得
    int count = userService.countUser();
    model.addAttribute("userListCount", count);

    return "home/homeLayout";
  }

  @GetMapping("/userDetail/{id:.+}")
  public String getUserDetail(@ModelAttribute SignupForm form, Model model,
      @PathVariable("id") String userId) {

    // ユーザID確認（デバッグ）
    logger.info("userId = " + userId);

    // コンテンツ部分にユーザ詳細を表示するための文字列を登録
    model.addAttribute("contents", "user/userDetail :: userDetail_contents");

    // ユーザIDのチェック
    if (userId != null && userId.length() > 0) {
      User user = userService.getUserbyId(userId);

      form.setUserId(userId);
      form.setUserName(user.getUserName());
      form.setPassword(user.getPassword());

      model.addAttribute("signupForm", form);
    }

    return "home/homeLayout";
  }

  @PostMapping(value = "/userDetail", params = "update")
  public String postUserDetailUpdate(@ModelAttribute SignupForm form, Model model) {

    logger.info("更新ボタンの処理");

    // Userインスタンスの生成
    User user = new User();

    // フォームクラスをUserクラスに変換
    user.setUserId(form.getUserId());
    user.setPassword(form.getPassword());
    user.setUserName(form.getUserName());

    // 更新実行
    boolean result = userService.updateUser(user);

    if (result == true) {
      model.addAttribute("result", "更新成功");
    } else {
      model.addAttribute("result", "更新失敗");
    }

    return getUserList(model);
  }

  @PostMapping(value = "/userDetail", params = "delete")
  public String postUserDetailDelete(@ModelAttribute SignupForm form, Model model) {

    logger.info("削除ボタンの処理");

    // 削除実行
    boolean result = userService.deleteUser(form.getUserId());

    if (result == true) {
      model.addAttribute("result", "削除成功");
    } else {
      model.addAttribute("result", "削除失敗");
    }

    return getUserList(model);
  }

}
