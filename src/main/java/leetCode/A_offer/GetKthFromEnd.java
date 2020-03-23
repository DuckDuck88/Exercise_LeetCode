package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName GetKthFromEnd
 * @Description: 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。  来
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-29 16:53
 */
public class GetKthFromEnd {
    //双指针
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode curr=head;
        ListNode end=head;
        for (int i=0;i<k;i++){
            if (end==null)
                return null;
            end=end.next;
        }
        while (end!=null){
            curr=curr.next;
            end=end.next;
        }
        return curr;
    }



}
