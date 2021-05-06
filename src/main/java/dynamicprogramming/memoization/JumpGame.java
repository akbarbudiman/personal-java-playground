package src.main.java.dynamicprogramming.memoization;

import java.util.HashMap;

public class JumpGame {

	/*
	 * origin:
	 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3732/
	 * 
	 * given: 
	 * array of non-negative integer: nums ,
	 * where nums[i] = maximum jump length
	 * 
	 * goal:
	 * from i = 0 go to i = nums.length - 1
	 * 
	 * result:
	 * minimum jump(s) needed
	 */
	
    public int jump(int[] nums) {
        return jump(nums, nums.length-1, 0, new HashMap<Integer,Integer>());
    }
    
    public int jump(int[] nums, int goal, int pos, HashMap<Integer,Integer> memo) {
        if (pos >= goal) return 0;
        if (memo.containsKey(pos)) return memo.get(pos);
        
        int maxNext = pos + nums[pos];
        int minimumJumpsFromNextToGoal = 1001;
        for (int next = (pos + 1) ; next <= maxNext ; next = next + 1) {
            int posAfterThis = 1 + jump(nums, goal, next, memo);
            minimumJumpsFromNextToGoal = Math.min(minimumJumpsFromNextToGoal, posAfterThis);
        }
        
        memo.put(pos, minimumJumpsFromNextToGoal);
        return minimumJumpsFromNextToGoal;
    }
	
}
