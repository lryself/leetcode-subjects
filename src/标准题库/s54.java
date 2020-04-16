package 标准题库;

import java.util.*;

public class s54 {
    static class Solution {
        public int[][] merge(int[][] intervals)
        {
            if(intervals.length==0)//判断intervals是否为空
                return intervals;
            Arrays.sort(intervals, new MyComprator());//排序
            int[][] ans =new int[intervals.length][];//创建answer数组
            int w=0;
            ans[0]=intervals[0];//初始化
            for(int i=1;i<ans.length;i++)
            {//比较两种情况
                if(ans[w][1]>=intervals[i][0])
                    ans[w][1]=Math.max(ans[w][1],intervals[i][1]);
                else
                    ans[++w]=intervals[i];
            }
            return Arrays.copyOfRange(ans,0,w+1);//返回answer有值的部分
        }
        static class MyComprator implements Comparator //自定义比较器
        {
            public int compare(Object arg0, Object arg1) {
                if(arg0==null&&arg1==null)
                    return 0;
                if(arg0==null)
                    return -1;
                if(arg1==null)
                    return 1;
                int[] t1=(int[])arg0;
                int[] t2=(int[])arg1;
                if(t1[0]>t2[0])
                    return 1;
                else if(t1[0]<t2[0])
                    return -1;
                else
                    return 0;
            }
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
}
