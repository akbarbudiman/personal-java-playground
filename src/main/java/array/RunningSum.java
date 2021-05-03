package src.main.java.array;

public class RunningSum {

/*
 * 	origin:
 *  https://leetcode.com/explore/challenge/card/may-leetcoding-challenge-2021/598/week-1-may-1st-may-7th/3730/
 *  
 *  given:
 *  array of int: nums
 *  
 *  return:
 *  array of int: arr, where arr[i] = sum(nums[0], nums[1], ..., nums[i])
 *  
 *  idea:
 *  put arr[0], then simply running
 */
	
	public int[] runningSum(int[] nums) {
        int numsLen = nums.length;
        int[] result = new int[numsLen];
        result[0] = nums[0];
        for (int i = 1 ; i < numsLen ; i = i + 1) {
            result[i] = result[i-1] + nums[i];
        }
        return result;
    }
	
}
