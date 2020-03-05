package 标准题库;

import java.util.Arrays;

public class subject1103 {
    public static void main(String args[])
    {
        Solution solution=new Solution();
        int candies = 7, num_people = 4;
        int ans[]=solution.distributeCandies(candies,num_people);
        System.out.println(Arrays.toString(ans));
    }
    static class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int ans[]=new int[num_people];
            int now=0,i=1;
            while (candies>0)
            {
                now%=num_people;
                if(candies<i)
                {
                    ans[now]+=candies;
                    break;
                }
                else {
                    candies-=i;
                    ans[now]+=i;
                }
                i++;
                now++;
            }
            return ans;
        }
    }
}