package leetCode.top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Program: LeetCode
 * @Description: 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * @Author: YaYa
 * @Create: 2020-08-18 13:36
 */
public class 前K个高频元素 {
//        public int[] topKFrequent(int[] nums, int k) {
//            List<Integer> res = new ArrayList();
//            // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
//            HashMap<Integer,Integer> map = new HashMap();
//            for(int num : nums){
//                if (map.containsKey(num)) {
//                    map.put(num, map.get(num) + 1);
//                } else {
//                    map.put(num, 1);
//                }
//            }
//
//            //桶排序
//            //将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
//            List<Integer>[] list = new List[nums.length+1];
//            for(int key : map.keySet()){
//                // 获取出现的次数作为下标
//                int i = map.get(key);
//                if(list[i] == null){
//                    list[i] = new ArrayList();
//                }
//                list[i].add(key);
//            }
//
//            // 倒序遍历数组获取出现顺序从大到小的排列
//            for(int i = list.length - 1;i >= 0 && res.size() < k;i--){
//                if(list[i] == null) continue;
//                res.addAll(list[i]);
//            }
//            return Arrays.stream(res.toArray(new Integer[res.size()])).mapToInt(Integer::valueOf).toArray();
//        }

    public int[] topKFrequent(int[] nums, int k) {
        // 使用字典，统计每个元素出现的次数，元素为键，元素出现的次数为值
        HashMap<Integer, Integer> map = new HashMap();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (priorityQueue.size() < k)
                priorityQueue.add(key);
            else {
                priorityQueue.add(key);
                priorityQueue.remove();
            }
        }
        while (!priorityQueue.isEmpty()) {
            list.add(priorityQueue.remove());
        }
        return Arrays.stream(list.toArray(new Integer[list.size()])).mapToInt(Integer::valueOf).toArray();
    }

    @Test
    public void test() {
        Integer[] s = {5, 1, 4, 6, 2, 3, 9, 8, 7};
        List<Integer> list = Arrays.asList(s);
        Collections.sort(list, (o1, o2) -> o2 - o1);
        System.out.println(list);
    }
}
