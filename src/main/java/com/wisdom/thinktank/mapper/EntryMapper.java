package com.wisdom.thinktank.mapper;

import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EntryMapper {

    @Insert("insert into entry(title,`describe`,date,heat,image,text) values(#{title},#{describe},#{date},#{heat},#{image},#{text})")
    int addEntry(Entry entry);

    @Select("select * from entry where title = #{title}")
    List<Entry> isEntryExist(Entry entry);

    @Select("select * from entry where entryid = #{entryid}")
    List<Entry> isEntryExistFromId(Entry entry);

    @Select("select * from entry where title = #{title}")
    Entry getEntry(String title);

    @Select("select * from entry where entryid = #{id}")
    Entry getEntryFromId(long id);
}
