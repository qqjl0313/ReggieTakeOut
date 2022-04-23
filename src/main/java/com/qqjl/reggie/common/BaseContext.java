package com.qqjl.reggie.common;

/**
 * 基于ThreadLocal封装的工具类，用户保存和获取当前登录用户的id
 *
 * @author QQJL
 * @since 2022/4/20 19:17
 */
public class BaseContext {
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setCurrentId(Long id) {
        threadLocal.set(id);
    }

    public static Long getCurrentId() {
        return threadLocal.get();
    }
}
