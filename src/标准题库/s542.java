package 标准题库;

import java.lang.reflect.Array;
import java.util.LinkedList;
import java.util.Queue;

public class s542 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int matrix[][]=new int[][]{{1,0,1,1,0,0,1,0,0,1},{0,1,1,0,1,0,1,0,1,1},{0,0,1,0,1,0,0,1,0,0},{1,0,1,0,1,1,1,1,1,1},{0,1,0,1,1,0,0,0,0,1},{0,0,1,0,1,1,1,0,1,0},{0,1,0,1,0,1,0,0,1,1},{1,0,0,0,1,1,1,1,0,1},{1,1,1,1,1,1,1,0,1,0},{1,1,1,1,0,1,0,0,1,1}};
        int res[][]=solution.updateMatrix(matrix);
        for(int i=0;i<res.length;i++)
        {
            for(int j=0;j<res[0].length;j++)
            {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
    static class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int n1=matrix.length;
            int n2=matrix[0].length;
            int answer[][]=new int[n1][n2];
            Queue<int[]>dq=new LinkedList<>();
            for(int i=0;i<n1;i++)//初始化answer
            {
                for(int j=0;j<n2;j++)
                {
                    if(matrix[i][j]==0)
                    {
                        answer[i][j]=0;
                    }
                    else {
                        if(i+1<n1&&matrix[i+1][j]==0)
                        {
                            answer[i][j]=1;
                        }
                        else if(j+1<n2&&matrix[i][j+1]==0)
                        {
                            answer[i][j]=1;
                        }
                        else if(i-1>=0&&matrix[i-1][j]==0)
                        {
                            answer[i][j]=1;
                        }
                        else if(j-1>=0&&matrix[i][j-1]==0)
                        {
                            answer[i][j]=1;
                        }else {
                            dq.offer(new int[]{i, j, 1});
                        }
                    }
                }
            }
            while (!dq.isEmpty())
            {
                int path[]=dq.poll();
                int i=path[0];
                int j=path[1];
                int level=path[2];
                if(i+1<n1&&answer[i+1][j]==level)
                {
                    answer[i][j]=level+1;
                }
                else if(j+1<n2&&answer[i][j+1]==level)
                {
                    answer[i][j]=level+1;
                }
                else if(i-1>=0&&answer[i-1][j]==level)
                {
                    answer[i][j]=level+1;
                }
                else if(j-1>=0&&answer[i][j-1]==level)
                {
                    answer[i][j]=level+1;
                }
                else {
                    dq.offer(new int[]{i,j,level+1});
                }
            }
            return answer;
        }
    }
}