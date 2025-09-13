import java.util.Arrays;
/*This Java solution calculates the number of unique paths in a grid with obstacles using recursion
and memoization (Top-Down Dynamic Programming). The algorithm ensures efficient computation
by storing intermediate results in a DP table.
 */
public class uniquePathsWithObstacles {

    public static int f(int i,int j,int[][] grid,int[][] dp)
    {
        if(i>=0&&j>=0&&grid[i][j]==1) return 0;
        if(i==0&&j==0) return 1;
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=f(i-1,j,grid,dp);
        int left=f(i,j-1,grid,dp);
        return dp[i][j]=up+left;

    }
    public int uniquePathsWithObstacle(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp=new int[m][n];
        for(int[] row:dp)
        {
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,grid,dp);
    }
}


