package leetcode;

/**
 * jh
 * 2019年08月23日  19：50
 */
public class Q_069_Sqrtx {



    public int mySqrt(int x) {
        long r = x;
        while (r*r > x)
        {
            r = (r + x/r) / 2;
        }
        return (int) r;

    }



    public int mySqrt2(int x) {
        if (x == 0)
        {
            return 0;
        }
        int left = 1, right = Integer.MAX_VALUE;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                {
                    return mid;
                }
                left = mid + 1;
            }
        }
    }
}