package com.spring.boot.test.trees;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBinaryTreeTraversalTest {

    private class Node {

        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    @Test
    public void test() {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        printLevelOrder(root);
    }

    private void printLevelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                continue;
            }
            System.out.print(node.data + " ");

            queue.add(node.left);
            queue.add(node.right);
        }
    }
}
