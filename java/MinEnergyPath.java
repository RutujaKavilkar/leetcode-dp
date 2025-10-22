
public class MinEnergyPath {
    public static int minEnergy(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // First row
        for (int j = 1; j < n; j++) {
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }

        // First column
        for (int i = 1; i < m; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }

        // Fill rest of dp
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int fromTop = dp[i - 1][j];
                int fromLeft = dp[i][j - 1];
                int fromDiag = dp[i - 1][j - 1];

                dp[i][j] = grid[i][j] + Math.min(fromTop, Math.min(fromLeft, fromDiag));
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
            {5, 9, 6},
            {11, 5, 2},
            {4, 7, 1}
        };

        System.out.println("Minimum Energy: " + minEnergy(grid));
    }
}