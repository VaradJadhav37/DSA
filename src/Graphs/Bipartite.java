package Graphs;
import java.util.*;
public class Bipartite {

        public boolean isBipartite(int[][] graph) {
            int[] color =new int[graph.length];
            for(int i=0;i<graph.length;i++){
                color[i]=-1;
            }
            Queue<Integer> q=new LinkedList<>();
            for(int i=0;i<graph.length;i++){
                if(color[i]==-1){
                    q.add(i);
                    color[i]=0;
                    while(!q.isEmpty()){
                        int curr=q.remove();
                        for(int j=0;j<graph[curr].length;j++){
                            if(color[graph[curr][j]]==-1){
                                color[graph[curr][j]]=color[curr]==0?1:0;
                                q.add(graph[curr][j]);
                            }
                            else if(color[graph[curr][j]]==color[curr])
                            {
                                return false;
                            }
                        }
                    }
                }
            }
            return true;
        }
}

