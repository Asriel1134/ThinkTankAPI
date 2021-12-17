package com.wisdom.thinktank.controller;


import com.alibaba.fastjson.JSONObject;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.json.HistoryInfo;
import com.wisdom.thinktank.json.HotSearch;
import com.wisdom.thinktank.json.Swiper;
import com.wisdom.thinktank.service.impl.CollectionServiceImpl;
import com.wisdom.thinktank.service.impl.EntryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntryServiceImpl entryService;

    @RequestMapping("/index")
    public String index(){
        JSONObject indexJson = new JSONObject();
        List<Entry> listOfSwiper = new ArrayList<>();
        List<Entry> listOfHotSearch = new ArrayList<>();
        Entry historyInfo;

        List<Entry> result = entryService.getEntryOrderByHeat();

        listOfHotSearch.add(result.get(0));
        listOfHotSearch.add(result.get(1));
        listOfHotSearch.add(result.get(2));

        listOfSwiper.add(result.get(3));
        listOfSwiper.add(result.get(4));

        historyInfo = entryService.getSameDayEntry();

        indexJson.put("swiper", listOfSwiper);
        indexJson.put("hotSearch", listOfHotSearch);
        indexJson.put("historyInfo", historyInfo);
        indexJson.put("searchText", result.get(5).getTitle());
        return indexJson.toJSONString();
    }
}
