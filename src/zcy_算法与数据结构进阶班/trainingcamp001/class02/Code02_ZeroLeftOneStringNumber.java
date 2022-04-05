package zcy_算法与数据结构进阶班.trainingcamp001.class02;

/**
 【题目】
 给定一个数N，想象只有 0 和1  两个字符，组成的所有长度为 N 的字符串
 如果某个字符串，任何0字符串的左边都有1紧挨着，认为这个字符串达标
 返回多少达标的字符串

 N=1 ： 1
 N=2 ： 10,11
 N=3 :  101, 110 ,111

 用1*2的瓷砖，把N*2的区域填满，返回铺瓷砖的方法数
 思路：
 第一块砖竖着摆，剩下 N-1 的位置
 第一块砖横着摆，剩下N-2 的位置
 F(N) = F(N-1) + F(N-2)

 总结：任何一种“严格没有条件转移的表达式” 都可以转化为类似的解法

 */
public class Code02_ZeroLeftOneStringNumber {

	public static int getNum1(int n) {
		if (n < 1) {
			return 0;
		}
		return process(1, n);
	}


	/**
	 * 递归思路
	 */
	public static int process(int i, int n) {
		if (i == n - 1) {
			return 2;
		}
		if (i == n) {
			return 1;
		}
		return process(i + 1, n) + process(i + 2, n);
	}

	public static int getNum2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int pre = 1;
		int cur = 1;
		int tmp = 0;
		for (int i = 2; i < n + 1; i++) {
			tmp = cur;
			cur += pre;
			pre = tmp;
		}
		return cur;
	}


	/**
	 * f(i)含义：注意和位置无关，有i个长度
	 * 如果长度是 i, i的每个 位置可以为 0 ，也可以为1
	 *  i 假想的左侧（不包括i）一定有一个 1
	 *  在这种前提下，i 的长度有几个达标的值
	 *  假设N = 8，则需要调函数 f(7) 因为最左边一定是1
	 *  然后看f(i) 的递归逻辑
	 *  如果 i 第一位是0 ， 下一位只能是1，下一个递归函数就是 f(i-2)
	 *  如果 i 第一位是1 ，下一个递归函数就是 f(i-1)
	 *  所以 f(i) = f(i-1)+f(i-2)
	 */
	public static int getNum3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return 2 * res[0][0] + res[1][0];
	}
	
	
	
	
	
	
	public static int fi(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = { { 1, 1 }, 
				         { 1, 0 } };
		int[][] res = matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}

	
	
	
	public static int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}
		int[][] tmp = m;
		for (; p != 0; p >>= 1) {
			if ((p & 1) != 0) {
				res = muliMatrix(res, tmp);
			}
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}

	public static int[][] muliMatrix(int[][] m1, int[][] m2) {
		int[][] res = new int[m1.length][m2[0].length];
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		for (int i = 0; i != 20; i++) {
			System.out.println(getNum1(i));
			System.out.println(getNum2(i));
			System.out.println(getNum3(i));
			System.out.println("===================");
		}

	}
}
