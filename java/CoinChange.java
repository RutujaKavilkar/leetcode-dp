class CoinChange{
public int change(int amount,int[] coins)
{
    int n=coins.length;
    int[][] dp=new int[n][amount+1];
    for(int i=0;i<n;i++)
    {
        dp[i][0]=1;
    }
    for(int i=0;i<n;i++)
    {
        for(int a=1;a<=amount;a++)
        {
            int notTake=(i>0)?dp[i-1][a]:0;
            int take=0;
            if(a>=coins[i])
            {
                take=dp[i][a-coins[i]];
            }
            dp[i][a]=notTake+take;
        }
    }return dp[n-1][amount];

}
}