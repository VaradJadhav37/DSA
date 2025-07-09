package Arrays;

public class BinSearch3 {
    public int findMin(int[] nums) {
        int h=nums.length-1;
        int l=0;
        int min=Integer.MAX_VALUE;
        while(l<=h){
            int mid=(h+l)/2;
            if(nums[l]<=nums[mid]){
                min=Math.min(min,nums[l]);
                l=mid+1;
            }
            else{
                min=Math.min(min,nums[mid]);
                h=mid-1;
            }
        }
        return min;
    }
}