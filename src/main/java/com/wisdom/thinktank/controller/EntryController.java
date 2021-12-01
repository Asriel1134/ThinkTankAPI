package com.wisdom.thinktank.controller;

import com.alibaba.fastjson.JSONObject;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.User;
import com.wisdom.thinktank.service.impl.EntryServiceImpl;
import com.wisdom.thinktank.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class EntryController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private EntryServiceImpl entryServer;

    @PostMapping("/addEntry")
    public String addEntry(Entry entry) {
        JSONObject addEntryJson = new JSONObject();

        if (entryServer.isEntryExist(entry)){
            addEntryJson.put("result", -5);
            addEntryJson.put("info", "Entry already exists");
        } else {
            addEntryJson.put("result", 0);
            addEntryJson.put("info", entryServer.addEntry(entry));
        }
        return addEntryJson.toJSONString();
    }

    @GetMapping("/getEntry")
    public String getEntry(Entry entry) {
        JSONObject getEntryJson = new JSONObject();

        if (!entryServer.isEntryExist(entry)){
            getEntryJson.put("result", -6);
            getEntryJson.put("info", "Entry does not exists");
            getEntryJson.put("entryInfo", "");
        } else {
            getEntryJson.put("result", 0);
            getEntryJson.put("info", "Success");
            getEntryJson.put("entryInfo", entryServer.getEntry(entry.getTitle()));
        }
        return getEntryJson.toJSONString();
    }

    @GetMapping("/getEntryFromID")
    public String getEntryFromId(Entry entry) {
        JSONObject getEntryJson = new JSONObject();

        if (!entryServer.isEntryExistFromId(entry)){
            getEntryJson.put("result", -6);
            getEntryJson.put("info", "Entry does not exists");
            getEntryJson.put("entryInfo", "");
        } else {
            getEntryJson.put("result", 0);
            getEntryJson.put("info", "Success");
            getEntryJson.put("entryInfo", entryServer.getEntryFromId(entry.getEntryid()));
        }
        return getEntryJson.toJSONString();
    }
}