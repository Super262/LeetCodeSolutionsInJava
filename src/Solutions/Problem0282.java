package Solutions;

import java.util.LinkedList;
import java.util.List;

public class Problem0282 {
    public List<String> addOperators(String num,int target) {
        List<String> result = new LinkedList<>();
        StringBuilder path = new StringBuilder(100);
        dfs(num,target,0,0,1,path,result);
        return result;
    }

    void dfs(String num,int target,int curIdx,long a,long b,StringBuilder path,List<String> result) {
        if (curIdx == num.length()) {
            if (a == target) {
                result.add(path.substring(0,path.length() - 1));
            }
            return;
        }
        long c = 0;
        int i;
        for (i = curIdx; i < num.length(); ++i) {
            c = c * 10 + (num.charAt(i) - '0');
            path.append(num.charAt(i));
            path.append('+');
            dfs(num,target,i + 1,a + b * c,1,path,result);
            path.deleteCharAt(path.length() - 1);
            if (i + 1 < num.length()) {
                path.append('-');
                dfs(num,target,i + 1,a + b * c,-1,path,result);
                path.deleteCharAt(path.length() - 1);
            }
            if (i + 1 < num.length()) {
                path.append('*');
                dfs(num,target,i + 1,a,b * c,path,result);
                path.deleteCharAt(path.length() - 1);
            }
            if (num.charAt(curIdx) == '0') {
                ++i;
                break;
            }
        }
        path.delete(path.length() - (i - curIdx),path.length());
    }
}
