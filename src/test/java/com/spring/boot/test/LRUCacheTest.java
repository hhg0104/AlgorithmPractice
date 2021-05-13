package com.spring.boot.test;

import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheTest {


    @Test
    public void test() {

    }

    @Data
    class CacheData {

        private String data;

        private LocalDateTime createdDateTime = LocalDateTime.now();

        public CacheData(String data) {
            this.data = data;
        }
    }

    class LRUCache {

        @Data
        private class CacheNode {

            private CacheData data;

            private CacheNode prev;

            private CacheNode next;

            public CacheNode(CacheData data) {
                this.data = data;
            }
        }

        private Map<String, CacheNode> cacheMap = new HashMap<>();

        private CacheNode head;

        private CacheNode tail;

        private final int maxSize;

        private int size;

        private int expiryTime;

        public LRUCache(int maxSize, int expiryTime) {
            this.maxSize = maxSize;
            this.expiryTime = expiryTime;
        }

        /**
         * Fetch a cached data.
         *
         * @param id cache data id
         * @return cached data
         */
        public CacheData fetch(String id) {

            CacheNode cacheNode = cacheMap.get(id);
            if (cacheNode == null) {
                return null;
            }

            boolean isExpired = isCacheExpired(cacheNode);
            if (isExpired) {
                removeCacheNode(cacheNode);
                return null;
            }

            if (this.head == cacheNode) {
                return cacheNode.data;
            }

            if (this.tail == cacheNode) {
                CacheNode prevNode = cacheNode.prev;

                prevNode.next = null;
                cacheNode.prev = null;

                this.head.prev = cacheNode;
                cacheNode.next = this.head;

                this.head = cacheNode;
                this.tail = prevNode;

                return cacheNode.data;
            }

            cacheNode.prev.next = cacheNode.next;
            cacheNode.next.prev = cacheNode.prev;

            cacheNode.prev = null;
            cacheNode.next = this.head;

            this.head = cacheNode;

            return cacheNode.data;
        }

        /**
         * Update the cache data.
         *
         * @param id new data id
         * @param data new data object
         */
        public void store(String id, CacheData data) {

            if (id == null || id.isEmpty() || data == null) {
                return;
            }

            CacheNode newCache = new CacheNode(data);

            CacheNode cacheNode = cacheMap.get(id);
            if (cacheNode != null) {
                return;
            }

            if (this.size == this.maxSize) {
                cacheList.removeLast();
            }

            cacheMap.put(id, newCache);
            cacheList.addFirst(newCache);

            this.head = newCache;
        }

        /**
         * Check if the cache data is expired
         *
         * @param cacheNode cached data node
         * @return if the cache is expired
         */
        private boolean isCacheExpired(CacheNode cacheNode) {

            CacheData cachedData = cacheNode.getData();
            if (cachedData == null) {
                return true;
            }

            LocalDateTime createdDateTime = cachedData.getCreatedDateTime();
            if (createdDateTime == null) {
                return true;
            }

            return createdDateTime.plusSeconds(expiryTime).compareTo(LocalDateTime.now()) >= 0;
        }

        private void removeCacheNode(CacheNode cacheNode) {
            // TODO remove a specific node
        }
    }

    @Test
    public void testDateCompare() {

        LocalDateTime time1 = LocalDateTime.of(2021, 5, 13, 17, 50, 10);

        int futureVal = time1.compareTo(LocalDateTime.now());

        Assertions.assertEquals(1, futureVal);
    }
}
