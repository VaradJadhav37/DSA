package Arrays;

public class BinSearch6  {
    public boolean helper(int[] nums, int threshold,int mid){
        int sum=0;
        for(int num: nums){
            double t=(double)num/mid;
            sum += Math.ceil(t);
        }
        return sum<=threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(max,num);
        }
        int l=1;
        int h=max;
        int ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(helper(nums,threshold,mid)){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}
