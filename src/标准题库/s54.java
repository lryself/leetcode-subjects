package 标准题库;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class s54 {
    static class Solution {
        public int[][] merge(int[][] intervals) {
            Queue<int[]> dq=new PriorityQueue<>(cmp);
            for(int[] i:intervals)  dq.offer(i);
            Queue<int[]> res=new LinkedList<>();
            while(!dq.isEmpty())
            {
                int[] r1=dq.poll();
                if(dq.isEmpty())
                    res.offer(r1);
                else if(r1[1]>=dq.peek()[0])
                {
                    dq.offer(new int[]{r1[0],Math.max(r1[1],dq.poll()[1])});
                }
                else
                {
                    res.offer(r1);
                }
            }
            int n=res.size();
            int[][] ans =new int[n][];
            for(int i=0;i<n;i++)
            {
                ans[i]=res.poll();
            }
            return ans;
        }
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
    static Comparator<int[]> cmp = new Comparator<int[]>() {
        public int compare(int[] e1, int[] e2) {
            return e1[0] - e2[0];
        }
    };
}
