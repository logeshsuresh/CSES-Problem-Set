import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

public class GridPaths {

    private static final int MOD = 1000000007;

    static int n;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine().trim());

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().trim().toCharArray();
        }

        int[][] cache = new int[n][n];
        for (int[] row : cache) Arrays.fill(row, -1);

        int numOfPaths = f(grid, 0, 0, cache);
        System.out.println(numOfPaths);

        br.close();
    }

    private static int f(char[][] grid, int i, int j, int[][] cache) {
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] == '*') { return 0; }

        if (i == n - 1 && j == n - 1) { return 1; }

        if (cache[i][j] != -1) { return cache[i][j]; }

        int moveRight = f(grid, i, j + 1, cache) % MOD;
        int moveDown = f(grid, i + 1, j, cache) % MOD;

        return cache[i][j] = (moveRight + moveDown) % MOD;
    }
}
