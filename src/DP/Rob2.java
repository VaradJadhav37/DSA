package DP;

public class Rob2 {
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
        int temp =nums[nums.length-1];
        nums[nums.length-1]=0;
        int a1=helper(nums,nums.length-1,dp);
        for(int i=0;i<dp.length;i++){
            dp[i]=-1;

        }
        nums[nums.length-1]=temp;
        nums[0]=0;
        dp[0]=nums[0];
        int a2=helper(nums,nums.length-1,dp);
        return Math.max(a1,a2);
    }
}
