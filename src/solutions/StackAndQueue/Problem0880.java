package solutions.StackAndQueue;

public class Problem0880 {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        char[] strArray = S.toCharArray();

        // Find size = length of decoded string
        for (char c : strArray) {
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }


        for(int i = strArray.length - 1; i >= 0; --i){
            // This is quite tricky.

            K %= size;
            if(Character.isDigit(strArray[i])){
                size /= (strArray[i] - '0');
            }
            else{
                if(K == 0){
                    return String.valueOf(strArray[i]);
                }
                // Decrease the size while move one step.
                --size;
            }
        }
        return "";
    }
}
