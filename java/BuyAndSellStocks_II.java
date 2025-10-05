import java.util.Arrays;

public class BuyAndSellStocks_II {
    private static int f(int ind,int buy,int[]prices,int n,int[][] dp)
    {
        if(ind==n) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        int profit;
        if(buy==1)
        {
            profit=Math.max(-prices[ind]+f(ind+1,0,prices,n,dp),0+f(ind+1,1,prices,n,dp));
        }else
        {
            profit=Math.max(prices[ind]+f(ind+1,1,prices,n,dp),0+f(ind+1,0,prices,n,dp));
        }
        return dp[ind][buy]=profit;
        }
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int [n][2];
        for(int[] rows:dp) Arrays.fill(rows,-1);
        return f(0,1,prices,n,dp);
    }
}

