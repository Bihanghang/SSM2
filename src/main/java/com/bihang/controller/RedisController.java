package com.bihang.controller;

import com.bihang.pojo.Datasource;
import com.bihang.pojo.Rediscontent;
import com.bihang.service.DataSourceService;
import com.bihang.service.RediscontentService;
import com.bihang.util.CommonUtil;
import com.bihang.util.PageEntity;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

@Controller
public class RedisController {

    private static Logger logger = Logger.getLogger(RedisController.class);

    @Autowired
    private RediscontentService rediscontentService;

    @RequestMapping("/redis_list")
    public void club_list(HttpServletResponse response,
                          @RequestParam(value = "page", defaultValue = "0") int page,
                          @RequestParam(value = "pageSize", defaultValue = "0") int pageSize){
        JSONObject jsonObject = new JSONObject();
        JSONObject jo = new JSONObject();
        JSONArray ja = new JSONArray();
        try {
            PageEntity<Rediscontent> rediscontentPageEntity = rediscontentService.selectByPage(page, pageSize);
            for (Rediscontent rediscontent : rediscontentPageEntity.getList()) {
                JSONObject jo1 = new JSONObject();
                jo1.put("rediscontent", rediscontent);
                ja.add(jo1);
            }
            jo.put("redisContents", ja);
            jo.put("count", rediscontentPageEntity.getCount());
            jsonObject = CommonUtil.parseJson("1", "成功", jo);
        }catch (Exception e){
            jsonObject = CommonUtil.parseJson("2", "失败", jo);
            logger.error(e.getMessage(),e);
        }
        CommonUtil.responseBuildJson(response,jsonObject);
    }
}
