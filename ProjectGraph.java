import java.util.Scanner;
import java.util.Arrays;

public class ProjectGraph {
    static int N;
    static int[][] matrix;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("enter you're matrix size");
        N = input.nextInt();
        matrix = new int[N][N];
        fillMatrix(input);

        int result = bellmanFord();
        System.out.println("Minimum path sum: " + result);
    }

    // Method to fill the matrix with values
    public static void fillMatrix(Scanner input) {
        System.out.println("enter you're numbers");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = input.nextInt();
            }
        }
    }

    // Bellman-Ford algorithm to find the minimum path sum
    public static int bellmanFord() {
        int V = N * N; // Number of nodes (flatten the matrix)
        dist = new int[V];
        Arrays.fill(dist, INF); // Initialize all distances as infinite
        dist[0] = matrix[0][0]; // Start from the top-left corner (0,0)

        // Relax the edges V-1 times
        for (int iter = 0; iter < V - 1; iter++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    int node = i * N + j; // Flatten the matrix position to a node
                    // Relax the edges to the right and downward neighbors
                    if (i < N - 1) relax(node, (i + 1) * N + j, matrix[i + 1][j]); // Down
                    if (j < N - 1) relax(node, i * N + (j + 1), matrix[i][j + 1]); // Right
                }
            }
        }

        // Return the minimum path sum to the bottom-right corner (N-1, N-1)
        return dist[V - 1];
    }

    // Relaxation method to update the distances
    public static void relax(int u, int v, int weight) {
        if (dist[u] != INF && dist[u] + weight < dist[v]) {
            dist[v] = dist[u] + weight;
        }
    }
}