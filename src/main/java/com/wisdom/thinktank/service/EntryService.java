package com.wisdom.thinktank.service;


import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntryService {

        String addEntry(Entry entry);

        boolean isEntryExist(Entry entry);

        boolean isEntryExistFromId(Entry entry);

        Entry getEntry(String title);

        Entry getEntryFromId(long id);
}
