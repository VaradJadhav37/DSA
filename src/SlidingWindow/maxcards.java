package SlidingWindow;

public class maxcards  {
    public int maxScore(int[] cardPoints, int k) {
        int sum=0;
        int r=cardPoints.length-1;
        for(int i=0;i<=k-1;i++){
            sum+=cardPoints[i];
        }
        int max=sum;
        for(int i=k-1;i>=0;i--){
            sum=sum-cardPoints[i]+cardPoints[r];
            max=Math.max(max,sum);
            r--;
        }
        return max;
    }
}
