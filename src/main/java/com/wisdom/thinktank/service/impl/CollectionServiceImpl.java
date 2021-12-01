package com.wisdom.thinktank.service.impl;

import com.wisdom.thinktank.entity.Collection;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import com.wisdom.thinktank.mapper.CollectionMapper;
import com.wisdom.thinktank.mapper.HistoryMapper;
import com.wisdom.thinktank.service.CollectionService;
import com.wisdom.thinktank.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CollectionServiceImpl implements CollectionService {
    @Autowired
    private CollectionMapper collectionMapper;

    @Override
    public String addCollection(Collection collection) {
        int i = collectionMapper.addCollection(collection);
        if (i == 1){
            return "Collection added successfully";
        } else {
            return "Collection added failed";
        }
    }

    @Override
    public boolean isCollectionExist(Collection collection) {
        return collectionMapper.isCollectionExist(collection).size() != 0;
    }

    @Override
    public String deleteCollection(Collection collection) {
        int i = collectionMapper.deleteCollection(collection);
        if (i == 1){
            return "Collection deleted successfully";
        } else {
            return "Collection deleted failed";
        }
    }

    @Override
    public List<Collection> getCollectionList(Collection collection) {
        return collectionMapper.getCollectionList(collection);
    }

    @Override
    public Entry getEntryFromId(long id) {
        return collectionMapper.getEntryFromId(id);
    }
}
