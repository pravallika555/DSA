public class RotatedSortedArrayWthoutDuplicates {
    //https://leetcode.com/problems/search-in-rotated-sorted-array/description/
    public int search(int[] nums, int target) {
        int pivot = pivot(nums, target);
        if(pivot == -1)// array is not rotated, so apply normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        if(nums[pivot] == target)
            return pivot;
        else if(target >= nums[0])
            return binarySearch(nums, target, 0, pivot -1);
        else
            return binarySearch(nums, target, pivot+1, nums.length - 1);
    }

    public int binarySearch(int[] nums, int target, int start, int end){
        while(start<=end){
            int mid = start + (end-start) / 2;
            if(target < nums[mid])
                end = mid -1;
            else if(target > nums[mid])
                start = mid +1;
            else
                return mid;
        }
        return -1;
    }

    public int pivot(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <=  end){
            int mid = start + (end-start) / 2;
            if(mid<end && nums[mid] > nums[mid+1])
                return mid;
            if(start<mid && nums[mid]< nums[mid-1])
                return mid-1;
            if(nums[mid] <= nums[start]){
                end = mid -1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }
}
