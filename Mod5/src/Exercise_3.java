import java.util.ArrayList;
import java.util.List;

public class Exercise_3 {
    public static class Node {
        int value;
        List<Integer> adjacency = new ArrayList<Integer>();

        Node(int value) {
            this.value = value;
        }
    }

    public static List<Node> convertMatrixToList(int[][] matrix) {
        List<Node> adList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            Node v = new Node(i);
            adList.add(v);
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    //     System.out.println("Adding: ");
                    v.adjacency.add(j);
                }
            }
        }
        return adList;
    }

    public static void main(String[] args) {

        // i) Convert from an adjacency matrix to adjacency lists
        int noOfVertices = 5;
        int[][] matrix = {{0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0}};

        List<Node> vertices = convertMatrixToList(matrix);

        System.out.println("Adjacency Matrix: ");
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i).value + " : ");
            for (int j = 0; j < vertices.get(i).adjacency.size(); j++) {
                System.out.print(vertices.get(i).adjacency.get(j) + " , ");
            }
            System.out.println("");
        }

        // ii) Convert from an adjacency list to an incidence matrix.
        // An incidence matrix M has a row for each vertex and a column for each edge, such that M[i, j] = 1 if vertex i is part of edge j, otherwise M[i, j] = 0.

        List<Integer[]> edges = new ArrayList<Integer[]>();
        //    System.out.println("");
        int count = 0;
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.get(i).adjacency.size(); j++) {
                // System.out.println("i: "+i+" j:"+ vertices.get(i).adjacency.get(j));
                if (i <= vertices.get(i).adjacency.get(j)) {
                    edges.add(new Integer[2]);
                    // System.out.println("i: "+i+" j:"+ vertices.get(i).adjacency.get(j)+" j: "+j);
                    //System.out.println("Size: "+edges.size());
                    (edges.get(count))[0] = i;
                    (edges.get(count))[1] = vertices.get(i).adjacency.get(j);
                    count++;
                }
            }
        }

        Integer[][] incidence = new Integer[vertices.size()][edges.size()];
        for (int i = 0; i < vertices.size(); i++) {
            int j = 0;
            for (Integer[] edge : edges) {
                if (edge[0] == vertices.get(i).value || edge[1] == vertices.get(i).value) {
                    incidence[i][j++] = 1;
                } else {
                    incidence[i][j++] = 0;
                }
            }
        }

        System.out.println("\nIncidence Matrix: ");
        for (int i = 0; i < incidence.length; i++) {
            for (int j = 0; j < incidence[i].length; j++) {
                System.out.print(incidence[i][j] + " ");
            }
            System.out.println("");
        }

        //iii) Convert from an incidence matrix to adjacency lists.
        List<Node> adList = new ArrayList<>();
        for (int i = 0; i < incidence.length; i++) {
            Node node = new Node(i);
            for (int j = 0; j < incidence[i].length; j++) {
                if (incidence[i][j] == 1) {
                    // System.out.println("Edge: "+edges.get(j)[0]+" , "+edges.get(j)[1]);
                    int adj = edges.get(j)[0] == i ? edges.get(j)[1] : edges.get(j)[0];
                    node.adjacency.add(adj);
                }
            }
            adList.add(node);
        }

        System.out.println("\nAdjacency Matrix: ");
        for (int i = 0; i < adList.size(); i++) {
            System.out.print(adList.get(i).value + " : ");
            for (int j = 0; j < adList.get(i).adjacency.size(); j++) {
                System.out.print(adList.get(i).adjacency.get(j) + " , ");
            }
            System.out.println("");
        }

    }
}
