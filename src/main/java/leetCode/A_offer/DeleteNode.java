package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName DeleteNode
 * @Description: 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-06 18:25
 */
public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode curr=null;
        ListNode temp=head;
        curr=temp.next;
        if (head.val==val){
            return curr;
        }
        while (curr!=null){
            if (curr.val==val){
                temp.next=curr.next;
            }
            curr=curr.next;
            temp=temp.next;
        }
        return head;
    }
}
