package Graphs;
import java.util.*;
public class MaxIsland  {
    class DisjointSet {
        List<Integer> size = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();
        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                size.add(1);
                parent.add(i);
            }
        }

        public int findU(int node) {
            if (node == parent.get(node)) return node;
            parent.set(node, findU(parent.get(node))); // path compression
            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int pu = findU(u);
            int pv = findU(v);
            if (pu == pv) return;

            if (size.get(pu) < size.get(pv)) {
                parent.set(pu, pv);
                size.set(pv, size.get(pu) + size.get(pv));
            } else {
                parent.set(pv, pu);
                size.set(pu, size.get(pu) + size.get(pv));
            }
        }
    }

    public int largestIsland(int[][] grid) {
        int n=grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        int[] r={0,0,1,-1};
        int[] c={1,-1,0,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){continue;}
                for(int k=0;k<4;k++){
                    int nr=r[k]+i;
                    int nc=c[k]+j;
                    if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                        ds.unionBySize(i*n+j,nr*n+nc);
                    }
                }

            }
        }
        int mx=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){continue;}
                HashSet<Integer> st=new HashSet<>();
                for(int k=0;k<4;k++){
                    int nr=r[k]+i;
                    int nc=c[k]+j;
                    if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==1){
                        st.add(ds.findU(nr*n+nc));
                    }

                }
                int size=0;
                for(int node:st){
                    size+=ds.size.get(node);
                }
                mx=Math.max(size+1,mx);

            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    return mx;
                }
            }
        }
        return n*n;
    }
}
