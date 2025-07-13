package Arrays;

public class BinSearch7{
    public int helper(int[] nums, int mid){
        int sum=0;
        int count=1;
        for(int num: nums){
            if(sum+num<=mid){
                sum+=num;
            }
            else{
                count++;
                sum=num;
            }
        }
        return count;
    }
    public int splitArray(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int num : nums){
            max=Math.max(num,max);
            sum+=num;
        }
        int l=max;
        int h=sum;
        int ans=-1;
        while(l<=h){
            int mid=(l+h)/2;
            if(helper(nums,mid)<=k){
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
