package BitManipulation;

public class p1 {
    public int[] countBits(int n) {
        int[] arr = new int[n + 1];
        for (int j = 0; j <= n; j++) {
            int num = j;
            int count = 0;
            while (num > 0) {
                if ((num & 1) != 0) {
                    count++;
                }
                num = num >> 1;
            }
            arr[j] = count;
        }
        return arr;
    }
}