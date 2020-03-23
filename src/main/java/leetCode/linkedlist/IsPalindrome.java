package leetCode.linkedlist;

/**
 * @Program: LeetCode
 * @ClassName IsPalindrome
 * @Description: 回文链表
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-18 23:36
 */
public class IsPalindrome {
///*
//  方法一：递归法，通过递归访问最后一个节点，然后回退开始和头结点以后依次比较
//  if (!checkByRecursion(current.next)) return false; 本方法用来递归至最后一个节点。
//  判断体内的return永远不会触发执行
//  if (current.val!=frontNote.val) return false;这个方法负责将从头结点和此时递归至的结点值比较。
// */
//    private ListNode frontNote;
//
//    public boolean checkByRecursion(ListNode current){
//        if (current!=null){
//            if (!checkByRecursion(current.next)) return false;
//            if (current.val!=frontNote.val) return false;
//            frontNote=frontNote.next;
//        }
//        return true;
//    }
//    public boolean isPalindrome(ListNode head) {
//        frontNote=head;
//        return checkByRecursion(frontNote);
//    }

//
////     快慢指针法
////    两次遍历，第一次寻找重点、反转前半部分链表；第二次，从起点和中点开始比较值
////     利用快慢指针寻找重点。同时在便利的过程中，反转链表;
//
//    public boolean isPalindrome(ListNode head) {
//        //如果链表为空或者长度为1，返回true
//        if (head == null || head.next == null) {
//            return true;
//        } else if (head.next.next == null) {//长度为2时不会触发后续代码，需要单独判断，
//            if (head.next.val != head.val)
//                return false;
//        }
//        //快慢指针遍历
//        ListNode slow = head;
//        ListNode fast = head;
//        ListNode pre = null;
//        while (fast.next != null && fast.next.next != null) {
//            //快指针移动
//            fast = fast.next.next;
//            //慢指针先反转当前结点和下一结点的方向再移动
//            ListNode cur = slow.next; //备份slow的下一个结点，防止改变方向后链表丢失
//            slow.next = pre;//将slow的指向指为pre；
//            pre = slow;//pre后移
//            slow = cur;//slow后移
//        }
//
//        //此时前半段已经翻转
//        // 如果链表长度为偶数，后半段比前半段多两个个结点，先判断后半段的前两个结点是否相等，在半段两段其余是否相等。
//        //如果链表长度为奇数，后半段比前半段多一个结点，比值时忽略后半段的第一个节点。
//        //如何判断奇数偶数？通过快慢指针中的快指针判断,当为奇数，fast.next=null；当为偶数，fast.next.next=null
//        if (fast.next == null) {
//            //奇数时，忽略前半段的第一个结点
//            slow = slow.next;
//        }else if (fast.next.next==null){
//            //偶数时，比较后半段的前两个结点是否相等
//            if (slow.next.val!=slow.val)
//                return false;
//            slow=slow.next.next;
//        }
//        while (pre != null && slow != null) {
//            if (pre.val != slow.val) {
//                return false;
//            }
//            pre = pre.next;
//            slow = slow.next;
//        }
//        return true;
//    }


    //优化后的快慢指针
//    两次遍历，第一次寻找重点、反转前半部分链表；第二次，从起点和中点开始比较值
//     利用快慢指针寻找重点。同时在便利的过程中，反转链表;

    public boolean isPalindrome(ListNode head) {
        //如果链表为空或者长度为1，返回true
        if (head == null || head.next == null) {
            return true;
        }
        //快慢指针遍历
        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;
        while (fast.next != null && fast != null) {
            //快指针移动
            fast = fast.next.next;
            //备份slow的下一个结点，防止改变方向后链表丢失
            ListNode cur = slow.next;
            //慢指针先反转当前结点
            slow.next = pre;
            //pre和slow同时向后移
            pre = slow;
            slow = cur;
        }

        //此时前半段已经翻转
        //如果链表长度为偶数，前后长度相等
        //如果链表长度为奇数，后半段比前半段多一个结点，比值时忽略后半段的第一个节点。
        //如何判断奇数偶数？通过快慢指针中的快指针判断,当为奇数，fast.next==null；当为偶数，fast==null
        if (fast != null) {
            //奇数时，忽略前半段的第一个结点
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
