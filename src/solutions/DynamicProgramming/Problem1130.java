package solutions.DynamicProgramming;

import java.util.Arrays;

public class Problem1130 {
    public int mctFromLeafValues(int[] arr) {
        if(arr.length == 0){
            return 0;
        }
        int[][] minSum = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; ++i){
            Arrays.fill(minSum[i], Integer.MAX_VALUE);
        }
        for (int subsetLength = 1; subsetLength <= arr.length; ++subsetLength){
            for (int i = 0, j = i + subsetLength - 1; j < arr.length; ++i, ++j){
                if (subsetLength == 1){
                    minSum[i][j] = arr[i];
                }
                else if (subsetLength == 2){
                    minSum[i][j] = arr[i] * arr[j];
                }
                else{
                    for (int k = i; k < j; ++k){
                        int leftFactor = 0, rightFactor = 0, tempValue = 0;
                        for(int leftIndex = i; leftIndex <= k; ++leftIndex){
                            leftFactor = Math.max(leftFactor, arr[leftIndex]);
                        }
                        for(int rightIndex = k + 1; rightIndex <= j; ++rightIndex){
                            rightFactor = Math.max(rightFactor, arr[rightIndex]);
                        }
                        tempValue = leftFactor * rightFactor;
                        if(k - i + 1 > 1){
                            tempValue += minSum[i][k];
                        }
                        if(j - k > 1){
                            tempValue += minSum[k + 1][j];
                        }
                        minSum[i][j] = Math.min(minSum[i][j], tempValue);
                    }
                }
            }
        }
        return minSum[0][arr.length - 1];
    }
}
