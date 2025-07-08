package Arrays;

public class BinSearch2  {
    public int[] searchRange(int[] nums, int target) {
        int high=nums.length-1;
        int low=0;
        int mid=(high+low)/2;
        int first=-1,last=-1;
        while(low<=high){
            mid=(high+low)/2;
            if(nums[mid]==target){
                first=mid;
                high=mid-1;
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        high=nums.length-1;
        low=0;
        mid=(high+low)/2;
        while(low<=high){
            mid=(high+low)/2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(target<nums[mid]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }

        }
        int[] ans={first,last};
        return ans;
    }
}