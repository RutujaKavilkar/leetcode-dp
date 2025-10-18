 import java.util.*;
public class BurstBalloon {
  // ------------------- MEMOIZATION -------------------
    public static int maxCoins(int[] nums) {
        int n = nums.length;

        // Step 1: Add 1 at start and end
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // Step 2: Create dp array
        int[][] dp = new int[n + 2][n + 2];
        for (int[] row : dp) Arrays.fill(row, -1);

        // Step 3: Call recursive function
        return solve(1, n, arr, dp);
    }

    private static int solve(int i, int j, int[] arr, int[][] dp) {
        if (i > j) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        int max = 0;

        // Try bursting every balloon between i and j as the last one
        for (int k = i; k <= j; k++) {
            int coins = arr[i - 1] * arr[k] * arr[j + 1]
                        + solve(i, k - 1, arr, dp)
                        + solve(k + 1, j, arr, dp);

            max = Math.max(max, coins);
        }

        return dp[i][j] = max;
    }


