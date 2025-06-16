package DP;

public class CoinChange {
    public int change(int amount, int[] coins) {

        int[][] ans=new int[coins.length+1][amount+1];
        for(int i=0;i<ans.length;i++){
            ans[i][0]=1;
        }
        for(int i=1;i<ans.length;i++)
        {
            for(int j=1;j<ans[0].length;j++){
                if(coins[i-1]<=j){
                    if(ans[i][j-coins[i-1]]==-1){

                    }
                    int b1=ans[i][j-coins[i-1]];
                    int b2=ans[i-1][j];
                    ans[i][j]= b1 + b2;
                }
                else{
                    ans[i][j]=ans[i-1][j];
                }
            }

        }
        return ans[coins.length][amount];
    }
}
