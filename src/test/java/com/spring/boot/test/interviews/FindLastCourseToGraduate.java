package com.spring.boot.test.interviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
    To graduate, the student need to take 50% of classes at least.
    Find the last class to graduate among the {prerequisite class, class} array.
 */
public class FindLastCourseToGraduate {

    @Test
    public void test() {
        String[][] classes = new String[][] {
                {"class4", "class5"},
                {"class3", "class4"},
                {"class2", "class3"},
                {"class1", "class2"},
        };

        String result = courseList(classes);
        Assertions.assertEquals("class3", result);
    }

    private String courseList(String[][] classes) {

        Map<String, String> classMap = new HashMap<>(); // Space O(size of classes)
        Map<String, String> reverseClassMap = new HashMap<>(); // Space O(size of classes)

        for (String[] cls : classes) { // Time O(length of classes)
            String preClass = cls[0];
            String postClass = cls[1];

            classMap.put(preClass, postClass);
            reverseClassMap.put(postClass, preClass);
        }

        String[] firstClass = findFirstClassPair(classMap, reverseClassMap); // Time O(length of classes)

        return findLastClassToGraduate(classMap, firstClass, classes.length); // Time O(length of classes / 2)
    }

    private String findLastClassToGraduate(Map<String, String> classMap, String[] firstClass, int classLength) {

        int lastClassIdx = classLength / 2;
        if (classLength % 2 != 0) {
            lastClassIdx += 1;
        }

        List<String> resultList = new ArrayList<>();
        resultList.add(firstClass[0]);
        resultList.add(firstClass[1]);

        lastClassIdx -= 2;

        String postClass = firstClass[1];
        while (lastClassIdx >= 0) {
            postClass = classMap.get(postClass);
            lastClassIdx--;
        }

        return postClass;
    }

    private String[] findFirstClassPair(Map<String, String> classMap, Map<String, String> reverseClassMap) {

        String[] firstClass = new String[2];

        Iterator<Map.Entry<String, String>> iter = classMap.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<String, String> entry = iter.next();
            String preClass = entry.getKey();
            String postClass = entry.getValue();

            if (!reverseClassMap.containsKey(preClass)) {
                firstClass[0] = preClass;
                firstClass[1] = postClass;
                break;
            }
        }
        return firstClass;
    }
}
