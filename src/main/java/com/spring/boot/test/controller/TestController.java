package com.spring.boot.test.controller;

import com.spring.boot.test.entity.TestEntity;
import com.spring.boot.test.service.TestService;
import com.spring.boot.test.util.PersistUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService service;

    @Autowired
    private EntityManager em;

    @PostMapping("/test")
    public String test(String name, List<String> ids) {
        System.out.println("name: " + name + ", ids: " + ids);

        return "success";
    }

    @CrossOrigin
    @GetMapping("/test/data")
    public Map<String, Object> testData(HttpServletRequest req) throws IOException {

//        int testId = 179215;
//        TestEntity result = service.testService(testId);
//        LOGGER.info("The TestEntity object state -> " + PersistUtil.getState(em, result));

        HttpSession session = req.getSession(false);
        if(session == null) {
            LOGGER.info("Session is null.");
            session = req.getSession();
        }

        int currentSessionSize = getSessionSize(session);
        LOGGER.info("Session size -> " + currentSessionSize);

        Enumeration<String> attrNames = session.getAttributeNames();
        boolean hasTestAttr = false;
        while(attrNames.hasMoreElements()) {
            if("test".equals(attrNames.nextElement())) {
                hasTestAttr = true;
                break;
            }
        }

        if(hasTestAttr == false) {
            session.setAttribute("test", "adlkfjasdlfkjaldfjalkjfla jfilasdjfdlkfjalsifjalfljkljflsdkf" +
                    "ladskfjaldkjflasdkfjaldskjfasdlkfjdlskfjsldfjalsfjasldfkjaslkfjlaeijfelijflekjflakdjfalsdkj" +
                    "fdalsfkjslkfjsdlkfjsldjk");
        }

        String attr = (String) session.getAttribute("test");
        session.setAttribute("test", attr + attr);

        Map<String, Object> testData = new HashMap<>();
        testData.put("name", "Luke Skywalker");
        testData.put("sessionSize", currentSessionSize);
        return testData;
    }

    private int getSessionSize(HttpSession session) throws IOException {
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bo);
        for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            oos.writeObject(session.getAttribute(key));
        }
        oos.flush();
        return bo.size();
    }
}
