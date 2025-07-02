package Graphs;
import java.util.*;
public class Swim  {
    public class Info implements Comparable<Info> {
        int h, r, c;

        public Info(int h, int r, int c) {
            this.h = h;
            this.r = r;
            this.c = c;
        }

        @Override
        public int compareTo(Info p) {
            return this.h - p.h;
        }
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Info> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];

        pq.add(new Info(grid[0][0], 0, 0));
        visited[0][0] = true;

        int[] nr = {-1, 1, 0, 0};
        int[] nc = {0, 0, 1, -1};

        while (!pq.isEmpty()) {
            Info in = pq.poll();
            int row = in.r;
            int col = in.c;
            int ht = in.h;

            if (row == n - 1 && col == n - 1) return ht;

            for (int k = 0; k < 4; k++) {
                int r1 = row + nr[k];
                int c1 = col + nc[k];

                if (r1 >= 0 && r1 < n && c1 >= 0 && c1 < n && !visited[r1][c1]) {
                    visited[r1][c1] = true;
                    pq.add(new Info(Math.max(ht, grid[r1][c1]), r1, c1));
                }
            }
        }

        return -1;
    }
}
