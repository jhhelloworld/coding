package 算法和数据结构体系学习班.class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

//感觉Node类型没有必要
public class Code05_UnionFind_2 {

    public static class UnionFind<V> {
        //维护一个parent集合模拟父子指针关系
        public HashMap<V, V> parents;
        public HashMap<V, Integer> sizeMap;

        public UnionFind(List<V> values) {
            parents = new HashMap<>();
            sizeMap = new HashMap<>();
            for (V cur : values) {
                parents.put(cur, cur);
                sizeMap.put(cur, 1);
            }
        }

        // 给你一个节点，请你往上到不能再往上，把代表返回
        //同时把整条支路做扁平化，假设原有路径是  a->b->c->d  变为 a->d,b->d,c->d ，至于 a 下面有什么，不做改动
        public V findFather(V cur) {
            Stack<V> path = new Stack<>();
            while (cur != parents.get(cur)) {
                path.push(cur);
                cur = parents.get(cur);
            }
            while (!path.isEmpty()) {
                parents.put(path.pop(), cur);
            }
            return cur;
        }

        public boolean isSameSet(V a, V b) {
            return findFather(a) == findFather(b);
        }

        public void union(V a, V b) {
            V aHead = findFather(a);
            V bHead = findFather(b);
            if (aHead != bHead) {
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                V big = aSetSize >= bSetSize ? aHead : bHead;
                V small = big == aHead ? bHead : aHead;
                parents.put(small, big);
                sizeMap.put(big, aSetSize + bSetSize);
                sizeMap.remove(small);
            }
        }
        public int sets() {
            return sizeMap.size();
        }
    }


}
