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

    @Select("SELECT entryid,title,`describe`,date,createdate,heat,image FROM entry WHERE image != \"\" ORDER BY heat DESC LIMIT 7;")
    List<Entry> getEntryOrderByHeat();

    @Select("SELECT entryid,title,`describe`,date,createdate,heat,image FROM entry WHERE date LIKE #{date} LIMIT 1;")
    Entry getSameDayEntry(String date);

    @Select("select entryid,title,`describe`,date,createdate,heat,image from entry order by rand() LIMIT 3;")
    List<Entry> getRandomEntry();
}
