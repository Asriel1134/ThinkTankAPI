package com.wisdom.thinktank.mapper;

import com.wisdom.thinktank.entity.Collection;
import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CollectionMapper {

    @Select("SELECT * FROM collection WHERE userid = #{userid} AND entryid = #{entryid}")
    List<Collection> isCollectionExist(Collection collection);

    @Delete("DELETE FROM collection WHERE userid = #{userid} AND entryid = #{entryid}")
    int deleteCollection(Collection collection);

    @Insert("insert into collection(userid, entryid) values(#{userid},#{entryid})")
    int addCollection(Collection collection);

    @Select("SELECT * FROM collection WHERE userid = #{userid} order by date desc")
    List<Collection> getCollectionList(Collection collection);

    @Select("select entryid,title,`describe`,date,createdate from entry where entryid = #{id}")
    Entry getEntryFromId(long id);
}
