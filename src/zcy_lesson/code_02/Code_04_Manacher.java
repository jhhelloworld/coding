package zcy_lesson.code_02;

public class Code_04_Manacher {

	public static char[] manacherString(String str) {
		char[] charArr = str.toCharArray();
		char[] res = new char[str.length() * 2 + 1];
		int index = 0;
		for (int i = 0; i != res.length; i++) {
			res[i] = (i & 1) == 0 ? '#' : charArr[index++];
		}
		return res;
	}

	public static int maxLcpsLength(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] charArr = manacherString(str);
		int[] pArr = new int[charArr.length]; //回文半径数组，
		int index = -1;   // C
		int pR = -1;  // R
		int max = Integer.MIN_VALUE;
		//求每一个i位置的回文中心
		for (int i = 0; i != charArr.length; i++) {
			//i' 的回文和  i到R的距离哪个小，哪个就是回文区域  （i到R的距离  和 i‘ 的回文半径，哪个短哪个是瓶颈）
			//pR > i  : i在回文右边界里面，这是起码有一个不用去验证的区域 （Math.min(pArr[2 * index - i], pR - i)）
			//2 * index - i 是 i'的位置
			//注意对称点 边界
			//注意while 循环边界   右边界更新
			pArr[i] = pR > i ? Math.min(pArr[2 * index - i], pR - i) : 1;
			//情况2情况3 o(1) 也扩一下，但立刻会失败  情况1和4有可能会成功
			while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
				if (charArr[i + pArr[i]] == charArr[i - pArr[i]])
					pArr[i]++;
				else {
					break;
				}
			}
			if (i + pArr[i] > pR) {
				pR = i + pArr[i];
				index = i;
			}
			//记录全局最大值
			max = Math.max(max, pArr[i]);
		}
		return max - 1;
	}

	public static void main(String[] args) {
		String str1 = "abc1234321ab";
		System.out.println(maxLcpsLength(str1));
	}

}
