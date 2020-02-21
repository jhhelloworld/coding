package zcy_book_v2.chapter_9_others;

import java.util.HashMap;

/**
 * 哈希表常见的三个操作是put、get和containsKey，而且这三个操作的时间复杂度为O（1）。
 * 现在想加一个setAll功能，就是把所有记录的value都设成统一的值。
 * 请设计并实现这种有setAll功能的哈希表，并且put、get、containsKey和setAll四个操作的时间复杂度都为O（1）。
 */
public class Problem_09_SetAllHashMap {
    public static class MyValue<V> {
        private V value;
        private long time;

        public MyValue(V value, long time) {
            this.value = value;
            this.time = time;
        }

        public V getValue() {
            return value;
        }

        public long getTime() {
            return time;
        }
    }


    public static class MyHashMap<K, V> {
        private HashMap<K, MyValue<V>> baseMap;
        private long time;
        private MyValue<V> setAll;

        public MyHashMap() {
            this.baseMap = new HashMap<>();
            this.setAll = new MyValue<>(null, -1);
            this.time = 0;
        }

        public boolean containsKey(K key) {
            return this.baseMap.containsKey(key);
        }


        public void put(K key, V value) {
            //注意 time+1
            this.baseMap.put(key, new MyValue<>(value, this.time++));
        }

        public void setAll(V value) {
            this.setAll = new MyValue<>(value, this.time++);
        }

        //如果存在key ，判断key对应的time 和 setAll 对应的time谁大，谁大返回谁的
        public V get(K key) {
            if (this.containsKey(key)) {
                return this.baseMap.get(key).getTime() > this.setAll.getTime() ? this.baseMap.get(key).getValue() : this.setAll.getValue();
            } else {
                return null;
            }
        }

    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> test = new MyHashMap<String, Integer>();
        test.put("Tom", 1);
        test.put("James", 2);
        System.out.println(test.containsKey("Tom"));
        System.out.println(test.get("Tom"));
        System.out.println(test.containsKey("James"));
        System.out.println(test.get("James"));
        test.setAll(3);
        test.put("Rose", 4);
        System.out.println(test.get("Tom"));
        System.out.println(test.get("James"));
        System.out.println(test.get("Rose"));
        test.setAll(5);
        System.out.println(test.get("Tom"));
        System.out.println(test.get("James"));
        System.out.println(test.get("Rose"));

    }

}
