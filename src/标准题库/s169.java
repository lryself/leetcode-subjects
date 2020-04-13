package 标准题库;

import java.util.Arrays;

public class s169 {
    public static void main(String args[])
    {
        int nums[]=new int[]{6,6,6,7,7};
        Solution solution=new Solution();
        System.out.println(solution.majorityElement(nums));
    }
    static class Solution {
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length/2];
        }
    }
}