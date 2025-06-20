package Graphs;
import java.util.*;
public class BFS1 {
    public class Info {
        int i;
        int j;
        int t;

        Info(int i, int j, int t) {
            this.i = i;
            this.j = j;
            this.t = t;
        }
    }

    public int orangesRotting(int[][] grid) {
        Queue<Info> q=new LinkedList<>();
        boolean[][] vis=new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.add(new Info(i,j,0));
                    vis[i][j]=true;
                }
            }
        }
        int tm=0;
        int[] e={-1,0,0,1};
        int[] f={0,-1,1,0};
        while(!q.isEmpty()){
            Info a=q.remove();
            int b=a.i;
            int c=a.j;
            int d=a.t;
            tm=Math.max(tm,d);
            for(int k=0;k<4;k++){
                int nc=c+f[k];
                int nr=b+e[k];
                if (nc >= 0 && nr >= 0 && nc < grid[0].length && nr < grid.length &&
                        !vis[nr][nc] && grid[nr][nc] == 1){
                    grid[nr][nc]=2;
                    q.add(new Info(nr,nc,d+1));
                    vis[nr][nc]=true;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return tm;
    }
}
