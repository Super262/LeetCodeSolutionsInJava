package Solutions;

import java.util.Arrays;

public class Problem0204 {
    public int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime,true);
        int result = 0;
        long temp;
        for (int num = 2; num < n; ++num) {
            if (isPrime[num]) {
                ++result;
                temp = ((long) num) * ((long) num);
                if (temp < n) {
                    for (long j = temp; j < n; j += num) {
                        isPrime[(int) j] = false;
                    }
                }
            }
        }
        return result;
    }
}
