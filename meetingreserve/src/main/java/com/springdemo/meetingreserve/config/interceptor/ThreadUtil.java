package com.springdemo.meetingreserve.config.interceptor;

import com.springdemo.meetingreserve.jpa.entity.UserDO;

public class ThreadUtil {
    private static final ThreadLocal<UserDO> threadLocal = new ThreadLocal<UserDO>();

    public static void set(UserDO t) {
        threadLocal.set(t);
    }

    public static UserDO get() {
        return threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }
}
