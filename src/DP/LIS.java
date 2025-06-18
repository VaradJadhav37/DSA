package DP;
import java.util.*;
public class LIS {
    public int lengthOfLIS(int[] nums) {
        TreeSet<Integer> t=new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            t.add(nums[i]);
        }
        int[] arr=new int[t.size()];
        int i=0;
        for(int num:t){
            arr[i]=num;
            i++;
        }
        int[][] dp=new int[nums.length+1][arr.length+1];
        for(i=1;i<nums.length+1;i++){
            for(int j=1;j<arr.length+1;j++){
                if(arr[j-1]==nums[i-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    int a1=dp[i-1][j];
                    int a2=dp[i][j-1];
                    dp[i][j]=Math.max(a1,a2);
                }
            }
        }
        return dp[nums.length][t.size()];
    }
}
