package com.bihang.dao;

import com.bihang.pojo.Rediscontent;
import com.bihang.pojo.RediscontentExample;
import java.util.List;

public interface RediscontentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Rediscontent record);

    int insertSelective(Rediscontent record);

    List<Rediscontent> selectByExample(RediscontentExample example);

    Rediscontent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Rediscontent record);

    int updateByPrimaryKey(Rediscontent record);
}