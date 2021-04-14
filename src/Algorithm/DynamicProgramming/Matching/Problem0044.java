package Algorithm.DynamicProgramming.Matching;

public class Problem0044 {
    public boolean isMatch(String s,String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] memo = new boolean[p.length()][s.length()];
        boolean[][] visited = new boolean[p.length()][s.length()];
        return helper(s,0,p,0,memo,visited);
    }

    private boolean helper(String s,int sStartIndex,String p,int pStartIndex,boolean[][] memo,boolean[][] visited) {
        if (pStartIndex == p.length()) {
            return sStartIndex == s.length();
        }
        if (sStartIndex == s.length()) {
            return allStars(p,pStartIndex);
        }
        if (visited[pStartIndex][sStartIndex]) {
            return memo[pStartIndex][sStartIndex];
        }
        boolean currentResult;
        if (p.charAt(pStartIndex) == '*') {
            currentResult = helper(s,sStartIndex + 1,p,pStartIndex,visited,memo) || helper(s,sStartIndex,p,pStartIndex + 1,visited,memo);
        } else {
            currentResult = twoCharsMatched(s.charAt(sStartIndex),p.charAt(pStartIndex)) && helper(s,sStartIndex + 1,p,pStartIndex + 1,memo,visited);
        }
        visited[pStartIndex][sStartIndex] = true;
        memo[pStartIndex][sStartIndex] = currentResult;
        return currentResult;
    }

    private boolean twoCharsMatched(char s,char p) {
        return s == p || p == '?';
    }

    private boolean allStars(String p,int startIndex) {
        for (int i = startIndex; i < p.length(); ++i) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
