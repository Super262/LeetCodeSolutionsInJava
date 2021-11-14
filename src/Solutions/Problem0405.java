package Solutions;

public class Problem0405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        char[] dec2Hex = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder result = new StringBuilder();
        char tempCh;
        while (num != 0) {
            tempCh = dec2Hex[num & 15];
            result.append(tempCh);
            num >>>= 4;
        }
        return result.reverse().toString();
    }
}
