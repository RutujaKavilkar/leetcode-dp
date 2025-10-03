public class EditDistance {
    private int[][] dp;
    private int f(int i,int j,String s1,String s2)
    {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j))
        return dp[i][j]=f(i-1,j-1,s1,s2);
        int insert=1+f(i,j-1,s1,s2);
        int delete=1+f(i-1,j,s1,s2);
        int replace=1+f(i-1,j-1,s1,s2);
        return dp[i][j]=Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String s1,String s2)
    {
        int n=s1.length(),m=s2.length();
        dp=new int[n][m];
        for(int[] row:dp)
        java.util.Arrays.fill(row,-1);
        return f(n-1,m-1,s1,s2);
    }
 }

