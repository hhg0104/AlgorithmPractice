package com.spring.boot.test.interviews;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    Time Complexity: O(length of name ^ 2)
    Space Complexity: O(size of pairClasses * 3)
 */
public class FindPairDuplicateClasses {

    @Test
    public void test() {
        String[][] pairClasses = new String[][]{
                {"58", "class1"},
                {"91", "class4"},
                {"91", "class5"},
                {"78", "class1"},
                {"58", "class4"},
                {"58", "class5"},
                {"78", "class3"}
        };

        Map<String, List<String>> duplicatesClassMap = findPairClassMap(pairClasses);
        Iterator<Map.Entry<String, List<String>>> iter = duplicatesClassMap.entrySet().iterator();
        while(iter.hasNext()) {
            Map.Entry<String, List<String>> entry = iter.next();
            String pairName = entry.getKey();
            List<String> classes = entry.getValue();
            System.out.println(pairName + ": " + String.join(",", classes));
        }
    }

    private Map<String, List<String>> findPairClassMap(String[][] pairClasses) {

        Map<String, Set<String>> pairClassMap = new LinkedHashMap<>();
        for (String[] nameAndClass : pairClasses) { // O(n)
            String name = nameAndClass[0];
            String cls = nameAndClass[1];
            Set<String> classes = pairClassMap.get(name);
            if (classes == null) {
                classes = new HashSet<>();
            }
            classes.add(cls);
            pairClassMap.put(name, classes);
        }

        Map<String, List<String>> newPairClassMap = new LinkedHashMap<>();
        List<String> keyList = new ArrayList<>(pairClassMap.keySet()); // O(n)
        for (int i = 0; i < keyList.size(); i++) { // O(n^2)
            for (int j = i + 1; j < keyList.size(); j++) {
                String name1 = keyList.get(i);
                String name2 = keyList.get(j);
                List<String> duplicateClasses = findDuplicatesClasses(pairClassMap.get(name1), pairClassMap.get(name2)); // O(k)
                newPairClassMap.put(name1 + "," + name2, duplicateClasses);
            }
        }

        return newPairClassMap;
    }

    private List<String> findDuplicatesClasses(Set<String> class1, Set<String> class2) {

        List<String> duplicateClasses = new ArrayList<>();

        Iterator<String> iter = class1.iterator();
        while (iter.hasNext()) {
            String cls = iter.next();
            if (class2.contains(cls)) {
                duplicateClasses.add(cls);
            }
        }

        return duplicateClasses;
    }
}
