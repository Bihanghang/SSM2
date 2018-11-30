package com.bihang.service;


import com.bihang.pojo.Rediscontent;
import com.bihang.pojo.RediscontentExample;
import com.bihang.util.PageEntity;

import java.util.List;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2016/12/9 上午12:16
 * @since JDK 1.7
 */
public interface RediscontentService {
    List<Rediscontent> selectByExample(RediscontentExample example);

    Rediscontent selectByPrimaryKey(Integer id);

    PageEntity<Rediscontent> selectByPage(Integer pageNum, Integer pageSize);

}
