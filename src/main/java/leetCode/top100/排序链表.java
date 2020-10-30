package leetCode.top100;

/**
 * @Program: LeetCode
 * @Description: 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序
 * @Author: YaYa
 * @Create: 2020-07-09 23:20
 */
public class 排序链表 {
//    public ListNode sortList(ListNode head) {
//        if (head == null || head.next == null)
//            return head;
//        ListNode fast = head.next;
//        ListNode slow = head;
//        while (fast != null && fast.next != null) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//        ListNode tempHead = slow.next;
//        slow.next = null;
//        ListNode h1 = sortList(head);
//        ListNode h2 = sortList(tempHead);
//        ListNode H = new ListNode(0);
//        ListNode temp = H;
//        while (h1 != null && h2 != null) {
//            if (h1.val > h2.val) {
//                temp.next = h2;
//                h2 = h2.next;
//            } else {
//                temp.next = h1;
//                h1 = h1.next;
//            }
//            temp = temp.next;
//        }
//        temp.next = h1 == null ? h2 : h1;
//        return H.next;
//    }

    /**
     * 堆排序
     */
//    public ListNode sortList(ListNode head) {
////        PriorityQueue<ListNode> maxHeap=new PriorityQueue<>(((o1, o2) -> {
////            return o1.val-o2.val;
////        }));
//        PriorityQueue<ListNode> maxHeap=new PriorityQueue<>(new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o2.val-o1.val;
//            }
//        });
//
//        while (head!=null){
//            maxHeap.add(head);
//            head=head.next;
//        }
//        ListNode newHead=new ListNode(0);
//        ListNode curr= newHead;
//        while (!maxHeap.isEmpty()){
//            curr.next=maxHeap.poll();
//            curr=curr.next;
//            curr.next=null;
//        }
//        return newHead.next;
//    }


    /**
     * 归并排序3
     */
    public ListNode sortList(ListNode head) {
        if (head == null) {
            return head;
        }
        //双指针寻找中点
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode midNode = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(midNode);
        //合并
        ListNode newHead = new ListNode(0);
        ListNode curr = newHead;
        while (left != null || right != null) {
            if (left == null) {
                curr.next = right;
                right = right.next;
            } else if (right == null) {
                curr.next = left;
                left = left.next;
            } else {
                if (left.val >= right.val) {
                    curr.next = right;
                    right = right.next;
                } else {
                    curr.next = left;
                    left = left.next;
                }
            }
            curr = curr.next;
        }
        return newHead.next;
    }
}
