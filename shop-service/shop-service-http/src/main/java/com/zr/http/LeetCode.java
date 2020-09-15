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

//单调队列
class MonotonicQueue {
    private LinkedList<Integer> data = new LinkedList<>();

    //新增的时候需要保障：队首到队尾 -> 单调递减
    public void addLast(int num) {
        while (!data.isEmpty() && data.getLast() < num) {
            data.removeLast();
        }

        //添加数据到队尾
        data.addLast(num);
    }

    //这里要确保值是对应的才进行删除
    public void removeFirst(int n) {
        if (!data.isEmpty() && data.getFirst() == n) data.removeFirst();
    }

    public int max() {
        return data.getFirst();
    }
}

class Solution {
    //滑动窗口的最大值
    //使用单调队列，也就是队首值最大，每次数据入队如果数字更大把之前的数据从队首移除直到保证单调性
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonicQueue window = new MonotonicQueue();
        int[] res = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1)
                window.addLast(nums[i]);
            else {
                //添加新的元素
                window.addLast(nums[i]);
                res[i + 1 - k] = window.max();
                //这里要确定删除的元素，如果不是最大元素那也没必要删除
                window.removeFirst(nums[i - k + 1]);
            }
        }

        return res;
    }
}

public class LeetCode {
    public static void main(String[] args) {
//        new Solution().nextGreaterElements(nums);
    }
}
