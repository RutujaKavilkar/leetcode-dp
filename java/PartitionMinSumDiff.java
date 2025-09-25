import java.util.*;

public class PartitionMinSumDiff {
    private int totalSum;
    private int[][][] dp;
    private int n;

    private int f(int currSum, int count, int idx, int[] arr) {
        if (count == n / 2) {
            int otherSum = totalSum - currSum;
            return Math.abs(currSum - otherSum);
        }
        if (idx >= n) return Integer.MAX_VALUE;

        if (dp[idx][count][currSum] != -1) 
            return dp[idx][count][currSum];

        int take = f(currSum + arr[idx], count + 1, idx + 1, arr);
        int notTake = f(currSum, count, idx + 1, arr);

        return dp[idx][count][currSum] = Math.min(take, notTake);
    }

    public int minimumDifference(int[] arr) {
        n = arr.length;
        totalSum = 0;
        for (int x : arr) totalSum += x;

        dp = new int[n][n / 2 + 1][totalSum + 1];
        for (int[][] table : dp) {
            for (int[] row : table) Arrays.fill(row, -1);
        }

        return f(0, 0, 0, arr);
    }
}



