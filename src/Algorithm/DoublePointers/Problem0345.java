package Algorithm.DoublePointers;

public class Problem0345 {
    public String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        char[] sArray = s.toCharArray();
        if (sArray.length < 1) {
            return s;
        }
        int low = 0;
        int high = sArray.length - 1;
        char tempCh;
        while (low < high) {
            while (low < high && isVowel(sArray[high])) {
                --high;
            }
            while (low < high && isVowel(sArray[low])) {
                ++low;
            }
            if (low < high) {
                tempCh = sArray[low];
                sArray[low] = sArray[high];
                sArray[high] = tempCh;
                --high;
                ++low;
            }
        }
        return new String(sArray);
    }

    private boolean isVowel(char ch) {
        return ch != 'A' && ch != 'E' && ch != 'I' && ch != 'O' && ch != 'U' && ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u';
    }
}
