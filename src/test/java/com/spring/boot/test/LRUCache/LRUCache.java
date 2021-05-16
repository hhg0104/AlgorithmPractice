package com.spring.boot.test.LRUCache;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Data
public class LRUCache {

    class CacheNode {

        private String id;

        private TestCacheData data;

        private CacheNode prev;

        private CacheNode next;

        public CacheNode(String id, TestCacheData data) {
            this.id = id;
            this.data = data;
        }
    }

    private Map<String, CacheNode> cacheMap = new HashMap<>();

    private CacheNode head;

    private CacheNode tail;

    private final int maxSize;

    private int size;

    private final int expiryTime;

    public LRUCache(int maxSize) {
        this.maxSize = maxSize;
        this.expiryTime = -1;
    }

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
    public TestCacheData fetch(String id) {

        if (id == null || id.isEmpty()) {
            return null;
        }

        CacheNode cacheNode = cacheMap.get(id);
        if (cacheNode == null) {
            return null;
        }

        boolean isExpired = isCacheExpired(cacheNode);
        if (isExpired) {
            deleteNode(cacheNode);
            return null;
        }

        if (this.head == cacheNode) {
            return cacheNode.data;
        }

        deleteNode(cacheNode);
        CacheNode oldHead = this.head;
        oldHead.prev = cacheNode;
        cacheNode.next = oldHead;

        size++;

        return cacheNode.data;
    }

    /**
     * Update the cache data.
     *
     * @param id   new data id
     * @param data new data object
     */
    public void insert(String id, TestCacheData data) {

        if (id == null || id.isEmpty() || data == null) {
            return;
        }

        CacheNode cacheNode = cacheMap.get(id);
        if (cacheNode != null) {
            deleteNode(cacheNode);
        }

        CacheNode newCache = new CacheNode(id, data);

        if (isEmpty()) {
            this.head = newCache;
            this.tail = newCache;

            cacheMap.put(id, newCache);

            size++;
            return;
        }

        if (isFull()) {
            deleteLastNode();
        }

        CacheNode oldHead = this.head;
        oldHead.prev = newCache;
        newCache.next = oldHead;
        this.head = newCache;

        cacheMap.put(id, newCache);

        size++;
    }

    private void deleteNode(CacheNode cacheNode) {

        if (cacheNode == null) {
            return;
        }

        if (isEmpty()) {
            return;
        }

        if (this.head == cacheNode) {
            deleteFirstNode();

        } else if (this.tail == cacheNode) {
            deleteLastNode();

        } else {
            deleteMiddleNode(cacheNode);
        }
    }

    private void deleteFirstNode() {

        if (this.head == null) {
            return;
        }

        CacheNode oldHead = this.head;
        if (oldHead.next == null) {
            this.head = null;

        } else {
            this.head = oldHead.next;
            oldHead.next = null;
        }

        cacheMap.remove(oldHead.id);
        size--;
    }

    private void deleteLastNode() {

        if (this.tail == null) {
            return;
        }

        CacheNode oldTail = this.tail;

        if (oldTail.prev == null) {
            this.tail = null;

        } else {
            this.tail = oldTail.prev;
            this.tail.next = null;
            oldTail.prev = null;
        }

        cacheMap.remove(oldTail.id);
        size--;
    }

    private void deleteMiddleNode(CacheNode cacheNode) {

        CacheNode prevNode = cacheNode.prev;
        CacheNode nextNode = cacheNode.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        cacheMap.remove(cacheNode.id);
        size--;
    }

    /**
     * Check if the cache data is expired
     *
     * @param cacheNode cached data node
     * @return if the cache is expired
     */
    private boolean isCacheExpired(CacheNode cacheNode) {

        if (this.expiryTime < 0) {
            return false;
        }

        TestCacheData cachedData = cacheNode.data;
        if (cachedData == null) {
            return true;
        }

        LocalDateTime createdDateTime = cachedData.getCreatedDateTime();
        if (createdDateTime == null) {
            return true;
        }

        return createdDateTime.plusSeconds(expiryTime).compareTo(LocalDateTime.now()) >= 0;
    }

    private boolean isEmpty() {
        return this.head == null;
    }

    private boolean isFull() {
        return this.size == this.maxSize;
    }
}
