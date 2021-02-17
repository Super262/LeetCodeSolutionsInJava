package Algorithm.SearchMethods.BackTracking;

import java.util.LinkedList;
import java.util.List;

public class Problem0017 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        if (digits != null && !digits.isEmpty()) {
            final String[] keys = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
            doCombination(keys,new StringBuilder(digits.length()),digits,result);
        }
        return result;
    }

    private void doCombination(String[] keys,StringBuilder prefix,final String digits,List<String> result) {
        if (prefix.length() == digits.length()) {
            result.add(prefix.toString());
        } else {
            final int curDigit = digits.charAt(prefix.length()) - '0';
            final int curKeyLen = keys[curDigit].length();
            for (int i = 0; i < curKeyLen; ++i) {
                prefix.append(keys[curDigit].charAt(i));
                doCombination(keys,prefix,digits,result);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }
}
