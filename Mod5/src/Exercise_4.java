import java.util.ArrayList;
import java.util.List;

public class Exercise_4 {
    public static class Graph {
        static int n = 0;
        List<Integer> adj[];

        Graph(int n) {
            this.n = n;
            adj = new List[n];
            for (int i = 0; i < n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
        }

        void addEdge(int u, int v) {
            adj[u].add(v);
        }

        void dfs(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.print(vertex + " ");
            for (int child : adj[vertex]) {
                if (!visited[child]) {
                    dfs(child, visited);
                }
            }
        }

        void bfs(int vertex, boolean[] visited) {
            visited[vertex] = true;
            List<Integer> queue = new ArrayList<Integer>();
            visited[vertex] = true;
            queue.add(vertex);

            while (queue.size() > 0) {
                vertex = queue.remove(0);
                System.out.print(vertex + " ");

                for (int child : adj[vertex]) {
                    if (!visited[child]) {
                        visited[child] = true;
                        queue.add(child);
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Graph g = new Graph(4);

//        g.addEdge(0, 1);
//        g.addEdge(0, 4);
//        g.addEdge(0, 5);
//        g.addEdge(1, 3);
//        g.addEdge(1, 4);
//        g.addEdge(2, 1);
//        g.addEdge(3, 2);
//        g.addEdge(3, 4);


        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        int root = 2;
        boolean visited[] = new boolean[4];
        System.out.println("DFS: ");
        g.dfs(root, visited);

        visited = new boolean[4];
        System.out.println("\nBFS: ");
        g.bfs(root, visited);
    }
}
