package Graphs;
import java.util.*;
public class Djikstra2
 {
    public class Info{
        int r,c,d;
        Info(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Queue<Info> q=new LinkedList<>();

        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }
        if(n-1==0){
            return 1;
        }
        int[][] ans =new int[n][m];
        boolean[][] vis=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        q.add(new Info(0,0,1));
        vis[0][0]=true;
        int[] e={-1,0,0,1,1,-1,1,-1};
        int[] f={0,-1,1,0,-1,1,1,-1};
        while(!q.isEmpty()){
            Info a=q.remove();
            int ro=a.r;
            int co=a.c;
            int di=a.d;
            for(int k=0;k<8;k++){
                int nc=co+f[k];
                int nr=ro+e[k];
                if (nc >= 0 && nr >= 0 && nc < m && nr < n &&
                        !vis[nr][nc] && grid[nr][nc] == 0){
                    q.add(new Info(nr,nc,di+1));
                    vis[nr][nc]=true;
                    ans[nr][nc] = Math.min(ans[nr][nc], di + 1);

                }
            }

        }
        return ans[n - 1][m - 1] == Integer.MAX_VALUE ? -1 : ans[n - 1][m - 1];

    }
}
