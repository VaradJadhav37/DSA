package Graphs;
import java.util.*;
public class Union1 {
    class DisjointSet {
        List<Integer> rank = new ArrayList<>();
        List<Integer> parent = new ArrayList<>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                rank.add(0);
                parent.add(i);
            }
        }

        public int findU(int node) {
            if (node == parent.get(node)) {
                return node;
            }
            // Path compression
            parent.set(node, findU(parent.get(node)));
            return parent.get(node);
        }

        public void unionByRank(int u, int v) {
            int ulp_u = findU(u);
            int ulp_v = findU(v);
            if (ulp_u == ulp_v) {
                return;
            }
            if (rank.get(ulp_u) < rank.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
            } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
                parent.set(ulp_v, ulp_u);
            } else {
                parent.set(ulp_v, ulp_u);
                rank.set(ulp_u, rank.get(ulp_u) + 1);
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        DisjointSet ds = new DisjointSet(n);
        int extraEdges = 0;

        for (int[] it : connections) {
            int u = it[0];
            int v = it[1];
            if (ds.findU(u) == ds.findU(v)) {
                extraEdges++;
            } else {
                ds.unionByRank(u, v);
            }
        }


        int components = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findU(i) == i) {
                components++;
            }
        }

        int needed = components - 1;
        return extraEdges >= needed ? needed : -1;
    }
}

