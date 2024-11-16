import java.util.Scanner;

public class BestBubble {
    public static int countSwapsToSortAscending(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        int[] tempArr = arr.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tempArr[j] > tempArr[j + 1]) {
                    int temp = tempArr[j];
                    tempArr[j] = tempArr[j + 1];
                    tempArr[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
    public static int countSwapsToSortDescending(int[] arr) {
        int n = arr.length;
        int swapCount = 0;
        int[] tempArr = arr.clone();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (tempArr[j] < tempArr[j + 1]) {
                    int temp = tempArr[j];
                    tempArr[j] = tempArr[j + 1];
                    tempArr[j + 1] = temp;
                    swapCount++;
                }
            }
        }
        return swapCount;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        int ascendingSwaps = countSwapsToSortAscending(arr);
        int descendingSwaps = countSwapsToSortDescending(arr);
        System.out.println(Math.min(ascendingSwaps, descendingSwaps));
        scanner.close();
    }
}
