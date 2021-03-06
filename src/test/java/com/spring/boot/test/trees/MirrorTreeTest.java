package com.spring.boot.test.trees;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MirrorTreeTest {

    private class Node {

        Node left;

        Node right;

        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    @Test
    public void test() {

        Node testNode = new Node(1);
        testNode.left = new Node(3);
        testNode.right = new Node(2);
        testNode.right.left = new Node(5);
        testNode.right.right = new Node(4);

        mirror(testNode);

        Assertions.assertEquals(1, testNode.data);
        Assertions.assertEquals(2, testNode.left.data);
        Assertions.assertEquals(3, testNode.right.data);
        Assertions.assertEquals(4, testNode.left.left.data);
        Assertions.assertEquals(5, testNode.left.right.data);
        Assertions.assertNull(testNode.right.left);
        Assertions.assertNull(testNode.right.right);

    }

    private void mirror(Node node) {

        if (node == null) {
            return;
        }

        Node tempLeft = node.left;
        node.left = node.right;
        node.right = tempLeft;

        mirror(node.left);
        mirror(node.right);
    }

    private Node mirror2(Node node) {
        if (node == null)
            return node;

        /* do the subtrees */
        Node left = mirror2(node.left);
        Node right = mirror2(node.right);

        /* swap the left and right pointers */
        node.left = right;
        node.right = left;

        return node;
    }
}
