package DP;

public class Rob1 {
    public int helper(int[] nums,int i,int[] dp){
        if(i<0){
            return 0;
        }

        if(dp[i]==-1){
            int p=nums[i]+helper(nums,i-2,dp);
            int n=helper(nums,i-1,dp);
            dp[i]=Math.max(p,n);
            return  dp[i];
        }

        return  dp[i];


    }
    public int rob(int[] nums) {
        int[] dp=new int[nums.length];
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;

        }
        dp[0]=nums[0];
        return helper(nums,nums.length-1,dp);
    }
}
