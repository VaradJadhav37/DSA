package Arrays;

public class BinSearch8 {
    public int hrs(int[] piles, int mid) {
        int totalHours = 0;
        for (int i = 0; i < piles.length; i++) {
            double x = (double) piles[i] / mid;
            int hours = (int) Math.ceil(x);
            totalHours += hours;
        }
        return totalHours;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            max = Math.max(pile, max);
        }


        int min = Integer.MAX_VALUE;
        int l = 1, r = max;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (hrs(piles, mid) <= h) {
                r = mid; // try a smaller k
            } else {
                l = mid + 1; // need larger k
            }
        }

        return l;
    }
}
