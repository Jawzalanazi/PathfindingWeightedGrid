import java.util.Scanner;

public class ProjectDP {

    // Function to find the minimum path sum in the grid
    public static int getMinPathSum(int[][] grid) {
        int size = grid.length;

        // Create an array to store the minimum cost at each cell
        int[][] minCost = new int[size][size];

        // Initialize the first cell
        minCost[0][0] = grid[0][0];

        // Fill the first row with cumulative sums
        for (int col = 1; col < size; col++) {
            minCost[0][col] = minCost[0][col - 1] + grid[0][col];
        }

        // Fill the first column with cumulative sums
        for (int row = 1; row < size; row++) {
            minCost[row][0] = minCost[row - 1][0] + grid[row][0];
        }

        // Fill the rest of the grid by choosing the minimum path
        for (int row = 1; row < size; row++) {
            for (int col = 1; col < size; col++) {
                minCost[row][col] = Math.min(minCost[row - 1][col], minCost[row][col - 1]) + grid[row][col];
            }
        }

        // Return the minimum path sum to the bottom-right corner
        return minCost[size - 1][size - 1];
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("enter yor're matrix size");
        int n = input.nextInt();

        int[][] grid = new int[n][n];

        // Getting the input array from the user
        System.out.println("enter you're numbers");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = input.nextInt();
            }
        }

        // Call the function to calculate the minimum path sum
        int result = getMinPathSum(grid);
        System.out.println("Minimum path sum: " + result);
    }
}