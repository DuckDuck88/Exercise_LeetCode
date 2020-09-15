package 剑指offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null
 * @Date 2020/9/15 10:28
 * @Classname 复杂链表的复制
 * @Created by 是哪的鸭
 */
public class 复杂链表的复制 {

    /*
     * @description:使用map存储新老节点，使其一一对应
     * @param: 头结点
     * @return:
     * @date: 2020/9/15 10:37
     * @created by 是哪的鸭
     */
    public Note copyRandomList(Note head) {
        if (head == null) return null;
        Map<Note, Note> map = new HashMap<>();
        Note curr = head;
        while (curr != null) {
            map.put(curr, new Note(curr.val));
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}

class Node {
    int val;
    Note next;
    Note random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}