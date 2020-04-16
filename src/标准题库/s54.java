package 标准题库;

import java.util.*;

public class s54 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            Queue<int[]> dq=new PriorityQueue<>(cmp);
            for(int[] i:intervals)  dq.offer(i);
            int[][] ans =new int[intervals.length][];
            int w=0;
            while(!dq.isEmpty())
            {
                int[] r1=dq.poll();
                if(dq.isEmpty())
                    ans[w++]=r1;
                else if(r1[1]>=dq.peek()[0])
                {
                    dq.offer(new int[]{r1[0],Math.max(r1[1],dq.poll()[1])});
                }
                else
                {
                    ans[w++]=r1;
                }
            }
            return Arrays.copyOfRange(ans,0,w);
        }
        Comparator<int[]> cmp = new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                return e1[0] - e2[0];
            }
        };
    }

    public static void main(String[] args) {
        Solution solution=new Solution();
        int[][] qus=new int[][]{{1, 3},{2, 6},{8, 10},{15, 18}};
        int[][] ans=solution.merge(qus);
        for(int i=0;i<ans.length;i++)
        {
            for(int j=0;j<ans[i].length;j++)
            {
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
