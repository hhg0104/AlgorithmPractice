package com.spring.boot.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.boot.test.entity.TestEntity;
import com.spring.boot.test.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
class SpringBootTestApplicationTests {

    private static final Logger LOGGER = LoggerFactory.getLogger(SpringBootTestApplicationTests.class);

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private TestRepository repo;

    @Test
    void getTestDataFromDB() {

        int testId = 179215;
        testFetchAndUpdateTransaction(testId);
    }

    @Transactional
    public void testFetchAndUpdateTransaction(int testId) {

        TestEntity result = repo.findById(testId).orElse(null);
        String jsonResult = GSON.toJson(result);
        LOGGER.info(jsonResult);

        // check if the calling set method executes the extra SQL.
        result.setCnt(1004);
//        repo.update(result);

        TestEntity result2 = repo.findById(testId).orElse(null);
        String jsonResult2 = GSON.toJson(result2);
        LOGGER.info(jsonResult2);
    }
}
