package Arrays;

public class BinarySearch4  {
    public int singleNonDuplicate(int[] nums) {
        int h=nums.length-1;
        if(h==0) return nums[0];
        if(nums[h]!=nums[h-1])return nums[h];
        if(nums[0]!=nums[1])return nums[0];
        int l=1;
        h--;
        int mid=(h+l)/2;
        while(l<=h){
            mid=(h+l)/2;
            if(nums[mid-1]!=nums[mid] && nums[mid]!=nums[mid+1]){
                return nums[mid];
            }
            else if((nums[mid-1]==nums[mid] && mid%2==0)
                    ||
                    (nums[mid+1]==nums[mid] && mid%2==1) ){
                h=mid-1;
            }
            else{
                l=mid+1;
            }

        }
        return -1;
    }
}
