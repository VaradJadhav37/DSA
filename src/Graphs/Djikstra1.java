package Graphs;
import java.util.*;
public class Djikstra1{
    public class Info implements Comparable<Info>{
        int r,c,d;
        Info(int r,int c,int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
        @Override
        public int compareTo(Info i2){
            return this.d-i2.d;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        PriorityQueue<Info> q=new PriorityQueue<>();
        int[][] ans =new int[n][m];
        boolean[][] vis=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        q.add(new Info(0,0,0));
        vis[0][0]=true;
        int[] e={-1,0,0,1};
        int[] f={0,-1,1,0};
        while(!q.isEmpty()){
            Info a=q.remove();
            int ro=a.r;
            int co=a.c;
            int di=a.d;
            if(ro==n-1 && co==m-1)
                return di;
            for(int k=0;k<4;k++){
                int nc=co+f[k];
                int nr=ro+e[k];
                if (nc >= 0 && nr >= 0 && nc < m && nr < n ){
                    int diff=Math.abs(heights[nr][nc]-heights[ro][co]);
                    int l=Math.max(di,diff);
                    if(l<ans[nr][nc]){
                        ans[nr][nc]=l;
                        q.add(new Info(nr,nc,l));
                    }


                }
            }

        }
        return -1;

    }
}
