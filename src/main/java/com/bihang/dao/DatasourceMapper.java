package com.bihang.dao;

import com.bihang.pojo.Datasource;

public interface DatasourceMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Datasource record);

    int insertSelective(Datasource record);

    Datasource selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Datasource record);

    int updateByPrimaryKey(Datasource record);
}