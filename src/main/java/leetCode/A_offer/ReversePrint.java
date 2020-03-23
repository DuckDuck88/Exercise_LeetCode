package leetCode.A_offer;

import java.util.Stack;

/**
 * @Program: LeetCode
 * @ClassName ReversePrint
 * @Description: 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 23:58
 */
public class ReversePrint {
//    //递归
//    int [] result;
//    int length=0;
//    int index=0;
//    int [] temp={};
//    public int[] reversePrint(ListNode head) {
//        helper(head);
//        if (head==null)
//            result=new int[0];
//        return result;
//    }
//
//    public ListNode helper(ListNode head){
//        if (head==null)
//            return null;
//        length++;
//        if(head.next==null){
//            result=new int[length];
//            result[index++]=head.val;
//            return head;
//        }
//        reversePrint(head.next);
//
//        result[index++]=head.val;
//        return head;
//    }

    public int[] reversePrint(ListNode head) {
        if (head==null){
            return new int[0];
        }
        Stack<ListNode> stack=new Stack<>();
        while (head!=null){
            stack.push(head);
            head=head.next;
        }
        int[] result=new int[stack.size()];
        int index=0;
        while (!stack.empty()){
            result[index++]=stack.pop().val;
        }
        return result;
    }
}
