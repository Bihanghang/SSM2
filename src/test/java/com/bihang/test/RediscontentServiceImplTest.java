package com.bihang.test;

import com.alibaba.fastjson.JSON;
import com.bihang.dao.RediscontentMapper;
import com.bihang.pojo.Rediscontent;
import com.bihang.pojo.RediscontentExample;
import com.bihang.service.RediscontentService;
import com.bihang.util.PageEntity;
import com.github.pagehelper.PageHelper;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Function:
 *
 * @author crossoverJie
 *         Date: 2017/1/2 下午7:51
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class RediscontentServiceImplTest {

    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private RediscontentService rediscontentService;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Rediscontent rediscontent = rediscontentService.selectByPrimaryKey(30);
        logger.debug(JSON.toJSONString(rediscontent));
    }
    @Test
    public void selectByExample() {
        PageEntity<Rediscontent> pageEntity = rediscontentService.selectByPage(2,20);
        logger.error(JSON.toJSONString(pageEntity));
    }
}