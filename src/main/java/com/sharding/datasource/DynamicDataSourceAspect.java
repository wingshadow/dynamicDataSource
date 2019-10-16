package com.sharding.datasource;

import com.sharding.datasource.annotation.DBSource;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Title: DynamicDataSourceAspect
 * @ProjectName sharding-master-slave
 * @Author FlyShadow
 * @Date 2019/10/15 18:41
 */
@Aspect
@Component
public class DynamicDataSourceAspect {

    @Pointcut("@annotation(com.sharding.datasource.annotation.DBSource)")
    public void doSomethingPointCut() {

    }

    @Before("doSomethingPointCut()")
    public void beforeSwitchDS(JoinPoint point) {

        MethodSignature sign = (MethodSignature) point.getSignature();
        Method method = sign.getMethod();
        String dataSource = DataSourceContextHolder.DEFAULT_DS;

        // 判断是否存在@DS注解
        if (method.isAnnotationPresent(DBSource.class)) {
            DBSource annotation = method.getAnnotation(DBSource.class);
            // 取出注解中的数据源名
            dataSource = annotation.value();
        }

        // 切换数据源
        DataSourceContextHolder.setDB(dataSource);
    }

    @After("@annotation(com.sharding.datasource.annotation.DBSource)")
    public void afterSwitchDS(JoinPoint point) {
        DataSourceContextHolder.clearDB();
    }
}
