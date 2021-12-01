package com.wisdom.thinktank.service;


import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HistoryService {

        String addHistory(History history);

        boolean isHistoryExist(History history);

        String deleteHistory(History history);

        List<History> getHistoryList(History history);

        Entry getEntryFromId(long id);
}
