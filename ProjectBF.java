import java.util.Scanner;
public class ProjectBF {

    private static int N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int minSum = Integer.MAX_VALUE;

    // Directions for moving: up, down, left, right
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    // Coordinates for start (S) and end (F)
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the size of the map
        N = sc.nextInt();
        map = new int[N][N];
        visited = new boolean[N][N];

        // Read the map values
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
 

        // Start DFS from the given start position
        dfs(0, 0, map[0][0]);

        // Output the minimum sum
        System.out.println(minSum);
        sc.close();
    }

    // Recursive DFS function
    private static void dfs(int x, int y, int currentSum) {
        // If we reached the end point, update the minSum
        if (x == N-1 && y == N-1) {
            minSum = Math.min(minSum, currentSum);
            return;
        }

        // Mark the current cell as visited
        visited[x][y] = true;

        // Explore the four possible directions
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            // Check if the new position is within bounds and not visited
            if (isValid(newX, newY)) {
                dfs(newX, newY, currentSum + map[newX][newY]);
            }
        }

        // Backtrack: unmark the current cell as visited
        visited[x][y] = false;
    }

    // Check if the given coordinates are valid
    private static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && !visited[x][y];
    }
}
