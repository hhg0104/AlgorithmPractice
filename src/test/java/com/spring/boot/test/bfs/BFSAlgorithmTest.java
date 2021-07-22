package com.spring.boot.test.bfs;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFSAlgorithmTest {

    @Test
    public void test() {

        Graph g = new Graph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        g.bfs(2);
    }

    class Graph {

        private int vertices;

        private LinkedList<Integer>[] adjs;

        public Graph(int vertices) {
            this.vertices = vertices;
            adjs = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjs[i] = new LinkedList<>();
            }
        }

        public void addEdge(int vertice, int val) {
            adjs[vertice].add(val);
        }

        public void bfs(int point) {
            boolean[] visited = new boolean[this.vertices];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.add(point);
            visited[point] = true;

            while (!queue.isEmpty()) {
                int val = queue.poll();
                System.out.print(val + " ");
                ListIterator<Integer> iter = adjs[val].listIterator();
                while (iter.hasNext()) {
                    int n = iter.next();
                    if (!visited[n]) {
                        queue.add(n);
                        visited[n] = true;
                    }
                }
            }

        }
    }
}
