package SearchMethods.DFS;

public class Problem0547 {
    public int findCircleNum(int[][] M) {
        int circleNum = 0;
        boolean[] hasVisited = new boolean[M.length];
        for (int i = 0; i < M.length; i++) {
            if (!hasVisited[i]) {
                dfs(M,i,hasVisited);
                circleNum++;
            }
        }
        return circleNum;
    }

    private void dfs(int[][] M,int i,boolean[] hasVisited) {
        hasVisited[i] = true;
        for (int k = 0; k < hasVisited.length; k++) {
            if (M[i][k] == 1 && !hasVisited[k]) {
                dfs(M,k,hasVisited);
            }
        }
    }
}
