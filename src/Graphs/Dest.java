package Graphs;
import java.util.*;
public class Dest
{
    public class Node {
        int neigh;
        int wt;
        Node(int neigh, int wt) {
            this.neigh = neigh;
            this.wt = wt;
        }
    }

    public class Info implements Comparable<Info> {
        int a;
        long t;
        Info(int a, long t) {
            this.a = a;
            this.t = t;
        }
        @Override
        public int compareTo(Info i2) {
            return Long.compare(this.t, i2.t);
        }
    }

    public int countPaths(int n, int[][] roads) {
        final int MOD = 1_000_000_007;

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] road : roads) {
            graph.get(road[0]).add(new Node(road[1], road[2]));
            graph.get(road[1]).add(new Node(road[0], road[2]));
        }

        long[] dist = new long[n];             // ✅ Changed to long
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(0, 0));

        while (!pq.isEmpty()) {
            Info m = pq.poll();
            int curr = m.a;

            if (m.t > dist[curr]) continue;

            for (Node ni : graph.get(curr)) {
                int ne = ni.neigh;
                long wt = ni.wt;              // ✅ Ensure long

                if (dist[curr] + wt < dist[ne]) {
                    dist[ne] = dist[curr] + wt;
                    ways[ne] = ways[curr];
                    pq.add(new Info(ne, dist[ne]));
                } else if (dist[curr] + wt == dist[ne]) {
                    ways[ne] = (ways[ne] + ways[curr]) % MOD;
                }
            }
        }

        return ways[n - 1];
    }
}

