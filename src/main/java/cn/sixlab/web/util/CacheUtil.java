///*
// * Copyright (c) 2016 Sixlab. All rights reserved.
// *
// * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
// * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
// *
// * For more information, please see
// * http://sixlab.cn/
// *
// * @author 六楼的雨/Patrick Root
// * @since 1.0.0(2016/3/14)
// */
//package cn.sixlab.web.util;
//
//import net.spy.memcached.AddrUtil;
//import net.spy.memcached.ConnectionFactoryBuilder;
//import net.spy.memcached.MemcachedClient;
//import org.apache.commons.lang3.ObjectUtils;
//
///**
// * @author 六楼的雨/Patrick Root
// * @since 1.0.0(2016/3/14)
// */
//public class CacheUtil {
//
//    private static MemcachedClient memClient = null;
//
//    public static boolean isInit() {
//        if (memClient != null) return true;
//        return false;
//    }
//
//    public static void set(String key, String value) {
//
//        init();
//        try {
//            memClient.set(key, 0, value);
//        } catch (Exception e) {
//            memClient = null;
//            init();
//            e.printStackTrace();
//        }
//    }
//
//    public static void set(String key, String value, int seconds) {
//
//        init();
//        try {
//            memClient.set(key, seconds, value);
//        } catch (Exception e) {
//            memClient = null;
//            init();
//            e.printStackTrace();
//        }
//    }
//
//    public static void reset(String key, int seconds) {
//        try {
//            Object value = memClient.get(key);
//            memClient.replace(key, seconds, value);
//        } catch (Exception e) {
//            memClient = null;
//            init();
//            e.printStackTrace();
//        }
//    }
//
//    public static String get(String key) {
//
//        init();
//        try {
//            String value = ObjectUtils.toString(memClient.get(key));
//            return value;
//        } catch (Exception e) {
//            memClient = null;
//            init();
//            e.printStackTrace();
//            return "";
//        }
//    }
//
//    public static void del(String key) {
//
//        init();
//        try {
//            memClient.delete(key);
//        } catch (Exception e) {
//            memClient = null;
//            init();
//            e.printStackTrace();
//        }
//    }
//
//    public static void init() {
//        if (memClient != null)
//            disConnect();
//
//        try {
//            String host = "127.0.0.1";
//            String port = "11211";
//
//            memClient = new MemcachedClient(new ConnectionFactoryBuilder()
//                    .setProtocol(ConnectionFactoryBuilder.Protocol.BINARY).build(),
//                    AddrUtil.getAddresses(host + ":" + port));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void disConnect() {
//        if (memClient == null) {
//            return;
//        }
//        try {
//            memClient.shutdown();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
