package leetCode.top100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Program: LeetCode
 * @Description: 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 * @Author: YaYa
 * @Create: 2020-07-12 16:55
 */
public class 最小栈 {

    List<Integer> list;
    int length;

    public 最小栈() {
        list = new ArrayList<>();
        length = list.size();
    }

    public void push(int x) {
        list.add(x);
        length++;
    }

    public void pop() {
        list.remove(length--);
        length--;
    }

    public int top() {
        return list.get(length - 1);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for (Integer x : list) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }
}
