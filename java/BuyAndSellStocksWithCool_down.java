public class BuyAndSellStocksWithCool_down {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] dp=new int[n][2];
        for(int i=0;i<n;i++)
        {
            dp[i][0]=-1;
            dp[i][1]=-1;
                    }
        return f(0,1,prices,dp);
    }
    private int f(int ind,int buy,int[] prices,int[][] dp)
    {
        if(ind>=prices.length) return 0;
        if(dp[ind][buy]!=-1) return dp[ind][buy];
        if(buy==1)
        {
            int take=-prices[ind]+f(ind+1,0,prices,dp);
            int notTake=f(ind+1,1,prices,dp);
         dp[ind][buy]=Math.max(take,notTake);
        }else{
            int sell=prices[ind]+f(ind+2,1,prices,dp);
            int notsell=f(ind+1,0,prices,dp);
           dp[ind][buy]=Math.max(sell,notsell);
        }return dp[ind][buy];
    }
}

