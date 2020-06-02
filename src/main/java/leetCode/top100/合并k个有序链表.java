package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 合并 k 个排序链表，返回合并后的排序链表
 * @Author: YaYa
 * @Create: 2020-05-08 20:04
 */
public class 合并k个有序链表 {
    //方法一：使用指针分别指向k个链表
//    public ListNode mergeKLists(ListNode[] lists) {
//        int len=lists.length;
//        if (len==0) return new ListNode();
//        if (len==1) return lists[0];
//        ListNode head=new ListNode();
//        ListNode curr=head;
//        while (true){
//            ListNode min=null;
//            int minPointer=-1;
//            for (int i = 0; i < len; i++) {
//                if(lists[i]==null)
//                    continue;
//                if (min==null||lists[i].val<min.val){
//                    min=lists[i];
//                    minPointer=i;
//                }
//            }
//            if (minPointer == -1) {
//                break;
//            }
//            curr.next=min;
//            curr=min;
//            lists[minPointer]=lists[minPointer].next;
//        }
//        return head.next;
//    }

    //方法二：使用小根堆寻找最小的节点
//    public ListNode mergeKLists(ListNode[] lists) {
//        int len = lists.length;
//        if (len == 0) return null;
//        if (len == 1) return lists[0];
//        ListNode head = new ListNode();
//        ListNode curr = head;
//        Queue<ListNode> queue = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
//        for (ListNode node : lists) {
//            if (node != null) {
//                queue.offer(node);
//            }
//        }
//        while (!queue.isEmpty()) {
//            ListNode node = queue.poll();
//            if (node.next != null)
//                queue.offer(node.next);
//            curr.next = node;
//            curr = curr.next;
//        }
//        return head.next;
//    }

    //方法三 两两合并
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length==0) return null;
//        if (lists.length==1) return lists[0];
//        ListNode head=new ListNode();
//        for (ListNode node : lists) {
//            helper(head, node);
//        }
//        return head;
//    }
//
//    public ListNode helper(ListNode n1,ListNode n2){
//        if (n1==null) return n2;
//        if (n2==null) return n1;
//        if (n1.val>n2.val){
//            n2.next=helper(n1, n2.next);
//            return n2;
//        }
//            n1.next=helper(n1.next, n2);
//            return n1;
//    }

    //方法四 分治
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length==0) return null;
        if (lists.length==1) return lists[0];
        return helper(lists, 0,lists.length-1);
    }

    public ListNode helper(ListNode[] lists,int n1,int n2){
        if (n1==n2) return lists[n1];
        int mid=(n1+n2)/2;
//        helper(lists, n1,mid);
//        helper(lists, mid+1,n2);
        return helper(helper(lists, n1,mid), helper(lists, mid+1,n2));
    }

    public ListNode helper(ListNode n1,ListNode n2){
        if (n1==null) return n2;
        if (n2==null) return n1;
        if (n1.val>n2.val){
            n2.next=helper(n1, n2.next);
            return n2;
        }
        n1.next=helper(n1.next, n2);
        return n1;
    }
}
