package Solutions;

public class Problem1120 {
    public double maximumAverageSubtree(TreeNode root) {
        return helper(root).avgMax;
    }

    private ResultPack helper(TreeNode root) {
        if (root == null) {
            return new ResultPack(0,0,Double.MIN_VALUE);
        }
        ResultPack leftResult = helper(root.left);
        ResultPack rightResult = helper(root.right);
        int rootSum = root.val + leftResult.valuesSum + rightResult.valuesSum;
        int nodesCount = 1 + leftResult.nodesCount + rightResult.nodesCount;
        double rootAvg = (double) rootSum / nodesCount;
        double avgMax = Math.max(rootAvg,Math.max(rightResult.avgMax,leftResult.avgMax));
        return new ResultPack(nodesCount,rootSum,avgMax);
    }

    private static class ResultPack {
        int nodesCount;
        int valuesSum;
        double avgMax;

        ResultPack(int nodesCount,int valuesSum,double avgMax) {
            this.avgMax = avgMax;
            this.nodesCount = nodesCount;
            this.valuesSum = valuesSum;
        }
    }
}
