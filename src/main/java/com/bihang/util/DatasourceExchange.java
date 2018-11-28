package com.bihang.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

@Component("dataSourceExchange")
public class DatasourceExchange {
    Logger logger = Logger.getLogger(this.getClass());
    public void before(JoinPoint point){
        Class<?> targetClass  = point.getTarget().getClass();
        String targetPackageName =targetClass.getName();
        logger.debug(targetPackageName);
        if (targetPackageName.contains("ssmone")){
            DataSourceHolder.setDataSources(Constants.DATASOURCE_ONE);
        }else {
            DataSourceHolder.setDataSources(Constants.DATASOURCE_TWO);
        }
    }

    public void after() {
        DataSourceHolder.setDataSources(null);
    }
}
