package com.spring.boot.test.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.spring.boot.test.entity.TestEntity;
import com.spring.boot.test.repository.TestRepository;
import com.spring.boot.test.util.PersistUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnitUtil;

@Service
public class TestService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestService.class);

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @Autowired
    private TestRepository repo;

    @Autowired
    private EntityManager em;

    @Transactional
    public TestEntity testService(int testId) {

        TestEntity result = repo.findById(testId).orElse(null);
        String jsonResult = GSON.toJson(result);
        LOGGER.info(jsonResult);

        LOGGER.info("The TestEntity object state -> " + PersistUtil.getState(em, result));

        int oldCnt = result.getCnt();
        LOGGER.info("old CNT: -> " + oldCnt);

        // check if the calling set method executes the extra SQL.
        int newCnt1 = oldCnt + 1;
        int newCnt2 = oldCnt + 2;

        result.setCnt(newCnt1);
        result.setCnt(newCnt2);
        result.setName("test-" + newCnt2);
//        repo.updateCntById(newCnt2, testId);
//        repo.save(result);
//        result.setCnt(oldCnt + 2);
//        repo.save(result);

        TestEntity result2 = repo.findById(testId).orElse(null);
        String jsonResult2 = GSON.toJson(result2);
        LOGGER.info(jsonResult2);

        LOGGER.info("The TestEntity object state -> " + PersistUtil.getState(em, result));

//        if (true) {
//            throw new RuntimeException("Runtime exception has been thrown.");
//        }

        return result;
    }
}
