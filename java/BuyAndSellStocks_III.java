public class BuyAndSellStocks_III {
    public int maxProfit(int[] prices) {
        Integer[][] dp=new Integer[prices.length][5];
                return solve(0,0,prices,dp);
    }
    private int solve(int idx,int trans,int[] prices,Integer[][] dp)
    {
        if(idx==prices.length||trans==4) return 0;
        if(dp[idx][trans]!=null) return dp[idx][trans];
        if(trans%2==0)
        {
            dp[idx][trans]=Math.max(-prices[idx]+solve(idx+1,trans+1,prices,dp),0+solve(idx+1,trans,prices,dp));
        }else{
            dp[idx][trans]=Math.max(prices[idx]+solve(idx+1,trans+1,prices,dp),0+solve(idx+1,trans,prices,dp));
        }
        return dp[idx][trans];
    }
}

