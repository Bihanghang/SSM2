package com.bihang.service.ssmone;

import com.bihang.dao.RediscontentMapper;
import com.bihang.pojo.Rediscontent;
import com.bihang.pojo.RediscontentExample;
import com.bihang.service.RediscontentService;
import com.bihang.util.PageEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RediscontentServiceImpl implements RediscontentService {
    @Autowired
    RediscontentMapper rediscontentMapper;

    @Override
    public List<Rediscontent> selectByExample(RediscontentExample example) {
        return rediscontentMapper.selectByExample(example);
    }

    @Override
    public Rediscontent selectByPrimaryKey(Integer id) {
        return rediscontentMapper.selectByPrimaryKey(id);
    }

    @Override
    public PageEntity<Rediscontent> selectByPage(Integer pageNum, Integer pageSize) {
        System.out.println(pageNum+""+pageSize);
        PageHelper.startPage(pageNum,pageSize);
        List<Rediscontent> rediscontents = rediscontentMapper.selectByExample(new RediscontentExample());
        PageEntity<Rediscontent> rediscontentPageEntity = new PageEntity<Rediscontent>();
        rediscontentPageEntity.setList(rediscontents);
        int size = rediscontentMapper.selectByExample(new RediscontentExample()).size();
        rediscontentPageEntity.setCount(size);
        return rediscontentPageEntity;
    }
}
