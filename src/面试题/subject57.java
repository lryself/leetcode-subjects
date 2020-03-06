package 面试题;

import java.util.ArrayList;
import java.util.Arrays;

public class subject57 {
    public static void main(String args[])
    {
        int all=15;
        Solution1 solution1=new Solution1();
        Solution2 solution2=new Solution2();
        int a[][]=solution1.findContinuousSequence(all);
        System.out.println("方法一：");
        for(int[] b:a)
        {
            for(int c:b)
            {
                System.out.print(c+" ");
            }
            System.out.println();
        }
        a=solution2.findContinuousSequence(all);
        System.out.println("方法二：");
        for(int[] b:a)
        {
            for(int c:b)
            {
                System.out.print(c+" ");
            }
            System.out.println();
        }
    }
    //方法一：
    static class Solution1 {
        public int[][] findContinuousSequence(int target) {
            ArrayList<int[]>intlist=new ArrayList<>();
            if(target%2!=0)
                intlist.add(new int[]{target/2,target/2+1});
            for(int i=3;target/i-i/2>=0;i++)
            {
                int num1[]=new int[i];
                if(i%2==0)
                {
                    num1[0]=target/i;
                    num1[1]=num1[0]+1;
                    if(target%(num1[0]+num1[1])!=0)
                        continue;
                }
                else
                {
                    if(target/i-i/2<=0)
                        continue;
                    if(target%i!=0)
                        continue;
                    num1[0]=target/i;
                }
                for(int j=1,w=1;j<i;j+=2,w++)
                {
                    num1[j]=num1[0]+w;
                    if((j+1)<num1.length)
                        num1[j+1]=num1[0]-w;
                }
                Arrays.sort(num1);
                intlist.add(num1);
            }
            int b[][]=new int[intlist.size()][];
            for (int i=0;i<intlist.size();i++) {
                b[i]=intlist.get(i);
            }
            qsort(b,0,b.length-1);
            return b;
        }
        void qsort(int[][] a, int left, int right) {
            if (left>right) return ;
            int left_pointer = left;
            int right_pointer = right;
            int key = a[left][0];
            while (left_pointer < right_pointer) {
                while (left_pointer < right_pointer && key < a[right_pointer][0]) {//从右边开始找小于key的值
                    right_pointer--;
                }
                int temp[]=a[left_pointer];
                a[left_pointer] = a[right_pointer];//如果找到交换，否则就是left_pointer = right_pointer
                a[right_pointer]=temp;
                while (left_pointer < right_pointer && key > a[left_pointer][0]) {
                    left_pointer++;
                }
                temp=a[right_pointer];
                a[right_pointer] = a[left_pointer];//如果找到交换，否则就是left_pointer = right_pointer
                a[left_pointer]=temp;
            }
            a[left_pointer][0] = key;//一趟排序完毕，key放入指针位置，这时left_pointer = righ_pointer，key左边都比它小，右边都比它大，然后各自递归左右两边
            qsort(a, left, left_pointer - 1);
            qsort(a, left_pointer + 1, right);
        }
    }
//方法二：
    static class Solution2 {
        public int[][] findContinuousSequence(int target) {
            int r=(int)Math.sqrt(2*target);
            int[][] nums=new int[r][];
            int s=0;
            for(int n=2;r>=n;n++)
            {
                int temp1=target-n*(n-1)/2;
                if(temp1%n==0)
                {
                    int num[]=new int[n];
                    int temp=temp1/n;
                    for(int i=0;i<n;i++)
                    {
                        num[i]=i+temp;
                    }
                    nums[s++]=num;
                }
            }
            int result[][]=new int[s][];
            for(int i=0;i<s;i++)
            {
                result[i]=nums[s-1-i];
            }
            return result;
        }
    }
}