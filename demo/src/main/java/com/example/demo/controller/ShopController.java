package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.service.ItemService;
import com.example.demo.domain.service.ShopService;
import com.example.demo.domain.model.Item;
import com.example.demo.domain.model.Shop;
import com.example.demo.domain.model.ShopDetail;
import com.example.demo.domain.model.ItemForm;

@Controller
public class ShopController {

  @Autowired
  ItemService itemService;

  @Autowired
  ShopService shopService;

  @GetMapping("/shopList")
  public String getShopList(Model model) {

    // コンテンツ部分にユーザ一覧を表示するための文字列を登録
    model.addAttribute("contents", "shop/shopList::shopList_contents");

    List<Item> itemList = itemService.getItems();

    // Modelにユーザリストを登録
    model.addAttribute("shopList", itemList);

    // データ件数を取得
    int count = itemService.countItem();
    model.addAttribute("shopListCount", count);

    return "home/homeLayout";
  }

  @GetMapping("/shopDetail/{id:.+}")
  public String getShopDetail(@ModelAttribute ItemForm form, Model model, @PathVariable("id") int itemId) {

    // ユーザID確認（デバッグ）
    System.out.println("itemId = " + itemId);

    // コンテンツ部分にユーザ詳細を表示するための文字列を登録
    model.addAttribute("contents", "shop/shopDetail :: shopDetail_contents");

    Item item = itemService.getItembyId(itemId);

    form.setItemId(itemId);
    form.setItemName(item.getItemName());
    form.setDescription(item.getDescription());
    form.setPrice(item.getPrice());

    model.addAttribute("shopForm", form);

    return "home/homeLayout";
  }

  @GetMapping("/myShopList")
  public String getMyShopList(Model model) {

    // コンテンツ部分にユーザ一覧を表示するための文字列を登録
    model.addAttribute("contents", "shop/myShopList::myShopList_contents");

    List<ShopDetail> myShopList = shopService.getMyShopDetail();

    // Modelにユーザリストを登録
    model.addAttribute("myShopList", myShopList);

    return "home/homeLayout";
  }

  // @PostMapping(value = "/itemDetail", params = "update")
  // public String postItemDetailUpdate(@ModelAttribute ItemForm form, Model model) {

  //   System.out.println("更新ボタンの処理");

  //   Item item = new Item();

  //   item.setItemId(form.getItemId());
  //   item.setItemName(form.getItemName());
  //   item.setDescription(form.getDescription());
  //   item.setPrice(form.getPrice());

  //   // 更新実行
  //   boolean result = itemService.updateItem(item);

  //   if (result == true) {
  //     model.addAttribute("result", "更新成功");
  //   } else {
  //     model.addAttribute("result", "更新失敗");
  //   }

  //   return getItemList(model);
  // }

  // @PostMapping(value = "/itemDetail", params = "delete")
  // public String postItemDetailDelete(@ModelAttribute ItemForm form, Model model) {

  //   System.out.println("削除ボタンの処理");

  //   // 削除実行
  //   boolean result = itemService.deleteItem(form.getItemId());

  //   if (result == true) {
  //     model.addAttribute("result", "削除成功");
  //   } else {
  //     model.addAttribute("result", "削除失敗");
  //   }

  //   return getItemList(model);
  // }
}
