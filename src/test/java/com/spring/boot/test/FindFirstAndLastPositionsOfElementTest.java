package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindFirstAndLastPositionsOfElementTest {

    @Test
    public void test() {

        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        findFirstAndLastPosition(arr, 8);
    }

    private void findFirstAndLastPosition(int[] arr, int element) {

        if (arr == null || arr.length == 0) {
            return;
        }

        int first = -1;
        int last = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != element) {
                continue;
            }

            if (first == -1) {
                first = i;
            }

            last = i;
        }

        System.out.println("First position: " + first);
        System.out.println("Last position: " + last);
    }

    @Test
    public void test2() {

        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int first = first2(arr, 0, arr.length - 1, 8, arr.length);
        System.out.println("-------------------------------");
        int last = last2(arr, 0, arr.length - 1, 8, arr.length);

        System.out.println("First: " + first + ", Last: " + last);

        Assertions.assertEquals(first, 8);
        Assertions.assertEquals(last, 9);

        int arr2[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int first2 = first(arr2, 0, arr2.length - 1, 2, arr2.length);
        int last2 = last(arr2, 0, arr2.length - 1, 2, arr2.length);

        System.out.println("First2: " + first2 + ", Last2: " + last2);

        Assertions.assertEquals(first2, 1);
        Assertions.assertEquals(last2, 4);

        int arr3[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int first3 = first(arr3, 0, arr3.length - 1, 9, arr3.length);
        int last3 = last(arr3, 0, arr3.length - 1, 9, arr3.length);

        System.out.println("First2: " + first3 + ", Last2: " + last3);

        Assertions.assertEquals(first3, -1);
        Assertions.assertEquals(last3, -1);
    }

    private int first(int[] arr, int low, int high, int element, int length) {

        if (high < low) {
            return -1;
        }

        System.out.println("First Method...");
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int mid = low + (high - low) / 2;
        System.out.println("Mid: " + mid);

        if ((mid == 0 || element > arr[mid - 1]) && arr[mid] == element) {
            return mid;

        } else if (element > arr[mid]) {
            return first(arr, mid + 1, high, element, length);

        } else {
            return first(arr, low, mid - 1, element, length);
        }
    }

    private int last(int[] arr, int low, int high, int element, int length) {

        if (high < low) {
            return -1;
        }

        System.out.println("Last Method...");
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        int mid = low + (high - low) / 2;
        System.out.println("Mid: " + mid);

        if ((mid == length - 1 || element < arr[mid + 1]) && arr[mid] == element) {
            return mid;

        } else if (element < arr[mid]) {
            return last(arr, low, (mid - 1), element, length);

        } else {
            return last(arr, (mid + 1), high, element, length);
        }
    }

    private int first2(int[] arr, int low, int high, int target, int length) {

        if (high < low) {
            return -1;
        }

        int mid = low + ((high - low) / 2);

        if (mid == 0 && target == arr[mid]) {
            return mid;
        }

        if (target > arr[mid - 1] && target == arr[mid]) {
            return mid;

        } else if (target > arr[mid]) {
            return first2(arr, (mid + 1), high, target, length);

        } else {
            return first2(arr, low, (mid - 1), target, length);
        }
    }

    private int last2(int[] arr, int low, int high, int target, int length) {

        if (high < low) {
            return -1;
        }

        int mid = low + ((high - low) / 2);

        if (mid == length - 1 && target == arr[mid]) {
            return mid;
        }

        if (target < arr[mid + 1] && target == arr[mid]) {
            return mid;

        } else if (target < arr[mid]) {
            return last2(arr, low, (mid - 1), target, length);

        } else {
            return last2(arr, (mid + 1), high, target, length);
        }
    }
}
