package leetCode.queue;

import java.util.LinkedList;

/**
 * @Program: LeetCode
 * @ClassName CQueue
 * @Description: 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-02-27 23:50
 */
public class CQueue {
    private LinkedList<Integer> stack_push;
    private LinkedList<Integer> stack_pop;
    public CQueue() {
        stack_push=new LinkedList();
        stack_pop=new LinkedList();
    }
    //入栈不需要过多的判断
    public void appendTail(int value) {
        stack_push.push(value);
    }

    //需要考虑如果一次插入后进行取出操作，再进行插入的情况
    public int deleteHead() {
       //如果pop栈里有值，则直接取出
        if (stack_pop.size()>0) return stack_pop.pop();
        //如果pop 没值，将push栈的值移动到poll栈。
        if (stack_push.size()==0) return -1;
        while (stack_push.size()>0){
            stack_pop.push(stack_push.pop());
        }
        //将pop栈的取出并返回
        return stack_pop.pop();
    }
}
