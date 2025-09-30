import java.util.Arrays;

public class MinimumInsertToMakeStrPalindrome {
   
    private int[][] dp;
    private int f(int i,int j,String s1,String s2)
    {
        if(i<0||j<0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        {
            return dp[i][j]=1+f(i-1,j-1,s1,s2);
        }
        return dp[i][j]=Math.max(f(i-1,j,s1,s2),f(i,j-1,s1,s2));
    }
    public int minInsertions(String s) {
        String t=new StringBuilder(s).reverse().toString();
        int n=s.length();
        dp=new int[n][n];
        for(int i=0;i<n;i++)
        {
            Arrays.fill(dp[i],-1);
        }
         int LPS=f(n-1,n-1,s,t);
        int insert=s.length()-LPS;
        return insert;
        
    }
}
