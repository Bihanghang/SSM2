package com.bihang.test;

import com.alibaba.fastjson.JSON;
import com.bihang.pojo.Datasource;
import com.bihang.service.DataSourceService;
import com.bihang.util.Constants;
import com.bihang.util.DataSourceHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2017/1/2 下午8:02
 * @since JDK 1.7
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/*.xml"})
public class DataSourceServiceImplTest {

    @Autowired
    private DataSourceService dataSourceService;

    @Test
    public void selectByPrimaryKey() throws Exception {
        Datasource datasource = dataSourceService.selectByPrimaryKey(2);
        System.out.println(JSON.toJSONString(datasource));
    }


    @Test
    public void selectByPrimaryKey2() throws Exception {
        Datasource datasource = dataSourceService.selectByPrimaryKey(2);
        System.out.println(JSON.toJSONString(datasource));
    }

}