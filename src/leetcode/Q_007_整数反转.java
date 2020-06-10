package leetcode;

/**
 * jh
 * 2019年01月10日  10：53
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 123->321
 * -123->-321
 * 120->21
 */
public class Q_007_整数反转 {
    public static long reverse(int x) {
        int[] resultArr = new int[11];
        int index = 1;
        int division = x/10;
        int reminder = x%10;
        long times = 100;
        resultArr[0] = reminder;
        while(division!=0){
            reminder = division%10;
            division = (int)(x/times);
            times = times*10;
            resultArr[index] = reminder;
            index++;
        }
        int length = index;
        long result = 0;
        for(int i = 0;i<length;i++){
            result = result*10 +resultArr[i];
        }
        return result;
    }

    public static int reverse2(int x) {
        int result = 0;
        int maxReminder = Integer.MAX_VALUE/10;
        int minReminder = Integer.MIN_VALUE/10;

        while (x!=0){
            int reminder = x%10;
            x /= 10;
            // 接下来要乘10 ，所以乘10 以后再做判断
            if(result > Integer.MAX_VALUE/10 || result== Integer.MAX_VALUE/10 && reminder> maxReminder ){
                return 0;
            }
            if(result < Integer.MIN_VALUE/10 || result == Integer.MIN_VALUE/10 && reminder<minReminder){
                return 0;
            }
            result = result*10 + reminder;
        }
        return result;

    }

    public static void main(String[] args) {
        int a = 1534236469;
        //System.out.println(reverse(a));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}