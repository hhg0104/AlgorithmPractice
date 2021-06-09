package com.spring.boot.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.

    Notice that you may not slant the container.


    Example 1:

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49
    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    Example 2:

    Input: height = [1,1]
    Output: 1
    Example 3:

    Input: height = [4,3,2,1,4]
    Output: 16
    Example 4:

    Input: height = [1,2,1]
    Output: 2

    Constraints:

    n == height.length
    2 <= n <= 105
    0 <= height[i] <= 104
 */
public class ContainerWithMostWaterTest {

    @Test
    public void test() {

        int actual1 = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
        Assertions.assertEquals(49, actual1);

        int actual2 = maxArea(new int[]{1, 1});
        Assertions.assertEquals(1, actual2);

        int actual3 = maxArea(new int[]{4,3,2,1,4});
        Assertions.assertEquals(16, actual3);

        int actual4 = maxArea(new int[]{1,2,1});
        Assertions.assertEquals(2, actual4);
    }

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int currentWater = Math.min(height[left], height[right]) * (right - left);
            maxWater = Math.max(maxWater, currentWater);

            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }

        return maxWater;
    }
}
