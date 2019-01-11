package leetcode;

/**
 * jh
 * 2019年01月10日  10：53
 * Given a 32-bit signed integer, reverse digits of an integer.
 * 123->321
 * -123->-321
 * 120->21
 */
public class Q_007_ReverseInteger {
    public static long reverse(int x) {
        boolean isNegtive = x<0?true:false;
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

    public int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        int a = 1534236469;
        //System.out.println(reverse(a));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}