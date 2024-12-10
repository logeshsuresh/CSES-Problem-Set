import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MinimizingCoins {

    static final int INF = (int)1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine().trim());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(st.nextToken());
        }

        int[] cache = new int[x + 1];
        Arrays.fill(cache, -1);

        int minimumCoins = f(coins, n - 1, x, cache);

        System.out.println(minimumCoins == INF ? -1 : minimumCoins);

        br.close();
    }

    private static int f(int[] coins, int idx, int target, int[] cache) {
        if (idx == 0) {
            return (target % coins[0] == 0) ? target / coins[0] : INF;
        }

        if (cache[target] != -1) { return cache[target]; }

        int skip = f(coins, idx - 1, target, cache);
        int take = INF;
        if (coins[idx] <= target) {
            take = f(coins, idx, target - coins[idx], cache) + 1;
        }

        return cache[target] = Math.min(skip, take);
    }
}
