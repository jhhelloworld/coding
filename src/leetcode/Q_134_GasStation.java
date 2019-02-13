package leetcode;

/**
 * jh
 * 2019年01月16日  14：17
 *Q_283_MoveZeroes
 * <p>
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.
 * <p>
 * Note:
 * <p>
 * If there exists a solution, it is guaranteed to be unique.
 * Both input arrays are non-empty and have the same length.
 * Each element in the input arrays is a non-negative integer.
 *
 * gas  = [1,2,3,4,5]
 * cost = [3,4,5,1,2]
 * 3
 */
public class Q_134_GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; i++) {
            int remain = 0;
            int j = i;
            for (int m = 0; m < len; m++) {
                remain += gas[j];
                if (remain < cost[j]) {
                    break;
                } else {
                    remain -= cost[j];
                    j = (++j) % (len);

                }
                if (m == len - 1) {
                    return i;
                }
            }
        }
        return -1;
    }


    public int canCompleteCircuit2(int[] gas, int[] cost) {
        if (gas == null || cost == null)
            return -1;

        int n = gas.length;


        int netSum = 0;
        int curSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            netSum += gas[i] - cost[i];
            curSum += gas[i] - cost[i];
            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }

        if (netSum < 0) {
            return -1;
        } else {
            return start;
        }
    }


}



