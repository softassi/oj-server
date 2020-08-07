package com.softassi.oj.server.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.JSONLibDataFormatSerializer;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

@Slf4j
public class JsonUtils {

    private static final SerializeConfig config;

    static {
        config = new SerializeConfig();
        // 使用和json-lib兼容的日期输出格式
        config.put(java.util.Date.class, new JSONLibDataFormatSerializer());
        // 使用和json-lib兼容的日期输出格式
        config.put(java.sql.Date.class, new JSONLibDataFormatSerializer());

    }

    /**
     * 输出空置字段
     */
    private static final SerializerFeature[] features = {SerializerFeature.WriteMapNullValue,
            // list字段如果为null，输出为[]，而不是null
            SerializerFeature.WriteNullListAsEmpty,
            // 数值字段如果为null，输出为0，而不是null
//            SerializerFeature.WriteNullNumberAsZero,
            // Boolean字段如果为null，输出为false，而不是null
            SerializerFeature.WriteNullBooleanAsFalse,
            // 字符类型字段如果为null，输出为""，而不是null
            SerializerFeature.WriteNullStringAsEmpty
    };

    public static JSONObject getFson() {
        return new JSONObject();
    }

    public static JSONArray getFsonArray() {
        return new JSONArray();
    }

    /**
     * 类转json字符串 时间复杂化处理,并且会打印空属性
     *
     * @param object
     * @return
     */
    public static String objToJsonStrWithCF(Object object) {
        return JSON.toJSONString(object, config, features);
    }

    /**
     * 类转json字符串  时间复杂化处理,空属性不会打印 "time":1556449527766,"minutes":5,"seconds":27,"hours":19,"month":3,"year":119,"timezoneOffset":-480,"day":0,"date":28
     *
     * @param object
     * @return
     */
    public static String objToJsonStrWithC(Object object) {
        return JSON.toJSONString(object, config);
    }

    /**
     * 类转json字符串   会打印对象中所有的属性,没值的直接为空
     *
     * @param object
     * @return
     */
    public static String objToJsonStrWithF(Object object) {
        return JSON.toJSONString(object);
    }

    /**
     * 推荐使用
     * 类转json字符串  只打印对象中有值的,没有值的不打印
     *
     * @param object
     * @return
     */
    public static String obj2JsonStr(Object object) {
        ParserConfig.getGlobalInstance().setAsmEnable(false);

        return JSON.toJSONString(object, features);
    }


    /**
     * json字符串转为object类
     *
     * @param text
     * @return
     */
    public static Object strToBean(String text) {
        return JSON.parse(text);
    }

    /**
     * json字符串转bean
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T strToBean(String text, Class<T> clazz) {
        return JSON.parseObject(text, clazz);
    }

    /**
     * json字符串转为数组
     *
     * @param text
     * @param <T>
     * @return
     */
    public static <T> Object[] strToArray(String text) {
        return strToArray(text, null);
    }

    /**
     * json字符串转为对象数组
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Object[] strToArray(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz).toArray();
    }

    /**
     * json字符串转为 对象集合
     *
     * @param text
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> strToList(String text, Class<T> clazz) {
        return JSON.parseArray(text, clazz);
    }


    /**
     * 将string转化为序列化的json字符串
     *
     * @return
     */
    public static Object strToJson(String str) {
        Object objectJson = JSON.parse(str);
        return objectJson;
    }

    /**
     * json字符串转化为map
     *
     * @param str
     * @return
     */
    public static <K, V> Map<K, V> strToMap(String str) {
        Map<K, V> m = (Map<K, V>) JSONObject.parseObject(str);
        return m;
    }

    /**
     * 转换JSON字符串为对象
     *
     * @param str
     * @param clazz
     * @return
     */
    public static Object strToObject(String str, Class<?> clazz) {
        return JSONObject.parseObject(str, clazz);
    }


    /**
     * 将map转化为string
     *
     * @param map
     * @return
     */
    public static <K, V> String mapToStr(Map<K, V> map) {
        String s = JSONObject.toJSONString(map);
        return s;
    }
}

 
 
