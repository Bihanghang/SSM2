package com.bihang.intecepter;

import com.bihang.util.RedisUtil;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component("methodCacheInterceptor")
public class MethodCacheInterceptor implements MethodInterceptor {
    @Autowired
    private RedisUtil redisUtil;
    private Long defaultCacheExpireTime; // 缓存默认的过期时间
    private Long xxxRecordManagerTime; //
    private Long xxxSetRecordManagerTime; //

    public MethodCacheInterceptor() {
            // 加载过期时间设置
            defaultCacheExpireTime = 360L;
    }
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object value = null;
        String targetName = methodInvocation.getThis().getClass().getName();
        String methodName = methodInvocation.getMethod().getName();
        //获取参数
        Object[] arguments = methodInvocation.getArguments();
        String key = getCacheKey(targetName, methodName, arguments);

        try {
            if (redisUtil.exists(key)) {
                return redisUtil.get(key);
            }
            value = methodInvocation.proceed();

            if (value != null) {
                final String fkey = key;
                final Object fvalue = value;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        redisUtil.set(fkey, fvalue, defaultCacheExpireTime);
                    }
                }).start();
            }
        }catch (Exception e){
            e.printStackTrace();
            if (value == null){
                return methodInvocation.proceed();
            }
        }
        return value;
    }

    public String getCacheKey(String targetName,String methodName,Object[] arguments){
        StringBuffer key = new StringBuffer();
        key.append(targetName).append("_").append(methodName);
        for (Object o:arguments) {
            key.append(o).append("_");
        }
        return key.toString();
    }
}
