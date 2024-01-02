package com.ahmrh.test;

import java.util.HashMap;
import java.util.Map;

public class MapSum {
    Map<String,Integer> map;
    public MapSum() {
        map = new HashMap<>();
    }

    public void insert(String key, int val) {
        map.put(key, val);

    }

    public int sum(String prefix) {
        int sum = 0;

        for(Map.Entry<String, Integer> entry: map.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();

            if(key.startsWith(prefix)){
                sum += value;
            }

        }

        return sum;
    }
}
