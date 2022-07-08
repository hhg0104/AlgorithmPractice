package com.spring.boot.test.graph;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
    Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
    write a function to check whether these edges make up a valid tree.

    For example:

    Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

    Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

    Note: you can assume that no duplicate edges will appear in edges.
    Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
*/
public class GraphValidTree {

    @Data
    @AllArgsConstructor
    private class TwoNum {

        private int first;

        private int second;
    }

    @Test
    public void test() {

        // 0 -> 1 -> 2 -> 3
        // 1 -> 0 -> 4
        // 2 -> 0
        // 3 -> 0
        // 4 -> 1
        int[][] arr1 = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        boolean answer1 = validTreeDFS(5, arr1);
        Assertions.assertEquals(true, answer1);

        // 0 -> 1
        // 1 -> 0 -> 2 -> 3 -> 4
        // 2 -> 1 -> 3
        // 3 -> 2 -> 1
        // 4 -> 1
        int[][] arr2 = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
        boolean answer2 = validTreeDFS(5, arr2);
        Assertions.assertEquals(false, answer2);

        int[][] arr3 = {{0, 1}, {1, 2}, {2, 4}};
        boolean answer3 = validTreeDFS(5, arr3);
        Assertions.assertEquals(false, answer3);
    }

    public boolean validTree(int n, int[][] edges) {

        int[] nums = new int[n];
        Arrays.fill(nums, -1);

        for (int[] edge : edges) {
            int x = find(nums, edge[0]);
            int y = find(nums, edge[1]);

            if (x == y) {
                return false;
            }

            nums[y] = x;
        }

        return edges.length == n - 1;
    }

    public int find(int[] nums, int i) {
        if (nums[i] == -1) {
            return i;
        }
        return find(nums, nums[i]);
    }

    private boolean validTreeDFS(int n, int[][] edges) {

        Graph graph = new Graph(n);

        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            graph.addEdge(node1, node2);
        }

        List<Integer>[] adjs = graph.getAdjacents();
        for (List<Integer> adj : adjs) {
            if (adj == null || adj.isEmpty()) {
                return false;
            }
        }

        return !hasCycleConnection(0, -1, new boolean[n], graph);
    }

    private boolean hasCycleConnection(int current, int parent, boolean[] visited, Graph graph) {

        visited[current] = true;

        List<Integer> adjacent = graph.getAdjacents()[current];
        for (int node : adjacent) {

            if (!visited[node]) {
                return hasCycleConnection(node, current, visited, graph);

            } else {
                if (node != parent) {
                    return true;
                }
            }
        }

        return false;
    }

    class Graph {

        private List<Integer>[] adjacents;

        public Graph(int vertices) {
            adjacents = new ArrayList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjacents[i] = new ArrayList();
            }
        }

        public void addEdge(int node1, int node2) {
            adjacents[node1].add(node2);
            adjacents[node2].add(node1);
        }

        public List<Integer>[] getAdjacents() {
            return adjacents;
        }
    }
}
