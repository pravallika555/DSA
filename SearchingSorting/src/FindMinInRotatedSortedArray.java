public class FindMinInRotatedSortedArray {
    //https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
    public int findMin(int[] nums) {
        int pivotIndex = pivot(nums);
        int minIndex = (pivotIndex + 1) % nums.length;
        return nums[minIndex];
    }
    int pivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end - start) / 2;
            if(mid<end && nums[mid] > nums[mid+1])
                return mid;
            if(start<mid && nums[mid] < nums[mid-1])
                return mid-1;
            if(nums[mid] == nums[start]  && nums[mid] == nums[end]){
                if(start<end && nums[start] > nums[start+1])
                    return start;
                start++;
                if(start<end && nums[end] < nums[end-1])
                    return end-1;
                end--;
                //till now left side is sorted

            }else if(nums[start]<nums[mid] || (nums[start]==nums[mid] && nums[end]< nums[mid]))
                start = mid+1;
            else
                end = mid-1;
        }
        return -1;
    }
}
