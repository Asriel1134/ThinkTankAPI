package com.wisdom.thinktank.mapper;

import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.EntryUser;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EntryUserMapper {

    @Select("SELECT * FROM entry_user WHERE userid = #{userid}")
    List<EntryUser> getEntryUserList(long userid);

    @Select("select entryid,title,`describe`,date,createdate from entry WHERE entryid = #{id}")
    Entry getEntryFromId(long id);
}
