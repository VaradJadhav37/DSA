package Graphs;
import java.util.*;
public class KSTOPS
{
    public class Info {
        int v;
        int cost;
        int stops;
        Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<Info> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        q.add(new Info(src, 0, 0));

        while (!q.isEmpty()) {
            Info curr = q.poll();

            if (curr.stops > k) continue;

            for (int i = 0; i < flights.length; i++) {
                if (flights[i][0] == curr.v) {
                    int s = flights[i][0];
                    int d = flights[i][1];
                    int c = flights[i][2];

                    if (curr.cost + c < dist[d]) {
                        dist[d] = curr.cost + c;
                        q.add(new Info(d, dist[d], curr.stops + 1));
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}


