import java.util.Arrays;

public class KnapSack {
   
    public int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(n - 1, W, wt, val, dp);
    }

    private int solve(int ind, int W, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= W) return val[0];
            else return 0;
        }

        if (dp[ind][W] != -1) return dp[ind][W];

        int notTake = solve(ind - 1, W, wt, val, dp);
        int take = 0;
        if (wt[ind] <= W)
            take = val[ind] + solve(ind - 1, W - wt[ind], wt, val, dp);

        return dp[ind][W] = Math.max(take, notTake);
    }
}


