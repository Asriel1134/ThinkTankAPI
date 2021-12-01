package com.wisdom.thinktank.controller;

import com.alibaba.fastjson.JSONObject;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import com.wisdom.thinktank.json.HistoryCollection;
import com.wisdom.thinktank.service.EntryService;
import com.wisdom.thinktank.service.impl.EntryServiceImpl;
import com.wisdom.thinktank.service.impl.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
public class HistoryController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HistoryServiceImpl historyService;

    @PostMapping("/addHistory")
    public String addHistory(History history) {
        JSONObject addHistoryJson = new JSONObject();

        if (historyService.isHistoryExist(history)){
            historyService.deleteHistory(history);
            addHistoryJson.put("result", 1);
        } else {
            addHistoryJson.put("result", 0);
        }
        addHistoryJson.put("info", historyService.addHistory(history));
        return addHistoryJson.toJSONString();
    }

    @PostMapping("/getHistoryList")
    public String getHistoryList(History history){
        List<History> historyList = historyService.getHistoryList(history);
        List<HistoryCollection> entryList = new ArrayList<>();
        for (History his: historyList){
            entryList.add(new HistoryCollection(his.getDate(), historyService.getEntryFromId(his.getEntryid())));
        }

        JSONObject getHistoryListJson = new JSONObject();
        getHistoryListJson.put("result", 0);
        getHistoryListJson.put("info", "Get historyList Successfully");
        getHistoryListJson.put("entries", entryList);
        return getHistoryListJson.toJSONString();
    }
}