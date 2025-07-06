package DP;

public class Stocks{
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][][] dp=new int[n+1][2][k+1];
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<2;j++){
                for(int l=0;l<k+1;l++){
                    if(j==1){
                        int p1=-prices[i]+dp[i+1][0][l];
                        int p2=dp[i+1][1][l];
                        dp[i][j][l]=Math.max(p1,p2);
                    }
                    else {

                        if (l < k) {
                            int p1 = dp[i + 1][1][l + 1] + prices[i];
                            int p2 = dp[i + 1][0][l];
                            dp[i][j][l] = Math.max(p1, p2);
                        } else {

                            dp[i][j][l] = dp[i + 1][0][l];
                        }
                    }
                }
            }
        }
        return dp[0][1][0];
    }
}
