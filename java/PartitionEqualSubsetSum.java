class Solution {
    private static boolean f(int[] arr,int target,int idx,Boolean[][] dp)
    {
        if(target==0) return true;
        if(idx<0||target<0) return false;
        if(dp[idx][target]!=null) return dp[idx][target];
        boolean notTake=f(arr,target,idx-1,dp);
        boolean take=false;
        if(arr[idx]<=target)
        {
            take=f(arr,target-arr[idx],idx-1,dp);
        }
        dp[idx][target]=take||notTake;
        return dp[idx][target];

    }
    public boolean canPartition(int[] arr) {
        int n=arr.length;
        int sum=0;
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
        }
        int target=sum/2;
        Boolean[][] dp=new Boolean[n][target+1];
        if(sum%2==0)
        {
            return f(arr,target,n-1,dp);
        }else{
            return false;
        }
    }
}