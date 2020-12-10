package org.starrier.imperator.content.utils;

import org.junit.Test;

import static org.starrier.imperator.content.utils.ShortUrlUtils.shortUrl;

/**
 * @author starrier
 * @date 2020/12/10
 */
public class ShortUrlTest {

    @Test
    public void shortUrlTest() {
        String sLongUrl = "https://starrier.blog.csdn.net/"; // 长链接
        String[] aResult = shortUrl(sLongUrl);
        // 打印出结果
        for (int i = 0; i < aResult.length; i++) {
            System.out.println("[" + i + "]:::" + aResult[i]);
        }

        String s = CMyEncrypt.md5("https://starrier.blog.csdn.net/");
        System.out.println(s);
    }
}
