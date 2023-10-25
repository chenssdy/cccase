package com.chendys.webbackend.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 *  <p>本用于标注返回值需要包装的类<p/>
 *  <p>但是耦合太高，于是便在拦截器处为Request添加属性，返回时判断是否有此属性太判断<p/>
 */
@Retention(RUNTIME)
@Target({ TYPE,METHOD })
@Documented
public @interface ResponseResult {
}
