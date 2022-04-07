package 算法和数据结构体系学习班.class14;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 并查集
1. 若有若干个样本a,b,c,d...假设类型是V
 2. 在并查集中一开始认为每个样本都在单独的集合里
 3. 用户可以在任何时候调用如下两个方法
  Boolean isSameSet(V x,V y): 查询样本x 和 样本 y是否属于一个集合
  void union（V x,V y）：把 x和y 所在集合的所有样本合并成一个集合
 4. isSameSet 和 union的方法代价越低越好 最好 O(1)

 以5个样本举例，a,b,c,d,e

 开始每个元素加一个指针，指向自己

 怎样表示集合： 集合是使用某个"代表点"来代表整个集合

 Boolean isSameSet： 如果这两个节点



 复杂度分析：
 如果findFather 方法调用的越频繁，当调用频率到达或者超过O(N)，平均代价为O(1)



 例题：
每一个学生示例有三个属性 微信号，B站id ,github账号， 任何两个学生有任意两个属性相同，即可认为是一个人，请问这些实例公有几个"独立的人"
 思路：
 每个学生都作为一个单独的集合，学生这个示例作为"代表点"，三个属性代表其他节点。
 依次进行初始化，如果初始化到某个节点B，发现某个属性已经指向某个代表节点A，则把B与A进行合并


 */
public class Code05_UnionFind {

	// V类型是按引用传递，如果是按值传递，比如两个3则没法区分
	public static class Node<V> {
		V value;

		public Node(V v) {
			value = v;
		}
	}

	public static class UnionFind<V> {
		public HashMap<V, Node<V>> nodes;
		//维护一个parent集合模拟父子指针关系
		public HashMap<Node<V>, Node<V>> parents;
		public HashMap<Node<V>, Integer> sizeMap;

		public UnionFind(List<V> values) {
			nodes = new HashMap<>();
			parents = new HashMap<>();
			sizeMap = new HashMap<>();
			for (V cur : values) {
				Node<V> node = new Node<>(cur);
				nodes.put(cur, node);
				parents.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		// 给你一个节点，请你往上到不能再往上，把代表返回
		//同时把整条支路做扁平化，假设原有路径是  a->b->c->d  变为 a->d,b->d,c->d ，至于 a 下面有什么，不做改动
		public Node<V> findFather(Node<V> cur) {
			Stack<Node<V>> path = new Stack<>();
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
			return findFather(nodes.get(a)) == findFather(nodes.get(b));
		}

		public void union(V a, V b) {
			Node<V> aHead = findFather(nodes.get(a));
			Node<V> bHead = findFather(nodes.get(b));
			if (aHead != bHead) {
				int aSetSize = sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				Node<V> big = aSetSize >= bSetSize ? aHead : bHead;
				Node<V> small = big == aHead ? bHead : aHead;
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
