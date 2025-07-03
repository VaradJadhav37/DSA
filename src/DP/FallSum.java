package DP;
import java.util.*;
public class FallSum  {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }

        int[] nc={-1,0,1};
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int min=Integer.MAX_VALUE;
                for(int k=0;k<3;k++){
                    int col=nc[k]+j;

                    if(col<n && col!=-1){
                        min=Math.min(min,dp[i-1][col]);
                    }
                }
                dp[i][j]=min+matrix[i][j];
            }
        }
        int sum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            sum=Math.min(sum,dp[n-1][i]);
        }
        return sum;
    }
}