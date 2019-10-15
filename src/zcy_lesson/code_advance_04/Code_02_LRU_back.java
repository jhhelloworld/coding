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
        // 0.75为扩容因子，按照LeetCode题意，值应该为1
        //accessOrder:true 按照更新顺序排序，false ：按照插入顺序
        map = new LinkedHashMap<K,V>(capacity,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                //当大于容量的时候删除最老元素
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