public class FirstAndLastPosition {
    //https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = binarySearch(nums, target, true);
        if(ans[0] != -1)
            ans[1] = binarySearch(nums, target, false);
        return ans;

    }
    public int binarySearch(int[] nums, int target, boolean flag){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(target < nums[mid]){
                end = mid-1;
            }else if(target > nums[mid]){
                start = mid +1;
            }else{
                ans = mid;
                if(flag)
                    end = mid -1;
                else
                    start = mid+1;
            }
        }
        return ans;
    }
}
