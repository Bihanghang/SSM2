package com.bihang.test;

import com.bihang.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class RedisUtilTest {
    @Autowired
    RedisUtil redisUtil;
    @Test
    public void redisTest(){
        boolean flag = redisUtil.set("bihanghang","葫芦娃",60l);
        System.out.println(flag);
    }
}
