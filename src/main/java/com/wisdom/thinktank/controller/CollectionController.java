package com.wisdom.thinktank.controller;

import com.alibaba.fastjson.JSONObject;
import com.wisdom.thinktank.entity.Collection;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import com.wisdom.thinktank.json.HistoryCollection;
import com.wisdom.thinktank.service.impl.CollectionServiceImpl;
import com.wisdom.thinktank.service.impl.HistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
public class CollectionController {

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CollectionServiceImpl collectionService;

    @PostMapping("/addCollection")
    public String addCollection(Collection collection) {
        JSONObject addCollectionJson = new JSONObject();

        if (collectionService.isCollectionExist(collection)){
            collectionService.deleteCollection(collection);
            addCollectionJson.put("result", 1);
        } else {
            addCollectionJson.put("result", 0);
        }
        addCollectionJson.put("info", collectionService.addCollection(collection));
        return addCollectionJson.toJSONString();
    }

    @PostMapping("/getCollectionList")
    public String getCollectionList(Collection collection){
        List<Collection> historyList = collectionService.getCollectionList(collection);
        List<HistoryCollection> entryList = new ArrayList<>();
        for (Collection col: historyList){
            entryList.add(new HistoryCollection(col.getDate(), collectionService.getEntryFromId(col.getEntryid())));
        }

        JSONObject getHistoryListJson = new JSONObject();
        getHistoryListJson.put("result", 0);
        getHistoryListJson.put("info", "Get collectionList Successfully");
        getHistoryListJson.put("entries", entryList);
        return getHistoryListJson.toJSONString();
    }

    @PostMapping("/deleteCollection")
    public String deleteCollection(Collection collection){
        JSONObject deleteCollectionJson = new JSONObject();
        if (collectionService.isCollectionExist(collection)){
            collectionService.deleteCollection(collection);
            deleteCollectionJson.put("result", 0);
            deleteCollectionJson.put("info", "Delete collection successfully");
        } else {
            deleteCollectionJson.put("result", -7);
            deleteCollectionJson.put("info", "Collection does not exist");
        }
        return deleteCollectionJson.toJSONString();
    }
}