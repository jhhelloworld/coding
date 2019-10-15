package zcy_lesson.code_advance_04;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * jh
 * 2019年09月04日  14：08
 */
public class Code_02_LRU_back<K,V>  {
    private int CAPACITY;
    private LinkedHashMap<K,V> map;

    public Code_02_LRU_back(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<K,V>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }


    public V get(K key){
        return map.getOrDefault(key,null);
    }
    public void set(K key, V value) {
        map.put(key, value);
    }
}