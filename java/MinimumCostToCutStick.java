import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutStick {
   
    static int f(int i,int j,List<Integer> cuts,int[][] dp)
    {
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int mini=Integer.MAX_VALUE;
        for(int ind=i;ind<=j;ind++)
        {
            int cost=(cuts.get(j+1)-cuts.get(i-1))+f(i,ind-1,cuts,dp)+f(ind+1,j,cuts,dp);
            mini=Math.min(mini,cost);
            
        }
        return dp[i][j]=mini;
    }
    public int minCost(int n, int[] c) {
        List<Integer> cuts=new ArrayList<>();
        for(int x:c) cuts.add(x);
        cuts.add(0);
        cuts.add(n);
        Collections.sort(cuts);
        int m=cuts.size();
        int[][] dp=new int[m][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        return f(1,m-2,cuts,dp);
    }
} 

