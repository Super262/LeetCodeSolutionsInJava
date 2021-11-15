package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem0241 {
    public List<Integer> diffWaysToCompute(final String s) {
        List<String> parts = new ArrayList<>(s.length());
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    ++j;
                }
                parts.add(s.substring(i,j));
                i = j - 1;
            } else {
                parts.add(s.substring(i,i + 1));
            }
        }
        return dfs(parts,0,parts.size() - 1);
    }

    private List<Integer> dfs(List<String> parts,final int st,final int ed) {
        List<Integer> result = new ArrayList<>();
        if (st > ed) {
            return result;
        }
        if (st == ed) {
            result.add(Integer.parseInt(parts.get(st)));
            return result;
        }
        for (int i = st; i <= ed; ++i) {
            if (!parts.get(i).equals("+") && !parts.get(i).equals("-") && !parts.get(i).equals("*")) {
                continue;
            }
            List<Integer> leftPart = dfs(parts,st,i - 1);
            List<Integer> rightPart = dfs(parts,i + 1,ed);
            for (int x : leftPart) {
                for (int y : rightPart) {
                    if (parts.get(i).equals("+")) {
                        result.add(x + y);
                    } else if (parts.get(i).equals("-")) {
                        result.add(x - y);
                    } else {
                        result.add(x * y);
                    }
                }
            }
        }
        return result;
    }
}