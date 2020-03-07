package 面试题;

import java.io.File;
import java.util.*;

public class subject59 {
    public static void main(String[] args) {
        MaxQueue maxQueue=new MaxQueue();
        Scanner sc=new Scanner(System.in);
        try
        {
            sc=new Scanner(new File("F:/编程/java/leetcode/src/面试题/input.txt"));
        }
        catch (Exception e){
            e.printStackTrace();
        }
        while(true)
        {
            int str=sc.nextInt();
            if(str==1)
            {
                System.out.println(maxQueue.max_value());
            }
            else if(str==2)
            {
                System.out.println(maxQueue.pop_front());
            }
            else if(str==3)
            {
                maxQueue.push_back(sc.nextInt());
            }
        }
    }
    static class MaxQueue {
        Queue<Integer>queue=new LinkedList<>();
        ArrayList<Integer>maxlist=new ArrayList<>();
        public MaxQueue() {

        }

        public int max_value() {
            if(queue.size()==0)
                return -1;
            return maxlist.get(0);
        }

        public void push_back(int value) {
            queue.offer(value);
            if(maxlist.size()==0)
                maxlist.add(value);
            else {
                for(int i=0;i<maxlist.size();i++)
                {
                    if(maxlist.get(i)<value)
                    {
                        maxlist.add(i,value);
                        return;
                    }
                }
                maxlist.add(value);
            }
        }
        public int pop_front() {
            if(queue.size()==0)
                return -1;
            int va=queue.poll();
            maxlist.remove(maxlist.indexOf(va));
            return va;
        }
    }
}