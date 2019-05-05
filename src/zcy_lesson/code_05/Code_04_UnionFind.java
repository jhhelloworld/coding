package zcy_lesson.code_05;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集问题
 */
public class     Code_04_UnionFind {

	public static class Node {
		// whatever you like
	}

	public static class UnionFindSet {
		//key :child  value:father
		public HashMap<Node, Node> fatherMap;
		//某个节点所在的集合有多少个节点
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet() {

			fatherMap = new HashMap<Node, Node>();
			sizeMap = new HashMap<Node, Integer>();
		}

		/**
		 * 初始化
		 * @param nodes
		 */
		public void makeSets(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node node : nodes) {
				//开始每个node自己成为一个集合
				fatherMap.put(node, node);
				sizeMap.put(node, 1);
			}
		}

		/**
		 * 找代表节点，期间扁平化处理  递归处理
		 * @param node
		 * @return
		 */
		private Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = findHead(father);
			}
			fatherMap.put(node, father);
			return father;
		}
		
		public boolean isSameSet(Node a, Node b) {
			return findHead(a) == findHead(b);
		}

		public void union(Node a, Node b) {
			if (a == null || b == null) {
				return;
			}
			Node aHead = findHead(a);
			Node bHead = findHead(b);
			if (aHead != bHead) {
				int aSetSize= sizeMap.get(aHead);
				int bSetSize = sizeMap.get(bHead);
				if (aSetSize <= bSetSize) {
					fatherMap.put(aHead, bHead);
					sizeMap.put(bHead, aSetSize + bSetSize);
				} else {
					fatherMap.put(bHead, aHead);
					sizeMap.put(aHead, aSetSize + bSetSize);
				}
			}
		}

	}

	public static void main(String[] args) {

	}

}
