package com.wisdom.thinktank.service.impl;

import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import com.wisdom.thinktank.mapper.EntryMapper;
import com.wisdom.thinktank.mapper.HistoryMapper;
import com.wisdom.thinktank.service.EntryService;
import com.wisdom.thinktank.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryMapper historyMapper;

    @Override
    public String addHistory(History history) {
        int i = historyMapper.addHistory(history);
        if (i == 1){
            return "History added successfully";
        } else {
            return "History added failed";
        }
    }

    @Override
    public boolean isHistoryExist(History history) {
        return historyMapper.isHistoryExist(history).size() != 0;
    }

    @Override
    public String deleteHistory(History history) {
        int i = historyMapper.deleteHistory(history);
        if (i == 1){
            return "History deleted successfully";
        } else {
            return "History deleted failed";
        }
    }

    @Override
    public List<History> getHistoryList(History history) {
        return historyMapper.getHistoryList(history);
    }

    @Override
    public Entry getEntryFromId(long id) {
        return historyMapper.getEntryFromId(id);
    }
}
