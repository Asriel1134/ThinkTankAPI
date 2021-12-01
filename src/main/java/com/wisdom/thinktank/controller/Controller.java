package com.wisdom.thinktank.controller;


import com.alibaba.fastjson.JSONObject;
import com.wisdom.thinktank.json.HistoryInfo;
import com.wisdom.thinktank.json.HotSearch;
import com.wisdom.thinktank.json.Swiper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @RequestMapping("/index")
    public String index(){
        JSONObject indexJson = new JSONObject();
        List<Swiper> listOfSwiper = new ArrayList<>();
        List<HotSearch> listOfHotSearch = new ArrayList<>();
        HistoryInfo historyInfo;

        listOfSwiper.add(new Swiper(1, "", "", "", "",  "/static/swiper/1.png"));
        listOfSwiper.add(new Swiper(2, "", "", "", "", "/static/swiper/2.png"));

        listOfHotSearch.add(new HotSearch(3, "党的十九届六中全会精神", "中共中央介绍十九届六种全会精神", 99));
        listOfHotSearch.add(new HotSearch(4, "人民解放军空军建军节", "人民空军成立27周年", 88));
        listOfHotSearch.add(new HotSearch(5, "神州十三号", "神州十三号航天员完成首次出舱活动", 77));

        historyInfo = new HistoryInfo(6, "1840年，法国著名法国雕塑艺术家奥古斯特·罗丹出生", "罗丹是法国著名雕塑家。他在欧洲雕塑史上的地位无人能及。", "/static/his/his.jpeg");

        indexJson.put("swiper", listOfSwiper);
        indexJson.put("hotSearch", listOfHotSearch);
        indexJson.put("historyInfo", historyInfo);
        return indexJson.toJSONString();
    }
}
