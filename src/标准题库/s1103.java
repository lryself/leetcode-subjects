package 标准题库;

import java.util.Arrays;

public class s1103 {
    public static void main(String args[])
    {
        Solution solution=new Solution();
        int candies = 90, num_people = 4;
        int ans[]=solution.distributeCandies(candies,num_people);
        System.out.println(Arrays.toString(ans));
    }
    static class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            int ans[]=new int[num_people];
            int turns=(int)(Math.sqrt(candies*2+1/4)-1/2);
            int c=candies-(1+turns)*turns/2;
            if(c<0)
            {
                turns--;
                c=candies-(1+turns)*turns/2;
            }
            int a=turns/num_people;
            int b=turns%num_people;
            if(a>0)
            {
                for(int i=0;i<num_people;i++)
                {
                    ans[i]+=((i+1)*2+(a-1)*num_people)*a/2;
                }
            }
            for(int i=0;i<b;i++)
            {
                ans[i]+=i+1+a*num_people;
            }
            ans[b]+=c;
            return ans;
        }
    }
}