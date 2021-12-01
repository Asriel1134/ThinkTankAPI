package com.wisdom.thinktank.service;


import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.EntryUser;
import com.wisdom.thinktank.entity.History;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EntryUserService {

        List<EntryUser> getEntryUserList(long userid);

        Entry getEntryFromId(long id);
}
