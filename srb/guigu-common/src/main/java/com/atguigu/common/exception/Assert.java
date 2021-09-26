package com.atguigu.common.exception;

import com.atguigu.common.result.ResponseEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
public class Assert {

    public static void notNull(Object obj, ResponseEnum responseEnum){
        if(obj == null){
            log.info("obj is null.....................");
            throw new BusinessException(responseEnum);
        }
    }

    public static void isNull(Object object, ResponseEnum responseEnum) {
        if (object != null) {
            log.info("obj is not null......");
            throw new BusinessException(responseEnum);
        }
    }

    public static void isTrue(boolean expression, ResponseEnum responseEnum) {
        if (!expression) {
            log.info("fail...............");
            throw new BusinessException(responseEnum);
        }
    }

    public static void notEquals(Object m1, Object m2,  ResponseEnum responseEnum) {
        if (m1.equals(m2)) {
            log.info("equals...............");
            throw new BusinessException(responseEnum);
        }
    }

    public static void equals(Object m1, Object m2,  ResponseEnum responseEnum) {
        if (!m1.equals(m2)) {
            log.info("not equals...............");
            throw new BusinessException(responseEnum);
        }
    }

    public static void notEmpty(String s, ResponseEnum responseEnum) {
        if (StringUtils.isEmpty(s)) {
            log.info("is empty...............");
            throw new BusinessException(responseEnum);
        }
    }

}

