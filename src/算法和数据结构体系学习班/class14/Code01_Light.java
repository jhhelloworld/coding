package 算法和数据结构体系学习班.class14;

import java.util.HashSet;

/**
 给定一个字符串str，只由 `X` 和 `.`两种字符组成。
 `X`表示墙，不能放灯，也不需要点亮
 `.`表示居民点，可以放灯，需要点亮
 如果灯放在 i 位置，可以让 i-1 ,i ,i+1 三个位置点亮
 返回如果点亮str 中所有要点亮的位置，至少需要几盏灯。
 */
public class Code01_Light {

	public static int minLight1(String road) {
		if (road == null || road.length() == 0) {
			return 0;
		}
		return process(road.toCharArray(), 0, new HashSet<>());
	}

	// str[index....]位置，自由选择放灯还是不放灯
	// str[0..index-1]位置呢？已经做完决定了，那些放了灯的位置，存在lights里
	// 要求选出能照亮所有.的方案，并且在这些有效的方案中，返回最少需要几个灯
	public static int process(char[] str, int index, HashSet<Integer> lights) {
		if (index == str.length) { // 结束的时候
			for (int i = 0; i < str.length; i++) {
				if (str[i] != 'X') { // 当前位置是点的话
					if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
						return Integer.MAX_VALUE;
					}
				}
			}
			return lights.size();
		} else { // str还没结束
			// i位置不放灯
			int no = process(str, index + 1, lights);
			// i位置放灯
			int yes = Integer.MAX_VALUE;
			if (str[index] == '.') {
				//放灯
				lights.add(index);
				yes = process(str, index + 1, lights);
				//先加上现场，出来后需要remove掉
				//为什么要恢复现场： 因为始终用一个lights，
				//如果每次都拷贝一个新的，不用恢复现场
				//如果共用老的结构，需要恢复
				// 可以想象出一个二叉树结构，每个选择(放不放灯) 产生一个分叉。假设选择一直是放灯，随着递归深度的增加，SET中一直放值。
				//在回退到上层，或者更极端场景，回退到顶层的时候，肯定希望是一个空set ，因此在每一步放入set,退出当前递归后，都要复原现场

				lights.remove(index);
			}
			return Math.min(no, yes);
		}
	}

	/*
	思路：
	i 位置是 'X' 不能放灯
	i 位置是 '.' , i+1 位置是 'X' i位置必须放灯
	i 位置是 '.' , i+1 位置是 '.' i+2: 'X' 则一定在i+1位置放灯
	i 位置是 '.' , i+1 位置是 '.' i+2: '.' 则一定在i+1位置放灯

	 */
	public static int minLight2(String road) {
		char[] str = road.toCharArray();
		int i = 0;
		int light = 0;
		while (i < str.length) {
			if (str[i] == 'X') {
				i++;
			} else {
				//当前位置是 '.' 从当前位置开始   '.X'  '..X'   '...' 都必然要放一个灯，所以先++
				//如果后面还有位置， 从当前位置开始 '.X' 下一步去 i+2位置做决定
				// '..' 不管i+2 位置是什么，都必须把等放到 i+1位置，接下来去 i+3位置做决定。
				//..X  和 ... 为什么要在 i+1 位置放灯？ 放在i+1 位置分别影响2和3个位置，影响最大，这里体现了贪心思想
				// 有个潜台词： i位置是否放灯，不会被 i前面的结果影响到
				light++;
				//注意 ：i++ 在判断长度的前面
				if (i + 1 == str.length) {
					break;
				} else { // 有i位置  i+ 1   X  .
					if (str[i + 1] == 'X') {
						i = i + 2;
					} else {
						i = i + 3;
					}
				}
			}
		}
		return light;
	}

	// for test
	public static String randomString(int len) {
		char[] res = new char[(int) (Math.random() * len) + 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = Math.random() < 0.5 ? 'X' : '.';
		}
		return String.valueOf(res);
	}

	public static void main(String[] args) {
		int len = 20;
		int testTime = 100000;
		for (int i = 0; i < testTime; i++) {
			String test = randomString(len);
			int ans1 = minLight1(test);
			int ans2 = minLight2(test);
			if (ans1 != ans2) {
				System.out.println("oops!");
			}
		}
		System.out.println("finish!");
	}
}
