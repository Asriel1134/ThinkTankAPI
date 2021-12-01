package com.wisdom.thinktank.mapper;

import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.History;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HistoryMapper {

    @Select("SELECT * FROM history WHERE userid = #{userid} AND entryid = #{entryid}")
    List<History> isHistoryExist(History history);

    @Delete("DELETE FROM history WHERE userid = #{userid} AND entryid = #{entryid}")
    int deleteHistory(History history);

    @Insert("insert into history(userid, entryid) values(#{userid},#{entryid})")
    int addHistory(History history);

    @Select("SELECT * FROM history WHERE userid = #{userid} order by date")
    List<History> getHistoryList(History history);

    @Select("select * from entry where entryid = #{id}")
    Entry getEntryFromId(long id);
}
