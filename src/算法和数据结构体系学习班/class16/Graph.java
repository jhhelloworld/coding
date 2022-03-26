package 算法和数据结构体系学习班.class16;

import java.util.HashMap;
import java.util.HashSet;

public class Graph {
	public HashMap<Integer, Node> nodes;
	public HashSet<Edge> edges;
	
	public Graph() {
		nodes = new HashMap<>();
		edges = new HashSet<>();
	}
}
