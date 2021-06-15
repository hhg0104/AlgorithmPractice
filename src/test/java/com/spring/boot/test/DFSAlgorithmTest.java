package com.spring.boot.test;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.ListIterator;

public class DFSAlgorithmTest {

    @Test
    public void test() {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.dfs(2);
    }

    class Graph {

        private int vertices;

        private LinkedList<Integer>[] adjs;

        Graph(int vertices) {
            this.vertices = vertices;
            adjs = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjs[i] = new LinkedList<>();
            }
        }

        public void addEdge(int vertice, int val) {
            adjs[vertice].add(val);
        }

        public void dfs(int startPoint) {

            dfs(startPoint, new boolean[vertices]);
        }

        public void dfs(int point, boolean[] visited) {

            visited[point] = true;
            System.out.print(point + " ");
            ListIterator<Integer> list = adjs[point].listIterator();
            while (list.hasNext()) {
                int val = list.next();
                while (!visited[val]) {
                    dfs(val, visited);
                }
            }
        }
    }
}
