package leetCode.top100;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Program: LeetCode
 * @Description: 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；
 * 如果关键字不存在，则插入该组「关键字/值」。
 * 当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * @Author: YaYa
 * @Create: 2020-07-10 16:04
 */
@SuppressWarnings("ALL")
public class LRU缓存机制 {
    //map+双向队列
//    /**
//     * 存放key，每次使用后将key移动到末尾
//     */
//    LinkedList<Integer> queue;
//
//    /**
//     * 存放key+value
//     */
//    Map<Integer, Integer> map;
//    private final int CAPACITY;
//
//    public LRU缓存机制(int capacity) {
//        this.CAPACITY = capacity;
//        queue = new LinkedList<>();
//        map = new HashMap();
//    }
//
//    /**
//     * 在map中查找，如果不包含则返回-1.
//     * 如果包含，返回value，并将queue中的key移动到末尾
//     * @param key
//     * @return
//     */
//    public int get(int key) {
//        if (map.get(key)==null){
//            return -1;
//        }
//        int value = map.get(key);
//        moveToEnd(key);
//        return value;
//    }
//
//    /**
//     * 判断是否包含，包含则更新value，并将key移动到queue的末尾。
//     * 不包含则判断map大小，小于容量则加入map并放入queue末尾
//     * 大于容量则将queue第一个元素弹出，并将此元素从map中删除，将新元素放入queue和map
//     *
//     * @param key
//     * @param value
//     */
//    public void put(int key, int value) {
//        if(map.containsKey(key)){
//            map.put(key, value);
//            moveToEnd(key);
//        }else {
//            if (map.size()<CAPACITY){
//                map.put(key, value);
//                queue.addLast(key);
//            }else {
//                int temp=queue.removeFirst();
//                map.remove(temp);
//                map.put(key, value);
//                queue.addLast(key);
//            }
//        }
//    }
//
//    /**
//     * 将key移动到末尾
//     * @param key
//     */
//    private void moveToEnd(int key) {
//        if(queue.size()==0) {
//            return;
//        }
//        queue.remove(Integer.valueOf(key));
//        queue.addLast(key);
//    }

    Map<Integer, Integer> LRUcache;

    /**
     * 使用java自带LinkedHashMap
     */
    public LRU缓存机制(int capacity) {
        LRUcache = new LinkedHashMap(capacity, 1, true);
    }

    public int get(int key) {
        return LRUcache.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        if (LRUcache.size() < 5) {
            LRUcache.put(key, value);
        } else {
            LRUcache.remove(key);
        }
    }
}
