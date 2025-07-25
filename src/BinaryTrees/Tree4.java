package BinaryTrees;

public class Tree4 {

        public class Info implements Comparable<Info> {
            TreeNode node;
            int x, y;

            Info(TreeNode node, int x, int y) {
                this.node = node;
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Info other) {
                if (this.x != other.x) return Integer.compare(this.x, other.x);
                if (this.y != other.y) return Integer.compare(this.y, other.y);
                return Integer.compare(this.node.val, other.node.val);
            }
        }

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
            Queue<Info> queue = new LinkedList<>();
            queue.add(new Info(root, 0, 0));

            while (!queue.isEmpty()) {
                Info curr = queue.poll();
                TreeNode node = curr.node;
                int x = curr.x;
                int y = curr.y;

                map.putIfAbsent(x, new TreeMap<>());
                map.get(x).putIfAbsent(y, new PriorityQueue<>());
                map.get(x).get(y).add(node.val);

                if (node.left != null)
                    queue.add(new Info(node.left, x - 1, y + 1));
                if (node.right != null)
                    queue.add(new Info(node.right, x + 1, y + 1));
            }

            List<List<Integer>> result = new ArrayList<>();
            for (TreeMap<Integer, PriorityQueue<Integer>> yMap : map.values()) {
                List<Integer> vertical = new ArrayList<>();
                for (PriorityQueue<Integer> pq : yMap.values()) {
                    while (!pq.isEmpty()) {
                        vertical.add(pq.poll());
                    }
                }
                result.add(vertical);
            }

            return result;
        }
    }


