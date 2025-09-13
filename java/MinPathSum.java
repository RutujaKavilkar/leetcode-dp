/**
 * LeetCode 64 - Minimum Path Sum
 * 
 * Problem:
 * Given an m x n grid filled with non-negative numbers, find a path from
 * top-left to bottom-right which minimizes the sum of all numbers along its path.
 * You can only move either down or right at any point in time.
 *
 * Approach:
 * 1. Dynamic Programming (DP) is used to solve overlapping subproblems efficiently.
 * 2. Recursive, Memoization, Tabulation, and Space Optimized approaches are demonstrated.
 * 3. Time Complexity: O(m*n)
 * 4. Space Complexity: O(n) for 1D optimized solution.
 */

class MinPathSum {

    // 1️⃣ Recursive approach (for understanding only; not efficient for large grids)
    private int minPathRecursive(int i, int j, int[][] grid) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;  // Out of bounds
        if (i == 0 && j == 0) return grid[0][0];       // Base case: starting cell

        // Minimum path sum from top or left
        return grid[i][j] + Math.min(minPathRecursive(i - 1, j, grid),
                                     minPathRecursive(i, j - 1, grid));
    }

    // 2️⃣ Top-Down Memoization (recursive with cache)
    private int minPathMemo(int i, int j, int[][] grid, int[][] dp) {
        if (i < 0 || j < 0) return Integer.MAX_VALUE;
        if (i == 0 && j == 0) return grid[0][0];

        if (dp[i][j] != -1) return dp[i][j];  // Return cached result

        dp[i][j] = grid[i][j] + Math.min(minPathMemo(i - 1, j, grid, dp),
                                         minPathMemo(i, j - 1, grid, dp));
        return dp[i][j];
    }

    // 3️⃣ Bottom-Up Tabulation (iterative DP)
    private int minPathTabulation(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];  // Starting cell
                else if (i == 0) dp[i][j] = grid[i][j] + dp[i][j - 1]; // First row
                else if (j == 0) dp[i][j] = grid[i][j] + dp[i - 1][j]; // First column
                else dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m - 1][n - 1];
    }

    // 4️⃣ Space Optimized DP (1D array)
    private int minPathOptimized(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];  // Current row
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) temp[j] = grid[i][j];
                else if (i == 0) temp[j] = grid[i][j] + temp[j - 1];
                else if (j == 0) temp[j] = grid[i][j] + dp[j];
                else temp[j] = grid[i][j] + Math.min(dp[j], temp[j - 1]);
            }
            dp = temp;  // Move to next row
        }
        return dp[n - 1];
    }

    // Public method to call the preferred approach
    public int minPathSum(int[][] grid) {
        // You can switch between approaches here:
        // return minPathRecursive(grid.length - 1, grid[0].length - 1, grid);
        // Memoization approach
        // int[][] dp = new int[grid.length][grid[0].length];
        // for (int[] row : dp) Arrays.fill(row, -1);
        // return minPathMemo(grid.length - 1, grid[0].length - 1, grid, dp);

        // Tabulation approach
        return minPathTabulation(grid);

        // Optimized 1D DP approach
        // return minPathOptimized(grid);
    }
}



