package a_test.history;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * jh
 * 2019年09月15日  11：29
 * 前K个高频元素
 * TODO 优先队列  左程云
 */
public class PracticeAtHome3 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        int len = nums.length;
        //定义桶，各个数字出现的频率范围为 0——len,所以长度为len+1
        List<Integer>[] buck = new List[len+1];
        //定义map，key：num ，value：频率
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num:nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        //生成桶
        for(int key:frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            if(buck[frequency] == null){
                buck[frequency] = new ArrayList<>();
            }
            buck[frequency].add(key);
        }

        List<Integer> result = new ArrayList<>();
        for(int i = buck.length-1;i>=0 && result.size()<k; i--){
            if(buck[i] == null){
                continue;
            }
            result.addAll(buck[i]);
        }
        return result.subList(0,k);


    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> result = list.subList(1,2);
        System.out.println();
    }
}






























































