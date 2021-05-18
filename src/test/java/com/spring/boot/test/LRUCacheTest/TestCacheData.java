package com.spring.boot.test.LRUCacheTest;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TestCacheData {

    private String data;

    private LocalDateTime createdDateTime = LocalDateTime.now();

    public TestCacheData(String data) {
        this.data = data;
    }
}
