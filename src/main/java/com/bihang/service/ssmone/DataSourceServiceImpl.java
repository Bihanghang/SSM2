package com.bihang.service.ssmone;

import com.bihang.dao.DatasourceMapper;
import com.bihang.pojo.Datasource;
import com.bihang.service.DataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataSourceServiceImpl implements DataSourceService {

    @Autowired
    DatasourceMapper datasourceMapper;
    @Override
    public Datasource selectByPrimaryKey(Integer id) {
        return datasourceMapper.selectByPrimaryKey(id);
    }
}
