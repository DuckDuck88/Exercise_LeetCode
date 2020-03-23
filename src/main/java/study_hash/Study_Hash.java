package study_hash;

import java.util.HashMap;
import java.util.Map;

public class Study_Hash {
    public static void main(String[] args) {
        Map test =new HashMap();
        test.put("刘建敏", "男生");
        test.put("俞文jie", "女生");
        System.out.println(test.get("刘建敏"));
        System.out.println(test.get("俞文杰"));
    }
}
