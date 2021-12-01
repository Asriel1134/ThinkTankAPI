package com.wisdom.thinktank.service.impl;

import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.EntryUser;
import com.wisdom.thinktank.entity.History;
import com.wisdom.thinktank.mapper.EntryUserMapper;
import com.wisdom.thinktank.mapper.HistoryMapper;
import com.wisdom.thinktank.service.EntryUserService;
import com.wisdom.thinktank.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntryUserServiceImpl implements EntryUserService {
    @Autowired
    private EntryUserMapper entryUserMapper;

    @Override
    public List<EntryUser> getEntryUserList(long userid) {
        return entryUserMapper.getEntryUserList(userid);
    }

    @Override
    public Entry getEntryFromId(long id) {
        return entryUserMapper.getEntryFromId(id);
    }
}
