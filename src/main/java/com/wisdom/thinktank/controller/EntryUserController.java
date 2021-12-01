package com.wisdom.thinktank.controller;

import com.alibaba.fastjson.JSONObject;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.EntryUser;
import com.wisdom.thinktank.entity.History;
import com.wisdom.thinktank.service.impl.EntryUserServiceImpl;
import com.wisdom.thinktank.service.impl.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
public class EntryUserController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntryUserServiceImpl entryUserService;

    @PostMapping("/getEntryUserList")
    public String getEntryUserList(long userid){
        List<EntryUser> historyList = entryUserService.getEntryUserList(userid);
        List<Entry> entryList = new ArrayList<>();
        for (EntryUser eu: historyList){
            entryList.add(entryUserService.getEntryFromId(eu.getEntryid()));
        }

        JSONObject getEntryUserListJson = new JSONObject();
        getEntryUserListJson.put("result", 0);
        getEntryUserListJson.put("info", "Get getEntryUserList Successfully");
        getEntryUserListJson.put("entries", entryList);
        return getEntryUserListJson.toJSONString();
    }
}