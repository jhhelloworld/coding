package zcy_book_v2.chapter_9_others;

public class Problem_08_ReservoirSampling {
	//产生从 1-k 的随机数
	private static int rand(int k) {
		return (int) (Math.random() * k) + 1;
	}

	public static int[] getKNumsRand(int k, int max) {
		if (max < 1 || k < 1) {
			return null;
		}
		//定义球袋
		int[] res = new int[Math.min(k, max)];
		//第 1——k 个球 直接放入袋中
		for (int i = 0; i < k; i++) {
			res[i] = i + 1;
		}
		//处理第 k+1 —— N 个球
		for (int i = k + 1; i <= max; i++) {
			//这里表示 第 i 个球 进袋 的概率 为 k/i
			if (rand(i) <= k) {
				// i 随机替掉袋子中的一个
				res[rand(k) - 1] = i;
			}
		}
		return res;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] res = getKNumsRand(10, 10000);
		printArray(res);
	}

}
