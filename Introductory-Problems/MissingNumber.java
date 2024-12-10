import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MissingNumber {
    public static void main(String[] args) throws IOException {
        // Set up fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());

        int[] numbers = new int[n - 1];
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 0; i < n - 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;

        while (index < n - 1) {
            int correctIndex = numbers[index] - 1;
            if (correctIndex >= 0 && correctIndex < n - 1 && numbers[index] != numbers[correctIndex]) {
                swap(numbers, index, correctIndex);
            } else {
                index++;
            }
        }

        int missingNumber = n;

        for (int i = 0; i < n - 1; i++) {
            if (numbers[i] - 1 != i) {
                missingNumber = i + 1;
                break;
            }
        }

        System.out.println(missingNumber);

        br.close();
    }

    private static void swap(int[] numbers, int first, int second) {
        int temp = numbers[first];
        numbers[first] = numbers[second];
        numbers[second] = temp;
    }
}
