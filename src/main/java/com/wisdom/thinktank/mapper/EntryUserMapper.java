package com.wisdom.thinktank.mapper;

import com.wisdom.thinktank.entity.Entry;
import com.wisdom.thinktank.entity.EntryUser;
import com.wisdom.thinktank.entity.History;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EntryUserMapper {

    @Select("SELECT * FROM entry_user WHERE userid = #{userid}")
    List<EntryUser> getEntryUserList(long userid);

    @Select("select * from entry where entryid = #{id}")
    Entry getEntryFromId(long id);
}
