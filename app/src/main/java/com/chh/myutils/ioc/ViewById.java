package com.chh.myutils.ioc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ProjectName : chh.IntelliMattress
 * @Author : ganhs
 * @Time : 2021/4/16 8:54
 * @Description :
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewById {
    int value();
}
