package com.zr.http;

import java.util.*;

/**
 * Description:
 *
 * @author zhangr
 * 2020/9/11 15:10
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int divide(int dividend, int divisor) {
        int count = 0;
        boolean negative = true;
        if ((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            negative = false;
        }

        int temp = divisor;
        while ( Math.abs((long)temp) <= Math.abs((long) dividend)) {
            temp += divisor;
            count++;
        }
        return negative ? -count : count;
    }
}

public class LeetCode {
    public static void main(String[] args) {
    }
}
