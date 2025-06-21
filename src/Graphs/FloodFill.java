package Graphs;
import java.util.*;
public class FloodFill
 {
    public class Info{
        int i,j;
        Info(int i,int j){
            this.i=i;
            this.j=j;
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Info> q=new LinkedList<>();
        int oc=image[sr][sc];
        if( image[sr][sc]==color)
            return image;
        image[sr][sc]=color;
        boolean[][] vis=new boolean[image.length][image[0].length];
        q.add(new Info(sr,sc));
        vis[sr][sc]=true;
        int[] e={-1,0,0,1};
        int[] f={0,-1,1,0};
        while(!q.isEmpty()){
            Info a=q.remove();
            int b=a.i;
            int c=a.j;
            for(int k=0;k<4;k++){
                int nc=c+f[k];
                int nr=b+e[k];
                if (nc >= 0 && nr >= 0 && nc < image[0].length && nr < image.length &&
                        !vis[nr][nc] && image[nr][nc] == oc){
                    image[nr][nc]=color;
                    q.add(new Info(nr,nc));
                    vis[nr][nc]=true;
                }
            }
        }
        return image;
    }
}
