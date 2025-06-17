package DP;

public class Jump{
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp =new int[n];
        for(int i=0;i<n-1;i++){
            dp[i]=-1;
        }

        for(int i=n-2;i>=0;i--){
            int min=Integer.MAX_VALUE;
            int pr=nums[i];
            for(int j=i+1;j<=pr+i && j<n;j++){
                if(dp[j]!=-1){
                    int st=dp[j]+1;
                    min=Math.min(st,min);

                }

            }
            if(min!=Integer.MAX_VALUE)
                dp[i]=min;
        }
        return dp[0];
    }
}
