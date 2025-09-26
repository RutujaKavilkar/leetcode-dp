public class Minimum _coins {
   
    private static int f(int[] coins,int amount,int idx,int[][]dp)
    {
        if(amount==0)
        return 0;
        if(idx<0||amount<0) return Integer.MAX_VALUE;
        int notTake=f(coins,amount,idx-1,dp);
        int take=Integer.MAX_VALUE;
        if(coins[idx]<=amount)
        {
            int res=f(coins,amount-coins[idx],idx,dp);
            if(res!=Integer.MAX_VALUE)
            {
                take=1+res;
            }
        }
       
        return Integer.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int [][] dp=new int[n][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        int ans=f(coins,amount,n-1,dp);
      
        return ans==Integer.MAX_VALUE ?-1:ans;
        
    }
}




