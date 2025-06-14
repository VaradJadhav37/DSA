package DP;

public class Partition {
    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++)
        {
            sum+=nums[i];
        }
        if(sum%2!=0){
            return false;
        }
        sum=sum/2;
        boolean[][] ans=new boolean[nums.length+1][sum+1];
        for(int i=0;i<ans.length;i++){
            ans[i][0]=true;
        }
        for(int i=1;i<ans.length;i++)
        {
            for(int j=1;j<ans[0].length;j++){
                if(nums[i-1]<=j){
                    boolean b1=ans[i-1][j-nums[i-1]];
                    boolean b2=ans[i-1][j];
                    ans[i][j]= b1 || b2;
                }
                else{
                    ans[i][j]=ans[i-1][j];
                }
            }
        }
        return ans[nums.length][sum];
    }
}
