package DP;

public class Stairs {
    public int helper(int n, int[] arr) {
        if (n == 0 || n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (arr[n] != 0) {
            return arr[n];
        }
        arr[n] = helper(n - 1, arr) + helper(n - 2, arr);
        return arr[n];
    }
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        int[] arr=new int[n+1];
        return helper(n,arr);
    }
}
