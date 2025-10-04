public class BuyAndSellStocks_I {
   
    public int maxProfit(int[] prices) {
        int mini=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++)
        {
           int cost=prices[i]-mini;
           profit=Math.max(cost,profit);
           mini=Math.min(mini,prices[i]); 
        }
        return profit;
    }
}

