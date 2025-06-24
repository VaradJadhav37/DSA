package Graphs;
import java.util.*;
public class netDelay {

    public class Info implements Comparable<Info> {
        int neig, t;

        Info(int neig, int t) {
            this.neig = neig;
            this.t = t;
        }

        @Override
        public int compareTo(Info i2) {
            return this.t - i2.t;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Info>> li = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
            li.add(new ArrayList<>());
        }

        for (int[] time : times) {
            li.get(time[0]).add(new Info(time[1], time[2]));
        }

        PriorityQueue<Info> pq = new PriorityQueue<>();


        pq.add(new Info(k, 0));


        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[k] = 0;

        while (!pq.isEmpty()) {
            Info curr = pq.remove();
            int u = curr.neig;
            int time = curr.t;

            if (time > ans[u]) continue;


            for (Info next : li.get(u)) {
                int v = next.neig;
                int weight = next.t;


                if (time + weight < ans[v]) {
                    ans[v] = time + weight;
                    pq.add(new Info(v, ans[v]));
                }
            }
        }


        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (ans[i] == Integer.MAX_VALUE) return -1;
            maxTime = Math.max(maxTime, ans[i]);
        }

        return maxTime;
    }
}

