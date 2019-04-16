package leetcode;

/**
 * jh
 * 2019年03月05日  20：10
 *
 */
public class Q_013_Roman_To_Integer {
    public static int romanToInt(String s) {
        int num = 0;
        int n = s.length();

        for (int i = 0; i < n-1; i++) {
            int curr = map(s.charAt(i));
            int next = map(s.charAt(i+1));
            num = curr < next ? num - curr : num + curr;
        }

        num += map(s.charAt(n-1));

        return num;
    }

    private static int map(char c) {
        switch(c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}