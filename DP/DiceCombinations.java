import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DiceCombinations {

    public static final int MOD = (int)1e9 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        dp[0] = dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int face = 1; face <= 6; face++) {
                if (i - face >= 0) {
                    dp[i] = (dp[i] % MOD + dp[i - face] % MOD) % MOD;
                }
            }
        }

        System.out.println(dp[n]);
    }
}
