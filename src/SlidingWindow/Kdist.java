package SlidingWindow;
import java.util.*;
public class Kdist {
    public int helper(int[] nums, int k) {
        HashMap<Integer,Integer> mp=new HashMap<>();
        int cnt=0;
        for(int l=0,r=0;r<nums.length;r++){
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);
            while(mp.size()>k){
                mp.put(nums[l], mp.get(nums[l]) - 1);
                if(mp.get(nums[l])==0){
                    mp.remove(nums[l]);
                }
                l++;

            }
            cnt+=r-l+1;
        }
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return (helper(nums,k)-helper(nums,k-1));
    }
}