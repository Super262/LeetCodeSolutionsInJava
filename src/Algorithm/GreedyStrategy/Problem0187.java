package Algorithm.GreedyStrategy;

public class Problem0187 {
    public int canCompleteCircuit(int[] gas,int[] cost) {
        int firstPosition = 0;
        int currentPosition = 0;
        int pathLen;
        int sumOfGas;
        int sumOfCost;
        while (firstPosition < gas.length) {
            pathLen = 0;
            sumOfGas = 0;
            sumOfCost = 0;
            while (pathLen < gas.length) {
                currentPosition = (firstPosition + pathLen) % gas.length;
                sumOfGas += gas[currentPosition];
                sumOfCost += cost[currentPosition];
                if (sumOfCost > sumOfGas) {
                    break;
                } else {
                    ++pathLen;
                }
            }
            if (pathLen == gas.length) {
                return firstPosition;
            } else {
                firstPosition += pathLen + 1;
            }
        }
        return -1;
    }
}
