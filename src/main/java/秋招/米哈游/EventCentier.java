package 秋招.米哈游;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description:
 * @Author: YaYa
 * @Create: 2020-08-21 20:18
 */

class Event {
    public int type = 0; //事件类型
    public int data = 0;  //时间消息
}

class GameSystemCallback {
    public void processEvent(Event event) {
    }
}

public class EventCentier {
    //任务列表，不同类型的任务对应不同的下标，每个下表对应相应的任务队列
    List<LinkedList<Event>> jobCenter = new ArrayList<>();
    //处理时间函数，key-type  value-处理函数
    Map<Integer, GameSystemCallback> map = new HashMap<>();

    //注册
    public void initRegisterCallback(GameSystemCallback gameSystemCallback, int type) {
        map.put(type, gameSystemCallback);
    }

    //处理
    public synchronized void notifyEventAndProcess(Event event) {
        if (event == null) return;
        int i = event.type;
        //创建对应任务的队列，
        if (jobCenter.get(i) == null) {
            jobCenter.add(i, new LinkedList());
        }
        //将任务加入队列
        jobCenter.get(i).offer(event);
        GameSystemCallback gameSystemCallback = map.get(i);
        gameSystemCallback.processEvent(jobCenter.get(i).poll());
    }

}
