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
 *
 * 类似：最大自序和
 * 烽火问题
 */
public class Q_134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || cost.length != gas.length){
            return -1;
        }
        //当前油量
        int tank = 0;
        //历史油箱总量
        int total = 0;
        int len = gas.length;
        //分别查看以各个节点为头结点能否回到原点
        for(int i = 0;i<gas.length;i++){
            //从当前节点绕行一圈
            tank = 0;
            for(int j = 0;j<len;j++){
                int cur = (j+i)%len;
                tank += gas[cur]-cost[cur];
                if(tank<0){
                    break;
                }
                if(j == len-1){
                    return i;
                }
            }

        }
        return -1;
    }

    //如果生产总量大于或等于消费总量，肯定有解
    //从零开始遍历，如果剩余油量小于0，则从下一个开始，并记录开始位置，最后如果历史总量大于零则返回结果
    public int canCompleteCircuit2(int[] gas, int[] cost) {
        if(gas == null || cost == null || cost.length != gas.length){
            return -1;
        }

        //当前剩余量
        int curSum = 0;
        //从0开始，汽油量
        int historySum = 0;
        int result = 0;
        for(int i = 0;i<gas.length;i++){
            curSum += gas[i]-cost[i];
            historySum += gas[i] - cost[i];
            if(curSum <0){
                result = i+1;
                curSum = 0;
            }
        }
        return historySum<0?-1:result;

    }


}



