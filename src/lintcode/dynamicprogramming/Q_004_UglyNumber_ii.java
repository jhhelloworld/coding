package lintcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * jh
 * 2019年03月19日  17：28
 */
public class Q_004_UglyNumber_ii {
    /**
     * @param n: An integer
     * @return: return a  integer as description.
     */
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        int x = 0, y = 0, z = 0;
        int[] uglyArr = new int[n];
        uglyArr[0] = 1;
        for (int i = 1; i < n; i++) {
            int a = 2 * uglyArr[x];
            int b = 3 * uglyArr[y];
            int c = 5 * uglyArr[z];
            int min = a < b ? (a < c ? a : c) : (b < c ? b : c);
            uglyArr[i] = min;
            if (min == a) {
                x++;
            }
            if (min == b) {
                y++;
            }
            if (min == c) {
                z++;
            }
        }
        return uglyArr[n - 1];
    }

    public int nthUglyNumber2(int n) {
        List<Integer> uglys = new ArrayList<Integer>();
        uglys.add(1);

        int p2 = 0, p3 = 0, p5 = 0;
        // p2, p3 & p5 share the same queue: uglys

        for (int i = 1; i < n; i++) {
            int lastNumber = uglys.get(i - 1);
            while (uglys.get(p2) * 2 <= lastNumber) p2++;
            while (uglys.get(p3) * 3 <= lastNumber) p3++;
            while (uglys.get(p5) * 5 <= lastNumber) p5++;

            uglys.add(Math.min(
                    Math.min(uglys.get(p2) * 2, uglys.get(p3) * 3),
                    uglys.get(p5) * 5
            ));
        }

        return uglys.get(n - 1);
    }
}