package Solutions;

public class Problem0605 {
    public boolean canPlaceFlowers(int[] flowerbed,int n) {
        if (n == 0) {
            return true;
        }
        if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        int i = 0;
        while (i < flowerbed.length) {
            if (flowerbed[i] == 0 && (i < 1 || flowerbed[i - 1] == 0) && (i >= flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                --n;
                flowerbed[i] = 1;
                if (n == 0) {
                    return true;
                }
            }
            ++i;
        }
        return false;
    }
}
