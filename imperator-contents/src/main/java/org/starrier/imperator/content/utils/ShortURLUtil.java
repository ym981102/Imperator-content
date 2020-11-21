/*
package org.starrier.imperator.content.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

import javax.annotation.Resource;

*/
/**
 * @author starrier
 * @date 2020/11/22
 *//*

@Component
public class ShortURLUtil {


    @Resource
    private RedisTemplate redisTemplate;

    private static final String SHORT_URL_KEY = "SHORT_URL_KEY";
    private static final String LOCALHOST = "http://www.baidu.com";
    private static final String SHORT_LONG_PREFIX = "short_long_prefix_";
    private static final String CACHE_KEY_PREFIX = "cache_key_prefix_";
    private static final int CACHE_SECONDS = 1 * 60 * 60;

    */
/**
     * 在进制表示中的字符集合
     *//*

    private final static char[] DIGITS = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
            'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
            'u', 'v', 'w', 'x', 'y', 'z'
    };



    public String getShortURL(String targetUrl){
        return getShortURL(targetUrl,Decimal.D64);
    }


    public String getShortURL(String targetUrl, Decimal decimal) {

        // 查询缓存
        ValueOperations valueOperations = redisTemplate.opsForValue();
        String cache = (String) valueOperations.get(CACHE_KEY_PREFIX + targetUrl);
        if (cache != null) {
            return LOCALHOST + toOtherBaseString(Long.parseLong(cache), decimal.x);
        }

        // 自增
        long num = valueOperations.increment(SHORT_URL_KEY);
        // 在数据库中保存短-长URL的映射关系,可以保存在MySQL中
        valueOperations.set(SHORT_LONG_PREFIX + num, targetUrl);
        // 写入缓存
        valueOperations.set(CACHE_KEY_PREFIX + targetUrl, CACHE_SECONDS, String.valueOf(num));

        return LOCALHOST + toOtherBaseString(num, decimal.x);
    }

    public String parseShortUrl(String targetUrl,Decimal decimal){

    }

    */
/**
     * 由10进制的数字转换到其他进制
     *//*

    private String toOtherBaseString(long n, int base) {
        long num = 0;
        if (n < 0) {
            num = ((long) 2 * 0x7fffffff) + n + 2;
        } else {
            num = n;
        }
        char[] buf = new char[32];
        int charPos = 32;
        while ((num / base) > 0) {
            buf[--charPos] = DIGITS[(int) (num % base)];
            num /= base;
        }
        buf[--charPos] = DIGITS[(int) (num % base)];
        return new String(buf, charPos, (32 - charPos));
    }

    */
/**
     * 域名压缩格式
     *//*

    enum Decimal {
        */
/**
         * 压缩策略
         *//*

        D32(32),
        D64(64);

        int x;

        Decimal(int x) {
            this.x = x;
        }
    }

}
*/
