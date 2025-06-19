package Graphs;

public class DFS1  {
    public void dfs(int[][] isConnected,int i, boolean[] arr){
        arr[i]=true;
        for(int j=0;j<isConnected.length;j++){
            if(isConnected[i][j]==1 && !arr[j]){
                dfs(isConnected,j,arr);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        boolean[] arr=new boolean[isConnected.length];
        for(int i=0;i<arr.length;i++){
            if(!arr[i])
            {
                count++;
                dfs(isConnected,i,arr);
            }
        }
        return count;
    }
}
