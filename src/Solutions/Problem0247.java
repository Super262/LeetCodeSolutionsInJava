package Solutions;

import java.util.ArrayList;
import java.util.List;

public class Problem0247 {
    public List<String> findStrobogrammatic(int n) {
        List<List<String>> dict = initialize(n);
        List<String> result = dfs(n,dict);
        int resTop = 0;
        for (int i = 0; i < result.size(); ++i) {
            if (result.get(i).charAt(0) == '0' && result.get(i).length() > 1) {
                continue;
            }
            result.set(resTop++,result.get(i));
        }
        if (result.size() > resTop) {
            result.subList(resTop,result.size()).clear();
        }
        return result;
    }

    private List<List<String>> initialize(final int n) {
        List<List<String>> dict = new ArrayList<>(Math.max(n + 1,3));
        for (int i = 0; i < Math.max(n + 1,3); ++i) {
            dict.add(new ArrayList<>());
        }
        dict.get(1).add("0");
        dict.get(1).add("1");
        dict.get(1).add("8");
        dict.get(2).add("00");
        dict.get(2).add("11");
        dict.get(2).add("69");
        dict.get(2).add("88");
        dict.get(2).add("96");
        return dict;
    }

    private List<String> dfs(final int n,List<List<String>> dict) {
        if (!dict.get(n).isEmpty()) {
            return dict.get(n);
        }
        List<String> mid;
        List<String> sides;
        if (n % 2 != 0) {
            mid = dfs(1,dict);
            sides = dfs(n - 1,dict);
        } else {
            mid = dfs(2,dict);
            sides = dfs(n - 2,dict);
        }
        for (String y : sides) {
            for (String x : mid) {
                String temp = y.substring(0,y.length() / 2) + x + y.substring(y.length() / 2);
                dict.get(n).add(temp);
            }
        }
        return dict.get(n);
    }
}
