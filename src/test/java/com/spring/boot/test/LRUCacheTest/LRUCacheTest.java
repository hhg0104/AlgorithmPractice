package com.spring.boot.test.LRUCacheTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class LRUCacheTest {

    @Test
    public void test() {

    }

    @Test
    public void testLRUCache() {

        LRUCache cacheManager = new LRUCache(5);

        TestCacheData data1 = new TestCacheData("data-1");
        TestCacheData data2 = new TestCacheData("data-2");
        TestCacheData data3 = new TestCacheData("data-3");
        TestCacheData data4 = new TestCacheData("data-4");
        TestCacheData data5 = new TestCacheData("data-5");
        TestCacheData data6 = new TestCacheData("data-6");
        TestCacheData data7 = new TestCacheData("data-7");

        cacheManager.insert("1", data1);
        cacheManager.insert("2", data2);
        cacheManager.insert("3", data3);
        cacheManager.insert("4", data4);
        cacheManager.insert("5", data5);
        cacheManager.insert("6", data6);
        cacheManager.insert("7", data7);

        Map<String, LRUCache.CacheNode> cacheMap = cacheManager.getCacheMap();

        Assertions.assertEquals(5, cacheMap.size());
        Assertions.assertNull(cacheManager.fetch("1"));
        Assertions.assertNull(cacheManager.fetch("2"));
        Assertions.assertEquals("data-3", cacheManager.fetch("3").getData());
        Assertions.assertEquals("data-4", cacheManager.fetch("4").getData());
        Assertions.assertEquals("data-5", cacheManager.fetch("5").getData());
        Assertions.assertEquals("data-6", cacheManager.fetch("6").getData());
        Assertions.assertEquals("data-7", cacheManager.fetch("7").getData());

        LRUCache.CacheNode head = cacheManager.getHead();
    }
}
