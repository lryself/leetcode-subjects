package 标准题库;

public class s445 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int a[]={7,2,4,3};
        int b[]={5,6,4};
        ListNode l1=creat(a);
        ListNode l2=creat(b);
        ListNode l3=solution.addTwoNumbers(l1,l2);
        while(l3!=null)
        {
            System.out.print(l3.val+" ");
        }
    }
    static ListNode creat(int[] x)
    {
        ListNode q=new ListNode(0);
        ListNode p=q.next;
        for(int i:x)
        {
            ListNode l=new ListNode(i);
            p=l;
            p=p.next;
        }
        return q.next;
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int i=0;
            ListNode l3=null;
            try
            {
                l3=new ListNode(l1.val+l2.val);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            ListNode l4;
            if(l3.val>=10)
            {
                l4=new ListNode(1);
            }
            else
            {
                l4=new ListNode(0);
            }
            ListNode p1=l1,p2=l2,p3=l3,p4=l4;
            while(true)
            {
                if(p1==null&&p2==null)
                {
                    break;
                }
                else if(p1==null)
                {
                    p2=p2.next;
                    p3.next=new ListNode(p2.val);
                }
                else if(p2==null)
                {
                    p1=p1.next;
                    p3.next=new ListNode(p1.val);
                }
                else
                {
                    p1=p1.next;
                    p2=p2.next;
                    p3.next=new ListNode(p1.val+p2.val);
                }
                p3=p3.next;
                if(p3.val>=10)
                {
                    p3.val=p3.val-10;
                    p4.next=new ListNode(1);
                }
                else
                {
                    p4.next=new ListNode(0);
                }
                p4=p4.next;
            }
            p3=l3;
            p4=l4.next;
            while(p4!=null)
            {
                p4.val+=p3.val;
                p4=p4.next;
                p3=p3.next;
            }
            if(l4.val==0)
                return l4.next;
            return l4;
        }
    }
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}


