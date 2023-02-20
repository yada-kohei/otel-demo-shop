package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.core.context.SecurityContextHolder;

import com.example.demo.domain.service.ItemService;
import com.example.demo.domain.service.ShopService;
import com.example.demo.domain.model.Item;
import com.example.demo.domain.model.Shop;
import com.example.demo.domain.model.ShopDetail;
import com.example.demo.domain.model.ShopForm;

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
  public String getShopDetail(@ModelAttribute ShopForm form, Model model, @PathVariable("id") int itemId) {

    // ユーザID確認（デバッグ）
    System.out.println("itemId = " + itemId);

    // コンテンツ部分にユーザ詳細を表示するための文字列を登録
    model.addAttribute("contents", "shop/shopDetail :: shopDetail_contents");

    Item item = itemService.getItembyId(itemId);

    form.setItemId(itemId);
    form.setItemName(item.getItemName());
    form.setDescription(item.getDescription());
    form.setPrice(item.getPrice());
    form.setUnit(0);

    model.addAttribute("shopForm", form);

    return "home/homeLayout";
  }

  @GetMapping("/allShopList")
  public String getAllShopList(Model model) {

    // コンテンツ部分にユーザ一覧を表示するための文字列を登録
    model.addAttribute("contents", "shop/allShopList::allShopList_contents");

    List<ShopDetail> allShopList = shopService.getAllShopDetail();

    // Modelにユーザリストを登録
    model.addAttribute("allShopList", allShopList);

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

  @PostMapping(value = "/shop")
  public String postShop(@ModelAttribute ShopForm form, Model model) {

    System.out.println("商品購入");
    System.out.println(form);

    Shop shop = new Shop();
    String userId = SecurityContextHolder.getContext().getAuthentication().getName();

    shop.setItemId(form.getItemId());
    shop.setUserId(userId);
    shop.setUnit(form.getUnit());

    boolean result = shopService.createShop(shop);

    if (result == true) {
      System.out.println("insert成功");
    } else {
      System.out.println("insert失敗");
    }

    return getMyShopList(model);
  }

}
