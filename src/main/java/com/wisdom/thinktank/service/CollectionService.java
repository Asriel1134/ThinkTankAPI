package com.wisdom.thinktank.service;


import com.wisdom.thinktank.entity.Collection;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CollectionService {

        String addCollection(Collection collection);

        boolean isCollectionExist(Collection collection);

        String deleteCollection(Collection collection);

        List<Collection> getCollectionList(Collection collection);

        Entry getEntryFromId(long id);
}
