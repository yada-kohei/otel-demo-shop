package com.example.demo.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.service.ItemService;
import com.example.demo.domain.model.Item;
import com.example.demo.domain.model.ItemForm;

@Controller
public class ItemController {
  private static final Logger logger = LogManager.getLogger(ItemController.class);

  @Autowired
  ItemService itemService;

  @GetMapping("/itemList")
  public String getItemList(Model model) {

    // コンテンツ部分にユーザ一覧を表示するための文字列を登録
    model.addAttribute("contents", "item/itemList::itemList_contents");

    List<Item> itemList = itemService.getItems();

    // Modelにユーザリストを登録
    model.addAttribute("itemList", itemList);

    // データ件数を取得
    int count = itemService.countItem();
    model.addAttribute("itemListCount", count);

    return "home/homeLayout";
  }

  @GetMapping("/itemDetail/{id:.+}")
  public String getItemDetail(@ModelAttribute ItemForm form, Model model,
      @PathVariable("id") int itemId) {

    // ユーザID確認（デバッグ）
    logger.info("itemId = " + itemId);

    // コンテンツ部分にユーザ詳細を表示するための文字列を登録
    model.addAttribute("contents", "item/itemDetail :: itemDetail_contents");

    Item item = itemService.getItembyId(itemId);

    form.setItemId(itemId);
    form.setItemName(item.getItemName());
    form.setDescription(item.getDescription());
    form.setPrice(item.getPrice());

    model.addAttribute("itemForm", form);

    return "home/homeLayout";
  }

  @PostMapping(value = "/itemDetail", params = "update")
  public String postItemDetailUpdate(@ModelAttribute ItemForm form, Model model) {

    logger.info("更新ボタンの処理");

    Item item = new Item();

    item.setItemId(form.getItemId());
    item.setItemName(form.getItemName());
    item.setDescription(form.getDescription());
    item.setPrice(form.getPrice());

    // 更新実行
    boolean result = itemService.updateItem(item);

    if (result == true) {
      model.addAttribute("result", "更新成功");
    } else {
      model.addAttribute("result", "更新失敗");
    }

    return getItemList(model);
  }

  @PostMapping(value = "/itemDetail", params = "delete")
  public String postItemDetailDelete(@ModelAttribute ItemForm form, Model model) {

    logger.info("削除ボタンの処理");

    // 削除実行
    boolean result = itemService.deleteItem(form.getItemId());

    if (result == true) {
      model.addAttribute("result", "削除成功");
    } else {
      model.addAttribute("result", "削除失敗");
    }

    return getItemList(model);
  }
}
