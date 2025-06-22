package Graphs;
import java.util.*;
public class Safe
{
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> revGraph = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            revGraph.add(new ArrayList<>());
        }

        for (int u = 0; u < n; u++) {
            for (int j = 0; j < graph[u].length; j++) {
                int v = graph[u][j];
                revGraph.get(v).add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!q.isEmpty()) {
            int node = q.poll();
            safe[node] = true;

            List<Integer> neighbors = revGraph.get(node);
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}

