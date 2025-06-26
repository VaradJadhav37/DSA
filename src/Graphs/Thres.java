package Graphs;
import java.util.*;


public class Thres  {
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
        int t;

        Info(int a, int t) {
            this.a = a;
            this.t = t;
        }

        @Override
        public int compareTo(Info i2) {
            return Integer.compare(this.t, i2.t);
        }
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new Node(edge[1], edge[2]));
            graph.get(edge[1]).add(new Node(edge[0], edge[2]));
        }

        int minCount = Integer.MAX_VALUE;
        int cityWithMinReach = -1;

        for (int l = 0; l < n; l++) {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[l] = 0;

            PriorityQueue<Info> pq = new PriorityQueue<>();
            pq.add(new Info(l, 0));

            while (!pq.isEmpty()) {
                Info m = pq.poll();
                int curr = m.a;
                int currDist = m.t;

                if (currDist > dist[curr]) continue;

                for (Node ni : graph.get(curr)) {
                    int ne = ni.neigh;
                    int wt = ni.wt;
                    if (dist[curr] + wt < dist[ne]) {
                        dist[ne] = dist[curr] + wt;
                        pq.add(new Info(ne, dist[ne]));
                    }
                }
            }


            int count = 0;
            for (int i = 0; i < n; i++) {
                if (i != l && dist[i] <= distanceThreshold) {
                    count++;
                }
            }


            if (count <= minCount) {
                minCount = count;
                cityWithMinReach = l;
            }
        }

        return cityWithMinReach;
    }
}

