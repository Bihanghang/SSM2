package com.bihang.service;


import com.bihang.pojo.Datasource;

/**
 * Function:
 *
 * @author chenjiec
 *         Date: 2016/12/9 上午12:16
 * @since JDK 1.7
 */
public interface DataSourceService {

    Datasource selectByPrimaryKey(Integer id);
}