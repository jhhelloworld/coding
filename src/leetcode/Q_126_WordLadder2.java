package leetcode;

import org.w3c.dom.ls.LSInput;

import java.util.*;

/**
 * jh
 * 2019年09月02日  15：29
 *
 * 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同
 */
public class Q_126_WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        //字典中没有endWord直接返回
        if (!dict.contains(endWord)) {
            return result;
        }
        //neighbor集合
        Map<String, List<String>> neighborsMap = new HashMap<>();
        //与初始值距离集合
        Map<String, Integer> distancesMap = new HashMap<>();
        bfs(beginWord,endWord,dict,neighborsMap,distancesMap);
        dfs(beginWord,endWord,neighborsMap,distancesMap,new ArrayList<>(),result);
        return result;
    }

    //bfs: 找到每个节点距离 beginWord的距离
    //假设某一层一个节点的下一层为end节点，这时做个标记，已找到，但是需要把这一层遍历完再结束，因为题目要求输出所有最短节点
    //这样dfs的时候，假设从beginWord到endWord需要5层，则每条链路要么长度小于5（无法到达），要么长度等于5（更长的链路被及时终止）
    //dfs步骤就是要找到长度等于5，并且最后元素为endWord的链路
    private void bfs(String beginWord, String endWord, Set<String> dict, Map<String, List<String>> neighborsMap, Map<String, Integer> distancesMap) {
        for(String str: dict){
            neighborsMap.put(str,new ArrayList<>());
        }
        neighborsMap.put(beginWord,new ArrayList<>());
        //宽度优先队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distancesMap.put(beginWord,0);
        while (!queue.isEmpty()){
            int count = queue.size();
            boolean found = false;
            for(int i = 0;i<count;i++){
                String curNode = queue.poll();
                int curDistance = distancesMap.get(curNode);
                List<String> neighbors = getNeighbors(curNode,dict);
                neighborsMap.get(curNode).addAll(neighbors);
                for(String neighbor:neighbors){
                    if(!distancesMap.containsKey(neighbor)){
                        distancesMap.put(neighbor,curDistance+1);
                        if(neighbor.equals(endWord)){
                            found = true;
                        }else {
                            queue.offer(neighbor);
                        }
                    }
                }
            }
            if(found){
                break;
            }
        }

    }


    //获取邻居节点（不一定是下一层，可能是上一层）
    public List<String> getNeighbors(String word,Set<String> dict){
        char[] charArray = word.toCharArray();
        List<String> result = new ArrayList<>();
        for(char c = 'a';c<='z';c++){
            for(int i = 0;i<charArray.length;i++){
                if(charArray[i] == c){
                    continue;
                }
                char oldChar = charArray[i];
                charArray[i] = c;
                if(dict.contains(String.valueOf(charArray))){
                    result.add(String.valueOf(charArray));
                }
                charArray[i] = oldChar;
            }
        }
        return result;
    }


    //获取最短链路
    public void dfs(String curWorld, String endWord,  Map<String, List<String>> neighborsMap, Map<String, Integer> distancesMap,List<String> solution,List<List<String>> result){
        solution.add(curWorld);
        if(endWord.equals(curWorld)){
            result.add(new ArrayList<>(solution));
        }else {
            for(String next :neighborsMap.get(curWorld)){
                //为什么要加这个判断，邻接点链表是相互的，肯定有distance= curDistance-1，这种节点需要忽略
                if(distancesMap.get(next).equals(distancesMap.get(curWorld)+1)){
                    dfs(next,endWord,neighborsMap,distancesMap,solution,result);
                }
            }
        }
        solution.remove(solution.size()-1);
    }































}





































































