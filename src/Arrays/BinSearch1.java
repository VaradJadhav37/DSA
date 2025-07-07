package Arrays;

public class BinSearch1{
    public int searchInsert(int[] nums, int target) {
        int high = nums.length - 1;
        int low = 0;
        int mid = low + (high - low) / 2;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
