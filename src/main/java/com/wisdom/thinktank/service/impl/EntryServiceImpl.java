package com.wisdom.thinktank.service.impl;

import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.User;
import com.wisdom.thinktank.mapper.EntryMapper;
import com.wisdom.thinktank.mapper.UserMapper;
import com.wisdom.thinktank.service.EntryService;
import com.wisdom.thinktank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntryServiceImpl implements EntryService {
    @Autowired
    private EntryMapper entryMapper;

    @Override
    public String addEntry(Entry entry) {
        int i = entryMapper.addEntry(entry);
        if (i == 1){
            return "Entry added successfully";
        } else {
            return "Entry added failed";
        }
    }

    @Override
    public boolean isEntryExist(Entry entry) {
        return entryMapper.isEntryExist(entry).size() != 0;
    }

    @Override
    public boolean isEntryExistFromId(Entry entry) {
        return entryMapper.isEntryExistFromId(entry).size() != 0;
    }

    @Override
    public Entry getEntry(String title) {
        return entryMapper.getEntry(title);
    }

    @Override
    public Entry getEntryFromId(long id) {
        return entryMapper.getEntryFromId(id);
    }
}
