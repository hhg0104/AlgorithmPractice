package com.spring.boot.test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicProgrammingOnTree {

    private int[] dp = new int[100];

    @Test
    public void testAddNumbers() {

        // Driver Code
        int n = 14;

        // adjacency list
        List<Integer>[] v = new ArrayList[n + 1];

        for (int i = 0; i < v.length; i++) {
            v[i] = new ArrayList<>();
        }

        // create undirected edges
        // initialize the tree given in the diagram
        v[1].add(2);
        v[2].add(1);
        v[1].add(3);
        v[3].add(1);
        v[1].add(4);
        v[4].add(1);
        v[2].add(5);
        v[5].add(2);
        v[2].add(6);
        v[6].add(2);
        v[3].add(7);
        v[7].add(3);
        v[4].add(8);
        v[8].add(4);
        v[4].add(9);
        v[9].add(4);
        v[4].add(10);
        v[10].add(4);
        v[5].add(11);
        v[11].add(5);
        v[5].add(12);
        v[12].add(5);
        v[7].add(13);
        v[13].add(7);
        v[7].add(14);
        v[14].add(7);

        // values of node 1, 2, 3....14
        int a[] = { 3, 2, 1, 10, 1, 3, 9, 1, 5, 3, 4, 5, 9, 8 };

        // function call
        System.out.println(maximumValue(a, v));
    }

    private int maximumValue(int[] a, List<Integer>[] v) {
        dfs(a, v, 1, 0);
        return dp[1];
    }

    // function for dfs traversal and to
    // store the maximum value in dp[]
    // for every node till the leaves
    private void dfs(int[] a, List<Integer>[] v, int u, int parent) {

        // initially dp[u] is always a[u]
        dp[u] = a[u - 1];

        // stores the maximum value from nodes
        int maximum = 0;

        // traverse the tree
        for (int child : v[u])
        {

            // if child is parent, then we continue
            // without recursing further
            if (child == parent){
                continue;
            }

            // call dfs for further traversal
            dfs(a, v, child, u);

            // store the maximum of previous visited
            // node and present visited node
            maximum = Math.max(maximum, dp[child]);
        }

        // add the maximum value returned
        // to the parent node
        dp[u] += maximum;
    }
}
