package leetCode.A_offer;

/**
 * @Program: LeetCode
 * @ClassName MaxQueue
 * @Description: 请定义一个队列并实现函数 max_value 得到队列里的最大值，
 * 要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 * @Version 1.0
 * @Author: Mr.Liu
 * @Create: 2020-03-07 01:14
 */
public class MaxQueue {

    int[] myQueue;

    //头指针
    int start;
    //尾指针
    int end;
    //队列长度
    int size = 10000;
    //辅助队列
    int[] maxQueue;
    //辅助队列头指针
    int maxStart;
    //辅助队列尾指针
    int maxEnd;

    //初始化队列，将头尾指针放在一起而且值为-1。
    public MaxQueue() {
        myQueue = new int[size];
        start = 0;
        end = 0;
        maxQueue = new int[size];
        maxStart = 0;
        maxEnd = 0;
    }

    //求最大值
    public int max_value() {
        if (start == end)
            return -1;
        return maxQueue[maxStart];
    }

    //队尾添加
    public void push_back(int value) {
        myQueue[end] = value;
        end++;
        while (maxStart != maxEnd && maxQueue[maxEnd - 1] < value) {
            maxEnd--;
        }
        maxQueue[maxEnd++] = value;
    }

    //队头拿出
    public int pop_front() {
        if (start == end)
            return -1;
        if (myQueue[start] == maxQueue[maxStart])
            maxStart++;
        int head = start;
        start++;
        return myQueue[head];
    }
}
