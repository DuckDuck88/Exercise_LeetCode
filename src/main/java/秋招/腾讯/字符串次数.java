package 秋招.腾讯;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Program: LeetCode
 * @Description:
 * @Author: YaYa
 * @Create: 2020-09-06 20:42
 */
public class 字符串次数 {
    //    PriorityQueue<String>
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        HashMap<String, Integer> map = new HashMap<>();
        sc.nextLine();
        for (int i = 0; i < N; i++) {
            String s = new String(sc.nextLine());
            map.put(s.toString(), map.getOrDefault(s.toString(), 0) + 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> priorityQueue1 = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() - o2.getValue() == 0)
                    return o1.getKey().compareTo(o2.getKey());
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue2 = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() - o2.getValue() == 0)
                    return o1.getKey().compareTo(o2.getKey());
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            priorityQueue1.add(entry);
            priorityQueue2.add(entry);
        }
        for (int i = 0; i < K; i++) {
            HashMap.Entry m = priorityQueue1.remove();
            System.out.println(m.getKey() + " " + m.getValue());
        }
        for (int i = 0; i < K; i++) {
            HashMap.Entry m = priorityQueue2.remove();
            if (i == K - 1)
                System.out.print(m.getKey() + " " + m.getValue());
            else
                System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
